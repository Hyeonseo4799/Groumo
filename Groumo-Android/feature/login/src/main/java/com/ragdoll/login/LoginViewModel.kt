package com.ragdoll.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.ragdoll.domain.usecase.SignUpUseCase
import com.ragdoll.util.context
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.ragdoll.common.result.Result
import com.ragdoll.common.result.asResult
import kotlinx.coroutines.flow.collect

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val signUpUseCase: SignUpUseCase
) : AndroidViewModel(application) {
    companion object {
        const val TAG = "KAKAO_LOGIN"
        const val PLATFORM_KAKAO = "kakao"
    }

    fun kakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            when {
                error != null -> Log.e(TAG, "Failed to login with Kakao account : $error")
                token != null -> {
                    Log.d(TAG, "Successful login with Kakao : $token")
                    viewModelScope.launch {
                        signUpUseCase(token.accessToken, PLATFORM_KAKAO).asResult()
                            .collect { result ->
                                when (result) {
                                    is Result.Error -> Log.e(
                                        TAG,
                                        result.message?.localizedMessage ?: "Unexpected error"
                                    )
                                    is Result.Success -> Log.d(TAG, "Sign up successfully")
                                    Result.Loading -> Log.d(TAG, "Loading")
                                }
                            }
                    }
                }
            }
        }

        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }
}


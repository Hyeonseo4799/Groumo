package com.ragdoll.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.ragdoll.common.result.Result
import com.ragdoll.common.result.asResult
import com.ragdoll.domain.usecase.SignUpUseCase
import com.ragdoll.util.context
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val signUpUseCase: SignUpUseCase,
) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

    fun kakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            when {
                error != null -> _uiState.value = UserUiState.Error(error.localizedMessage)
                token != null -> {
                    viewModelScope.launch {
                        signUpUseCase(token.accessToken, "kakao").asResult().collect { result ->
                            when (result) {
                                is Result.Success -> _uiState.value = UserUiState.Success(result.data)
                                is Result.Error -> _uiState.value = UserUiState.Error(result.message)
                                Result.Loading -> _uiState.value = UserUiState.Loading
                            }
                        }
                    }
                }
            }
        }
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }
}
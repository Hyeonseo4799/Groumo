package com.ragdoll.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.ragdoll.util.context
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    companion object {
        const val TAG = "KAKAO_LOGIN"
    }

    fun kakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            when {
                error != null -> Log.e(TAG, "Failed to login with Kakao account : $error")
                token != null -> Log.d(TAG, "Successful login with Kakao : $token")
            }
        }

        with(UserApiClient.instance) {
            if (isKakaoTalkLoginAvailable(context)) {
                loginWithKakaoTalk(context, callback = callback)
            } else {
                loginWithKakaoAccount(context, callback = callback)
            }
        }
    }
}


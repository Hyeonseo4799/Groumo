package com.ragdoll.groumo

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GroumoApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }
}
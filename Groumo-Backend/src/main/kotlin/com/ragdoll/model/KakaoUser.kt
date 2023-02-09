package com.ragdoll.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KakaoUser(
    @SerialName("connected_at") val connectedAt: String,
    val id: Long,
    @SerialName("kakao_account") val kakaoAccount: KakaoAccount,
    val properties: Properties
) {
    @Serializable
    data class KakaoAccount(
        val email: String,
        @SerialName("email_needs_agreement") val emailNeedsAgreement: Boolean,
        @SerialName("has_email") val hasEmail: Boolean,
        @SerialName("is_email_valid") val isEmailValid: Boolean,
        @SerialName("is_email_verified") val isEmailVerified: Boolean,
        val profile: Profile,
        @SerialName("profile_image_needs_agreement") val profileImageNeedsAgreement: Boolean,
        @SerialName("profile_nickname_needs_agreement") val profileNicknameNeedsAgreement: Boolean
    ) {
        @Serializable
        data class Profile(
            @SerialName("is_default_image") val isDefaultImage: Boolean,
            val nickname: String,
            @SerialName("profile_image_url") val profileImageUrl: String,
            @SerialName("thumbnail_image_url") val thumbnailImageUrl: String
        )
    }

    @Serializable
    data class Properties(
        val nickname: String,
        @SerialName("profile_image") val profileImage: String,
        @SerialName("thumbnail_image") val thumbnailImage: String
    )
}
package com.ragdoll.route

import com.ragdoll.dao.DAOFacade
import com.ragdoll.model.KakaoUser
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

const val KAKAO = "kakao"
const val GOOGLE = "google"

fun Route.userRoute(dao: DAOFacade, client: HttpClient) {
    post("user/{platform}") {
        val token = call.request.header("token")

        when (call.parameters["platform"]) {
            KAKAO -> {
                val userInfo: KakaoUser = client.get("https://kapi.kakao.com/v2/user/me") {
                    headers {
                        append(HttpHeaders.Authorization, "Bearer $token")
                    }
                }.body()

                dao.insertUser(
                    KAKAO,
                    userInfo.properties.nickname,
                    userInfo.properties.thumbnailImage,
                    userInfo.kakaoAccount.email
                )
            }

            GOOGLE -> {}
        }
    }
}
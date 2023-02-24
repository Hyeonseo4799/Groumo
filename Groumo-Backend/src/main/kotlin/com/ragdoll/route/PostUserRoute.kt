package com.ragdoll.route

import com.ragdoll.dao.DAOFacade
import com.ragdoll.model.KakaoUser
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val KAKAO = "kakao"
const val GOOGLE = "google"

fun Route.postUserRoute(dao: DAOFacade, client: HttpClient) {
    post("user/{platform}") {
        val token = call.request.header("token")

        when (call.parameters["platform"]) {
            KAKAO -> {
                val userInfo: KakaoUser = client.get("https://kapi.kakao.com/v2/user/me") {
                    headers { append(HttpHeaders.Authorization, "Bearer $token") }
                }.body()

                with(userInfo) {
                    if (dao.getUser(KAKAO, kakaoAccount.email) == null)
                        dao.insertUser(KAKAO, properties.nickname, properties.thumbnailImage, kakaoAccount.email)

                    call.respond(HttpStatusCode.OK, mapOf("userId" to dao.getUser(KAKAO, kakaoAccount.email)?.userId))
                }
            }

            GOOGLE -> {}
        }
    }
}
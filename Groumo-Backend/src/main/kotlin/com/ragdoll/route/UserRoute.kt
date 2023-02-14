package com.ragdoll.route

import com.ragdoll.dao.DAOFacade
import com.ragdoll.model.KakaoUser
import com.ragdoll.model.Response
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import java.sql.BatchUpdateException
import java.sql.SQLIntegrityConstraintViolationException

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

                try {
                    dao.insertUser(
                        KAKAO,
                        userInfo.properties.nickname,
                        userInfo.properties.thumbnailImage,
                        userInfo.kakaoAccount.email
                    )
                    call.respond(Response(code = HttpStatusCode.Created.value, error = null))
                } catch (e: Exception) {
                    when ((e as? ExposedSQLException)?.cause) {
                        is BatchUpdateException, is SQLIntegrityConstraintViolationException -> {
                            call.respond(
                                Response(
                                    code = HttpStatusCode.BadRequest.value,
                                    error = "이미 회원가입 된 유저입니다."
                                )
                            )
                        }

                        else -> {
                            call.respond(
                                Response(
                                    code = HttpStatusCode.InternalServerError.value,
                                    error = "예기치 못한 오류"
                                )
                            )
                        }
                    }
                }
            }

            GOOGLE -> {}
        }
    }
}
package com.ragdoll.data.model

import com.ragdoll.data.ConstraintViolationException
import com.ragdoll.data.ServerFailException
import com.ragdoll.model.Response
import com.ragdoll.network.model.NetworkResponse

fun NetworkResponse.asResponse(): Response {
    return when (code) {
        200 -> Response(code, error)
        400 -> throw ConstraintViolationException(error)
        else -> throw ServerFailException(error)
    }
}
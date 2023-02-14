package com.ragdoll.data

class ConstraintViolationException(error: String?): Exception(error)

class ServerFailException(error: String?): Exception(error)
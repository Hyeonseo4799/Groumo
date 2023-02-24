package com.ragdoll.model

data class Group(
    val id: Int,
    val groupName: String,
    val description: String,
    val creator: String,
    val initialFunds: Int,
    val endDate: String
)

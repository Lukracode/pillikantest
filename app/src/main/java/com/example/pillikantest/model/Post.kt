package com.example.pillikantest.model

data class Post(

    val id: Int,
    val iin: String,
    val surname: String,
    val firstname: String,
    val patronymic: String,
    val password: String,
    val roles: List<RolesList>,
    val enabled: Boolean,
    val username: String,
    val credentialsNonExpired: Boolean,
    val accountNonExpired: Boolean,
    val authorities: List<AuthoList>,
    val accountNonLocked: Boolean

)


data class RolesList(
    val id: Int,
    val name: String
)

data class AuthoList(
    val authority: String
)


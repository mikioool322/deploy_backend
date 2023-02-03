package com.pl.sggw.tinder.domain.addUser

import java.time.LocalDateTime

data class UserDto(
    val userEmail : String,
    val password : String,
    val time : LocalDateTime
)

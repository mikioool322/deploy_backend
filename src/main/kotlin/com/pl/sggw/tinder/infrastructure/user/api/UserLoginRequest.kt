package com.pl.sggw.tinder.infrastructure.user.api

import com.pl.sggw.tinder.domain.Gender
import com.pl.sggw.tinder.domain.addUser.Degree

data class UserLoginRequest(
    val userEmail: String,
    val password: String,
)

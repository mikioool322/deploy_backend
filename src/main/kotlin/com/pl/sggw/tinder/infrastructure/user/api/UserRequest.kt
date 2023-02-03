package com.pl.sggw.tinder.infrastructure.user.api

import com.pl.sggw.tinder.domain.Gender
import com.pl.sggw.tinder.domain.addUser.Degree

data class UserRequest(
    val userEmail: String,
    val password: String,
    val userName: String,
    val description: String?,
    val phoneNumber: String,
    val photo: String?,
    val gender: Gender,
    val age: Short,
    val degree: Degree
)

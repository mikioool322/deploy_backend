package com.pl.sggw.tinder.domain.addUser

import com.pl.sggw.tinder.domain.Gender
import java.time.LocalDateTime

data class UserPreferencesDto(
    val userEmail :String,
    val gender: Gender,
    val minAge: Short,
    val maxAge: Short,
    val time : LocalDateTime
)

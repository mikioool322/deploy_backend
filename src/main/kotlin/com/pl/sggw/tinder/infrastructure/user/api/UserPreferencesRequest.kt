package com.pl.sggw.tinder.infrastructure.user.api

import com.pl.sggw.tinder.domain.Gender

data class UserPreferencesRequest(
    val gender: Gender,
    val minAge: Short,
    val maxAge: Short
)

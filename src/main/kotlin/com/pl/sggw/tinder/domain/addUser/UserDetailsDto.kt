package com.pl.sggw.tinder.domain.addUser

import com.pl.sggw.tinder.domain.Gender
import java.time.LocalDateTime

data class UserDetailsDto(
    val userEmail: String,
    val description: String?,
    val phoneNumber: String?,
    val photo: String?,
    val gender: Gender?,
    val age: Short?,
    val degree: Degree?,
    val time : LocalDateTime
)

enum class Degree {
    COMPUTER_SCIENCE,
    MEDICINE,
    DIETETICS,
    PEDAGOGY,
    JOURNALISM
}

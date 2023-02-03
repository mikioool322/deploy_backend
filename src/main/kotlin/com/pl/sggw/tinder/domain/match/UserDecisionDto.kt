package com.pl.sggw.tinder.domain.match

import java.time.LocalDateTime

data class UserDecisionDto (
    val selectingUserEmail : String,
    val selectedUserEmail : String,
    val selectedUserApproved : Boolean,
    val time : LocalDateTime
)

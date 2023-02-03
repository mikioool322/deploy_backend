package com.pl.sggw.tinder.domain.match

import java.time.LocalDateTime

data class UserDecisionDto (
    val selectingUserId : Long,
    val selectedUserId : Long,
    val selectedUserApproved : Boolean,
    val time : LocalDateTime
)

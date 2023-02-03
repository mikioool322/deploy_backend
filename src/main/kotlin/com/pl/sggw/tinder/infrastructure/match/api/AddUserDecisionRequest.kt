package com.pl.sggw.tinder.infrastructure.match.api

data class AddUserDecisionRequest(
    val selectingUserId : Long,
    val selectedUserId: Long,
    val selectedUserApproved : Boolean
)


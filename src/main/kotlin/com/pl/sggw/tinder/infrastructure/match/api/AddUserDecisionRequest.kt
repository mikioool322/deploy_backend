package com.pl.sggw.tinder.infrastructure.match.api

data class AddUserDecisionRequest(
    val selectingUserEmail : String,
    val selectedUserEmail: String,
    val selectedUserApproved : Boolean
)


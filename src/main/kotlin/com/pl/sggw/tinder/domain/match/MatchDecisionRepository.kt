package com.pl.sggw.tinder.domain.match

interface MatchDecisionRepository {
   fun addDecision(userDecisionDto : UserDecisionDto)
    fun getApproveddUserIdForUser(userEmail: String) : List<Long?>
    fun isMatched(firstUserId: Long,secondUserId: Long): Boolean
}
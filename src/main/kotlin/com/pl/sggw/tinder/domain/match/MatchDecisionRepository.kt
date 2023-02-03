package com.pl.sggw.tinder.domain.match

interface MatchDecisionRepository {
   fun addDecision(userDecisionDto : UserDecisionDto)

   fun deleteDecision(userDecisionDto: UserDecisionDto)
    fun getApproveddUserIdForUser(userEmail: String) : List<String?>
    fun isMatched(firstUserEmail: String,secondUserEmail: String): Boolean
}
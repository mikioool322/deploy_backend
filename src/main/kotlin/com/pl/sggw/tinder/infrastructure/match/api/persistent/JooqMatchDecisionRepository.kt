package com.pl.sggw.tinder.infrastructure.match.api.persistent

import com.pl.sggw.tinder.domain.match.MatchDecisionRepository
import com.pl.sggw.tinder.domain.match.UserDecisionDto
import com.pl.sggw.tinder.jooq.tables.references.TINDER_USER
import com.pl.sggw.tinder.jooq.tables.references.USER_MATCH_DECITION
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
class JooqMatchDecisionRepository(val ctx: DSLContext) : MatchDecisionRepository {
    override fun addDecision(userDecisionDto: UserDecisionDto) {
        ctx.insertInto(USER_MATCH_DECITION)
            .columns(
                USER_MATCH_DECITION.SELECTING_USER_EMAIL,
                USER_MATCH_DECITION.SELECTED_USER_EMAIL,
                USER_MATCH_DECITION.SELECTED_USER_APPROVED,
                USER_MATCH_DECITION.CREATION_TIMESTAMP,
                USER_MATCH_DECITION.MODIFICATION_TIMESTAMP
            )
            .values(
                userDecisionDto.selectingUserEmail,
                userDecisionDto.selectedUserEmail,
                userDecisionDto.selectedUserApproved,
                userDecisionDto.time,
                userDecisionDto.time
            )
            .execute()
    }

    override fun deleteDecision(userDecisionDto: UserDecisionDto) {
        ctx.deleteFrom(USER_MATCH_DECITION)
            .where(USER_MATCH_DECITION.SELECTING_USER_EMAIL.eq(userDecisionDto.selectingUserEmail))
            .and(USER_MATCH_DECITION.SELECTED_USER_EMAIL.eq(userDecisionDto.selectedUserEmail))
            .execute()
    }

    override fun getApproveddUserIdForUser(userEmail: String): List<String?> {
        return ctx.select()
            .from(USER_MATCH_DECITION)
            .where(USER_MATCH_DECITION.SELECTING_USER_EMAIL.eq(userEmail))
            .and(USER_MATCH_DECITION.SELECTED_USER_APPROVED)
            .fetch(USER_MATCH_DECITION.SELECTED_USER_EMAIL)
    }

    override fun isMatched(firstUserEmail: String, secondUserEmail: String): Boolean {
        val firstUserPossiblePartners = ctx.select()
            .from(USER_MATCH_DECITION)
            .where(USER_MATCH_DECITION.SELECTING_USER_EMAIL.eq(firstUserEmail))
            .and(USER_MATCH_DECITION.SELECTED_USER_APPROVED)
            .fetch(USER_MATCH_DECITION.SELECTED_USER_EMAIL)
        val secondPossiblePartners = ctx.select()
            .from(USER_MATCH_DECITION)
            .where(USER_MATCH_DECITION.SELECTING_USER_EMAIL.eq(secondUserEmail))
            .and(USER_MATCH_DECITION.SELECTED_USER_APPROVED)
            .fetch(USER_MATCH_DECITION.SELECTED_USER_EMAIL)
        return firstUserPossiblePartners.contains(secondUserEmail) && secondPossiblePartners.contains(firstUserEmail)
    }
}
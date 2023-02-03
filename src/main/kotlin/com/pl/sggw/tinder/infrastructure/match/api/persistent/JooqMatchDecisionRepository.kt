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
                USER_MATCH_DECITION.SELECTING_USER_ID,
                USER_MATCH_DECITION.SELECTED_USER_ID,
                USER_MATCH_DECITION.SELECTED_USER_APPROVED,
                USER_MATCH_DECITION.CREATION_TIMESTAMP,
                USER_MATCH_DECITION.MODIFICATION_TIMESTAMP
            )
            .values(
                userDecisionDto.selectingUserId,
                userDecisionDto.selectedUserId,
                userDecisionDto.selectedUserApproved,
                userDecisionDto.time,
                userDecisionDto.time
            )
            .execute()
    }

    override fun getApproveddUserIdForUser(userEmail: String): List<Long?> {
        return ctx.select()
            .from(USER_MATCH_DECITION)
            .join(TINDER_USER)
            .on(USER_MATCH_DECITION.SELECTING_USER_ID.eq(TINDER_USER.ID))
            .where(TINDER_USER.USER_EMAIL.eq(userEmail))
            .and(USER_MATCH_DECITION.SELECTED_USER_APPROVED)
            .fetch(USER_MATCH_DECITION.SELECTED_USER_ID)
    }

    override fun isMatched(firstUserId: Long, secondUserId: Long): Boolean {
        val firstUserPossiblePartners = ctx.select()
            .from(USER_MATCH_DECITION)
            .where(USER_MATCH_DECITION.SELECTING_USER_ID.eq(firstUserId))
            .and(USER_MATCH_DECITION.SELECTED_USER_APPROVED)
            .fetch(USER_MATCH_DECITION.SELECTED_USER_ID)
        val secondPossiblePartners = ctx.select()
            .from(USER_MATCH_DECITION)
            .where(USER_MATCH_DECITION.SELECTING_USER_ID.eq(secondUserId))
            .and(USER_MATCH_DECITION.SELECTED_USER_APPROVED)
            .fetch(USER_MATCH_DECITION.SELECTED_USER_ID)
        return firstUserPossiblePartners.contains(secondUserId) && secondPossiblePartners.contains(firstUserId)
    }
}
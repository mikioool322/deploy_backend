package com.pl.sggw.tinder.infrastructure.user.api.persistent

import com.pl.sggw.tinder.domain.Gender
import com.pl.sggw.tinder.domain.addUser.*

import com.pl.sggw.tinder.jooq.tables.references.TINDER_USER
import com.pl.sggw.tinder.jooq.tables.references.USER_PREFERENCES
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime


@Transactional
@Repository
class JooqUserRepository(val ctx: DSLContext) : UserRepository {
    override fun addUser(userDto: UserDto) {
        ctx.insertInto(TINDER_USER)
            .columns(
                TINDER_USER.PASSWORD,
                TINDER_USER.USER_EMAIL,
                TINDER_USER.CREATION_TIMESTAMP,
                TINDER_USER.MODIFICATION_TIMESTAMP
            )
            .values(
                userDto.password,
                userDto.userEmail,
                userDto.time,
                userDto.time
            )
            .onConflictDoNothing()
            .execute()
    }

    override fun upsertUserDetails(userDetailsDto: UserDetailsDto) {
        ctx.update(TINDER_USER)
            .set(TINDER_USER.PHONE_NUMBER, userDetailsDto.phoneNumber)
            .set(TINDER_USER.PHOTO, userDetailsDto.photo)
            .set(TINDER_USER.DESCRIPTION, userDetailsDto.description)
            .set(TINDER_USER.GENDER, userDetailsDto.gender.toString())
            .set(TINDER_USER.AGE, userDetailsDto.age)
            .set(TINDER_USER.DEGREE, userDetailsDto.degree.toString())
            .set(TINDER_USER.MODIFICATION_TIMESTAMP, userDetailsDto.time)
            .where(TINDER_USER.USER_EMAIL.eq(userDetailsDto.userEmail))
            .execute()
    }

    override fun findUserDetailsByEmail(userEmail: String): UserDetailsDto? {
        return ctx.select()
            .from(TINDER_USER)
            .where(TINDER_USER.USER_EMAIL.eq(userEmail))
            .fetch { r -> mapToUserDetailsDto(r) }
            .firstOrNull()
    }

    override fun getUserDetailsById(userId: Long): UserDetailsDto {
        return ctx.select()
            .from(TINDER_USER)
            .where(TINDER_USER.ID.eq(userId))
            .fetch { r -> mapToUserDetailsDto(r) }
            .first()
    }

    override fun getAllPossiblePartnerForUser(userPreferencesDto: UserPreferencesDto): List<UserDetailsDto> {
        return ctx.select()
            .from(TINDER_USER)
            .where(
                TINDER_USER.AGE.greaterOrEqual(userPreferencesDto.minAge)
                    .or(TINDER_USER.AGE.lessOrEqual(userPreferencesDto.maxAge))
            )
            .and(TINDER_USER.GENDER.eq(userPreferencesDto.gender.toString()))
            .fetch { r -> mapToUserDetailsDto(r) }
    }

    override fun upsertUserPreferences(userPreferencesDto: UserPreferencesDto) {
        ctx.insertInto(USER_PREFERENCES)
            .columns(
                USER_PREFERENCES.USER_EMAIL,
                USER_PREFERENCES.GENDER,
                USER_PREFERENCES.MIN_AGE,
                USER_PREFERENCES.MAX_AGE,
                USER_PREFERENCES.CREATION_TIMESTAMP,
                USER_PREFERENCES.MODIFICATION_TIMESTAMP
            )
            .values(
                userPreferencesDto.userEmail,
                userPreferencesDto.gender.toString(),
                userPreferencesDto.minAge,
                userPreferencesDto.maxAge,
                userPreferencesDto.time,
                userPreferencesDto.time
            )
            .onConflict(USER_PREFERENCES.USER_EMAIL)
            .doUpdate()
            .set(USER_PREFERENCES.GENDER, userPreferencesDto.gender.toString())
            .set(USER_PREFERENCES.MIN_AGE, userPreferencesDto.minAge)
            .set(USER_PREFERENCES.MAX_AGE, userPreferencesDto.maxAge)
            .set(USER_PREFERENCES.MODIFICATION_TIMESTAMP, userPreferencesDto.time)
            .execute()
    }

    override fun getUserPreferences(userEmail: String): UserPreferencesDto? {
        return ctx.select()
            .from(USER_PREFERENCES)
            .where(USER_PREFERENCES.USER_EMAIL.eq(userEmail))
            .fetch { r ->
                UserPreferencesDto(
                    userEmail = r.getValue(USER_PREFERENCES.USER_EMAIL) as String,
                    gender = Gender.valueOf(r.getValue(USER_PREFERENCES.USER_EMAIL) as String),
                    minAge = r.getValue(USER_PREFERENCES.MIN_AGE) as Short,
                    maxAge = r.getValue(USER_PREFERENCES.MAX_AGE) as Short,
                    time = r.getValue(USER_PREFERENCES.MODIFICATION_TIMESTAMP) as LocalDateTime
                )
            }
            .firstOrNull()
    }

    override fun getUserId(userEmail: String): Long {
        return ctx.select()
            .from(TINDER_USER)
            .where(TINDER_USER.USER_EMAIL.eq(userEmail))
            .fetch(TINDER_USER.ID)
            .first()!!
    }

    override fun findUserId(userEmail: String): Long? {
        return ctx.select()
            .from(TINDER_USER)
            .where(TINDER_USER.USER_EMAIL.eq(userEmail))
            .fetch(TINDER_USER.ID)
            .first()
    }

    private fun mapToUserDetailsDto(r: Record) = UserDetailsDto(
        userEmail = r.getValue(TINDER_USER.USER_EMAIL)!!,
        description = r.getValue(TINDER_USER.DESCRIPTION),
        phoneNumber = r.getValue(TINDER_USER.PHONE_NUMBER) ,
        photo = r.getValue(TINDER_USER.PHOTO),
        gender = r.getValue(TINDER_USER.GENDER)?.let { Gender.valueOf(it) },
        age = r.getValue(TINDER_USER.AGE),
        degree = r.getValue(TINDER_USER.DEGREE)?.let { Degree.valueOf(it) },
        time = r.getValue(TINDER_USER.MODIFICATION_TIMESTAMP)!!,
    )
}
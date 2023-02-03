package com.pl.sggw.tinder.infrastructure.user.api

import com.pl.sggw.tinder.domain.addUser.UserRepository
import com.pl.sggw.tinder.domain.addUser.UserDetailsDto
import com.pl.sggw.tinder.domain.addUser.UserDto
import com.pl.sggw.tinder.domain.addUser.UserPreferencesDto
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun addNewUser(userDto: UserDto): Boolean {
        return userRepository.addUser(userDto)
    }

    fun getUserId(userEmail: String): Long {
        return userRepository.getUserId(userEmail)
    }

    fun findUserId(userEmail: String): Long? {
        return userRepository.findUserId(userEmail)
    }

    fun addUserDetails(userDetailsDto: UserDetailsDto) {
        userRepository.findUserId(userDetailsDto.userEmail)?.let {
            userRepository.upsertUserDetails(userDetailsDto)
        }
    }

    fun findUserDetails(userEmail: String): UserDetailsDto? {
        return userRepository.findUserDetailsByEmail(userEmail)
    }

    fun addUserPreferences(userPreferencesDto: UserPreferencesDto) {
        userRepository.upsertUserPreferences(userPreferencesDto)
    }

    fun getAllPossiblePartnerForUser(userEmail: String): List<UserDetailsDto> {
        val userPreferences = userRepository.getUserPreferences(userEmail)
        return if (userPreferences == null) {
            emptyList()
        } else {
            userRepository.getAllPossiblePartnerForUser(userPreferences)
        }
    }

    fun getUserDetailsById(userEmail: String): UserDetailsDto {
        return userRepository.getUserDetailsByEmail(userEmail)
    }

    fun tryLogin(userDto: UserDto): Boolean {
        return userRepository.tryLogin(userDto)
    }
}
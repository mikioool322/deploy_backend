package com.pl.sggw.tinder.infrastructure.user.api

import com.pl.sggw.tinder.domain.addUser.UserDetailsDto
import com.pl.sggw.tinder.domain.addUser.UserDto
import com.pl.sggw.tinder.domain.addUser.UserPreferencesDto
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime


@Api(value = "add-user", description = "Rest api for user managing")
@RequestMapping("/api/user")
@RestController
class UserController(val userService: UserService) {

    @PostMapping("/")
    @ApiOperation("Add new tinder user")
    fun addUser(@RequestBody request: UserRequest): ResponseEntity<Void> {
        return if (userService.addNewUser(
                UserDto(
                    password = request.password,
                    userEmail = request.userEmail,
                    time = OffsetDateTime.now().toLocalDateTime()
                )
            )
        ) {
            userService.addUserDetails(
                UserDetailsDto(
                    userEmail = request.userEmail,
                    userName = request.userName,
                    description = request.description,
                    phoneNumber = request.phoneNumber,
                    photo = request.photo,
                    gender = request.gender,
                    age = request.age,
                    degree = request.degree,
                    time = OffsetDateTime.now().toLocalDateTime()
                )
            )
            ResponseEntity.ok().build()
        } else {
            ResponseEntity(HttpStatus.CONFLICT)
        }
    }

    @PostMapping("/login")
    @ApiOperation("Try login")
    fun login(@RequestBody request: UserLoginRequest): ResponseEntity<Void> {
        return if (userService.tryLogin(
                UserDto(
                    password = request.password,
                    userEmail = request.userEmail,
                    time = OffsetDateTime.now().toLocalDateTime()
                )
            )
        ) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }

    @PostMapping("/{userEmail}/details")
    @ApiOperation("Add user details")
    fun addUserDetails(@RequestBody request: UserDetailsRequest, @PathVariable userEmail: String) {
        userService.addUserDetails(
            UserDetailsDto(
                userEmail = userEmail,
                userName = request.userName,
                description = request.description,
                phoneNumber = request.phoneNumber,
                photo = request.photo,
                gender = request.gender,
                age = request.age,
                degree = request.degree,
                time = OffsetDateTime.now().toLocalDateTime()
            )
        )
    }

    @GetMapping("/{userEmail}/details")
    @ApiOperation("Get details about user")
    fun getUserDetails(@PathVariable userEmail: String): ResponseEntity<UserDetailsDto> {
        val userDetails = userService.findUserDetails(userEmail)
        return if (userDetails == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok().body(userDetails)
        }
    }

    @PostMapping("/{userEmail}/preferences")
    @ApiOperation("Add user preferences")
    fun addUserPreferences(@RequestBody request: UserPreferencesRequest, @PathVariable userEmail: String) {
        userService.addUserPreferences(
            UserPreferencesDto(
                userEmail = userEmail,
                gender = request.gender,
                minAge = request.minAge,
                maxAge = request.maxAge,
                time = OffsetDateTime.now().toLocalDateTime()
            )
        )
    }

    @GetMapping("/{userEmail}/preferences")
    @ApiOperation("Get all possible user partner")
    fun getPossibleUserPartner(@PathVariable userEmail: String): List<UserDetailsDto> {
        return userService.getAllPossiblePartnerForUser(userEmail)
    }

}
package com.pl.sggw.tinder.infrastructure.match.api

import com.pl.sggw.tinder.domain.addUser.UserDetailsDto
import com.pl.sggw.tinder.domain.match.MatchDecisionRepository
import com.pl.sggw.tinder.domain.match.UserDecisionDto
import com.pl.sggw.tinder.infrastructure.user.api.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime


@Api(value = "user-matches", description = "Rest api for  user matches handling")
@RequestMapping("/api/user-matches")
@RestController
class MatchController(
    val matchDecisionRepository: MatchDecisionRepository,
    val userService: UserService
) {

    @PostMapping("/add-decision")
    @ApiOperation("Add the user's decision about the potential partner")
    fun addUserDecision(@RequestBody request: AddUserDecisionRequest) {
        matchDecisionRepository.addDecision(
            UserDecisionDto(
                selectingUserId = request.selectingUserId,
                selectedUserId = request.selectedUserId,
                selectedUserApproved = request.selectedUserApproved,
                time = OffsetDateTime.now().toLocalDateTime()
            )
        )
    }

    @GetMapping("/{userEmail}")
    @ApiOperation("Get pairs for user")
    fun getPairsUsers(@PathVariable userEmail: String): List<UserDetailsDto> {
        val matchedForUser = matchDecisionRepository.getApproveddUserIdForUser(userEmail)
        val userId = userService.getUserId(userEmail)
        return matchedForUser
            .mapNotNull { it }
            .filter { matchDecisionRepository.isMatched(it, userId) }
            .map { userService.getUserDetailsById(it) }
            .toList()
    }
}
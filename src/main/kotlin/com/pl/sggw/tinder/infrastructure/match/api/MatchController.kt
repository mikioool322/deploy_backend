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
        val userDecisionDto = UserDecisionDto(
            selectingUserEmail = request.selectingUserEmail,
            selectedUserEmail = request.selectedUserEmail,
            selectedUserApproved = request.selectedUserApproved,
            time = OffsetDateTime.now().toLocalDateTime()
        )
        matchDecisionRepository.deleteDecision(userDecisionDto)
        matchDecisionRepository.addDecision(userDecisionDto)
    }

    @GetMapping("/{userEmail}")
    @ApiOperation("Get pairs for user")
    fun getUserPairs(@PathVariable userEmail: String): List<UserDetailsDto> {
        val matchedForUser = matchDecisionRepository.getApproveddUserIdForUser(userEmail)
        return matchedForUser
            .mapNotNull { it }
            .filter { matchDecisionRepository.isMatched(it, userEmail) }
            .map { userService.getUserDetailsById(it) }
            .toList()
    }

}
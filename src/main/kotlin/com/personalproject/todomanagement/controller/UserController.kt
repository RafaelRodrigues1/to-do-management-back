package com.personalproject.todomanagement.controller

import com.personalproject.todomanagement.model.User
import com.personalproject.todomanagement.model.dto.UserLoginDTO
import com.personalproject.todomanagement.model.dto.UserSaveDTO
import com.personalproject.todomanagement.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun saveUser(@RequestBody user: UserSaveDTO): User = userService.saveUser(user)

    @GetMapping
    fun findAllUsers(): List<User> = userService.findAllUsers()

    @PostMapping("/login")
    fun login(@RequestBody userLogin: UserLoginDTO): User = userService.login(userLogin)

    @PostMapping("/confirmaCadastro")
    fun confirmaCadastro(@RequestParam("id") id: UUID) = userService.confirmaCadastro(id)
}

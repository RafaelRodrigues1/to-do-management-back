package com.personalproject.todomanagement.model.dto

import com.personalproject.todomanagement.model.User
import com.personalproject.todomanagement.model.UserStatus
import com.personalproject.todomanagement.utils.EncryptUtil
import lombok.Data
import java.util.*

@Data
data class UserSaveDTO (
    val name: String,
    val email: String,
    val senha: String
)

fun UserSaveDTO.toEntitySave() = User(
    id = UUID.randomUUID(),
    name = name,
    null,
    email = email,
    senha = EncryptUtil.md5(senha),
    registerDate = Date(),
    status = UserStatus.PENDENTE
)

@Data
data class UserLoginDTO (
    val email: String,
    val senha: String
)

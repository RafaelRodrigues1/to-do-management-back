package com.personalproject.todomanagement.service

import com.personalproject.todomanagement.model.User
import com.personalproject.todomanagement.model.dto.UserLoginDTO
import com.personalproject.todomanagement.model.dto.UserSaveDTO
import com.personalproject.todomanagement.model.dto.toEntitySave
import com.personalproject.todomanagement.repository.UserRepository
import com.personalproject.todomanagement.utils.EncryptUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun saveUser(user: UserSaveDTO): User {
        val userToSave = user.toEntitySave()
        return userRepository.save(userToSave)
    }

    fun findAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun login(userLogin: UserLoginDTO): User {
        val listUsers: List<User> = userRepository.findByEmail(userLogin.email)
        val user: User = if(listUsers.isNotEmpty()) listUsers[0] else throw Exception("Email não cadastrado")
        return if(EncryptUtil.compareHashMd5(userLogin.senha, user.senha!!)) user else throw Exception("Senha incorreta")
    }

    fun confirmaCadastro(registration: String): User? {
        //ENVIAR PARA FILA DE EMAIL DE CONFIRMAÇÃO
        val user: User? = userRepository.verifyUserProcessingStatusByRegistration(registration)
        return user?.let {
            userRepository.confirmaCadastro(it.id!!)
            return it
        } ?: throw Exception("Usuário com cadastro já finalizado")
    }

}

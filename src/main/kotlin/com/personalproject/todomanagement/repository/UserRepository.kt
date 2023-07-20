package com.personalproject.todomanagement.repository

import com.personalproject.todomanagement.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {

    fun findByEmail(email: String): List<User>

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = 'ATIVO' WHERE u.id = :id")
    fun confirmaCadastro(@Param("id") id: UUID)
}

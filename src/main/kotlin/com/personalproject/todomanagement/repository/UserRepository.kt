package com.personalproject.todomanagement.repository

import com.personalproject.todomanagement.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {

    fun findByEmail(email: String): List<User>
}

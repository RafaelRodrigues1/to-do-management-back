package com.personalproject.todomanagement.model

import jakarta.persistence.*
import lombok.Data
import java.util.Date

@Data
@Entity
@Table(name = "users")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "name")
        val name: String?,
        @Column(name = "matriculation")
        val matriculation: String?,
        @Column(name = "email")
        val email: String?,
        @Column(name = "dt_register")
        val registerDate: Date?
)
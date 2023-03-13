package com.personalproject.todomanagement.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "user")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "name")
        val name: String,
        @Column(name = "matriculation")
        val matriculation: String,
        @Column(name = "email")
        val email: String,
        @Column(name = "dt_register")
        val registerDate: Date,
        @OneToMany(mappedBy = "user")
        val likes: List<Like>,
        @OneToMany(mappedBy = "user")
        val comments: List<Comment>,
        @OneToMany(mappedBy = "registerUser")
        val projects: List<Project>,
        @OneToMany(mappedBy = "registerUser")
        val status: List<Status>,
        @OneToMany(mappedBy = "registerUser")
        val registeredTasks: List<Task>,
        @OneToMany(mappedBy = "responsible")
        val responsibleTasks: List<Task>
)
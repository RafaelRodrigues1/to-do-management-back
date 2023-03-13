package com.personalproject.todomanagement.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "project")
data class Project (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @OneToMany(mappedBy = "project")
        val tasks: List<Task>,
        @Column(name = "dt_register")
        val registerDate: Date,
        @Column(name = "dt_alteration")
        val alterationDate: Date,
        @ManyToOne
        @JoinColumn(name = "register_user")
        val registerUser: User
)
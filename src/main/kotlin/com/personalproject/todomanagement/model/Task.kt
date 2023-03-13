package com.personalproject.todomanagement.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "task")
data class Task (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,
        @Column(name = "title")
        val title: String,
        @Column(name = "description")
        val description: String,
        @Column(name = "dt_register")
        val registerDate: Date,
        @Column(name = "dt_alteration")
        val alterationDate: Date,
        @OneToMany(mappedBy = "task")
        val comments: List<Comment>,
        @ManyToOne
        @JoinColumn(name = "id_project")
        val project: Project,
        @ManyToOne
        @JoinColumn(name = "id_status")
        val status: Status,
        @ManyToOne
        @JoinColumn(name = "register_user")
        val registerUser: User,
        @ManyToOne
        @JoinColumn(name = "responsible_user")
        val responsible: User

)

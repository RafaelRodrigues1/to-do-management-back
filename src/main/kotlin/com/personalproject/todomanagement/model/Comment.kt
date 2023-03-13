package com.personalproject.todomanagement.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "comment")
data class Comment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,
        @Column(name = "description")
        val description: String,
        @Column(name = "dt_register")
        val registerDate: Date,
        @Column(name = "dt_alteration")
        val alterationDate: Date,
        @OneToMany(mappedBy = "comment")
        val likes: List<Like>,
        @ManyToOne
        @JoinColumn(name = "id_task")
        val task: Task,
        @ManyToOne
        @JoinColumn(name = "id_user")
        val user: User
)

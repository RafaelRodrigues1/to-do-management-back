package com.personalproject.todomanagement.model

import jakarta.persistence.*

@Entity
@Table(name = "like")
data class Like (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @ManyToOne
        @JoinColumn(name = "id_comment")
        val comment: Comment,
        @ManyToOne
        @JoinColumn(name = "id_user")
        val user: User
)

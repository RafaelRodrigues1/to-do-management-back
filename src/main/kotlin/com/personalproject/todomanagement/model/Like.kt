package com.personalproject.todomanagement.model

import jakarta.persistence.*
import lombok.Data

@Data
@Entity
@Table(name = "likes")
data class Like (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_comment")
        val comment: Comment,
        @ManyToOne
        @JoinColumn(name = "id_user")
        val user: User
)

package com.personalproject.todomanagement.model

import jakarta.persistence.*
import lombok.Data
import java.util.Date

@Data
@Entity
@Table(name = "comment")
data class Comment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "description")
        val description: String,
        @Column(name = "dt_register")
        val registerDate: Date,
        @Column(name = "dt_alteration")
        val alterationDate: Date,
        @OneToMany(mappedBy = "comment")
        val likes: List<Like>,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_task")
        val task: Task,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_user")
        val user: User
)

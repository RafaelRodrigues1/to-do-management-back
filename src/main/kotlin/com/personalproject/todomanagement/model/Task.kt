package com.personalproject.todomanagement.model

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Data
@Entity
@Table(name = "task")
data class Task (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "title", nullable = false)
        val title: String,
        @Column(name = "description", nullable = false)
        val description: String,
        @Column(name = "dt_register")
        var registerDate: Date?,
        @Column(name = "dt_alteration")
        var alterationDate: Date?,
        @OneToMany(mappedBy = "task")
        val comments: List<Comment>?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_project")
        val project: Project,
        @ManyToOne
        @JoinColumn(name = "id_status")
        val status: Status,
        @ManyToOne
        @JoinColumn(name = "register_user")
        val registerUser: User?,
        @ManyToOne
        @JoinColumn(name = "responsible_user")
        val responsible: User

)

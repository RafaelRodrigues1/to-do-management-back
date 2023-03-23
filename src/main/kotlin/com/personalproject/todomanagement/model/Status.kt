package com.personalproject.todomanagement.model

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Data
@Entity
@Table(name = "status")
data class Status (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "name", nullable = false)
        val name: String,
        @Column(name = "description", nullable = false)
        val description: String,
        @Column(name = "dt_register")
        var registerDate: Date?,
        @Column(name = "dt_alteration")
        val alterationDate: Date?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "register_user")
        val registerUser: User?,
        @OneToMany(mappedBy = "status")
        val tasks: List<Task>?
)
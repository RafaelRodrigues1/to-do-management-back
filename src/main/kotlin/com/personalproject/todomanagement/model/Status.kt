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
        @Column(name = "name")
        val name: String,
        @Column(name = "dt_register")
        val registerDate: Date,
        @Column(name = "dt_alteration")
        val alterationDate: Date,
        @Column(name = "description")
        val description: String,
        @ManyToOne
        @JoinColumn(name = "register_user")
        val registerUser: User,
        @OneToMany(mappedBy = "status")
        val tasks: List<Task>
)
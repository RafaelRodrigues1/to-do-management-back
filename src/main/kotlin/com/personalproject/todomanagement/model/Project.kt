package com.personalproject.todomanagement.model

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Data
@Entity
@Table(name = "project")
data class Project (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "name", nullable = false)
        val name: String,
        @Column(name = "description", nullable = false)
        val description: String,
        @OneToMany(mappedBy = "project", cascade = [CascadeType.REMOVE])
        val tasks: List<Task>,
        @Column(name = "dt_register", nullable = false)
        var registerDate: Date?,
        @Column(name = "dt_alteration")
        var alterationDate: Date?,
        @ManyToOne
        @JoinColumn(name = "register_user", nullable = false)
        val registerUser: User?
)
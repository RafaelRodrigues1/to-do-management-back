package com.personalproject.todomanagement.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*
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
        val name: String?,
        @Column(name = "description", nullable = false)
        val description: String?,
        @JsonBackReference(value="project-tasks")
        @OneToMany(mappedBy = "project", cascade = [CascadeType.REMOVE])
        val tasks: List<Task>?,
        @Column(name = "dt_register")
        var registerDate: Date?,
        @Column(name = "dt_alteration")
        var alterationDate: Date?,
        @ManyToOne
        @JoinColumn(name = "register_user")
        val registerUser: User?,
        @ManyToOne
        @JoinColumn(name = "responsible_user", nullable = false)
        val responsible: User?
)

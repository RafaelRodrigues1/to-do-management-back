package com.personalproject.todomanagement.repository

import com.personalproject.todomanagement.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository: JpaRepository<Task, Long> {

    fun findByProject(id: Long): List<Task>
}
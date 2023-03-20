package com.personalproject.todomanagement.service

import com.personalproject.todomanagement.model.Task
import com.personalproject.todomanagement.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class TaskService {

    @Autowired
    private lateinit var taskRepository: TaskRepository

    fun findByProjectId(projectId: Long): List<Task> = taskRepository.findByProject(projectId)

    fun findById(id: Long): Task {
        val task: Task = taskRepository.findById(id).orElseThrow { NotFoundException() }
        task.comments
        return task
    }
}

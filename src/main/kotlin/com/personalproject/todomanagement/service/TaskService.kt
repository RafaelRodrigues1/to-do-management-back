package com.personalproject.todomanagement.service

import com.personalproject.todomanagement.model.Project
import com.personalproject.todomanagement.model.Status
import com.personalproject.todomanagement.model.Task
import com.personalproject.todomanagement.repository.StatusRepository
import com.personalproject.todomanagement.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService {

    @Autowired
    private lateinit var taskRepository: TaskRepository

    @Autowired
    private lateinit var statusRepository: StatusRepository

    fun findByProjectId(projectId: Long): List<Task> {
        return taskRepository.findByProjectId(projectId)
    }

    fun findTaskById(id: Long): Task {
        val task: Task = taskRepository.findById(id).orElseThrow { NotFoundException() }
        task.comments
        return task
    }

    fun saveTask(task: Task): Task {
        if(task.registerUser == null) {
            throw IllegalArgumentException()
        }
        if(task.registerDate == null) {
            task.registerDate = Date()
        }
        return taskRepository.save(task)
    }

    fun updateTask(task: Task): Task? {
        val taskId = task.responsible?.let { taskRepository.updateTask(task.title, task.description, it.id, Date(), task.id).toLong() }
        return taskId?.let { findTaskById(it) }
    }

    fun updateTaskStatus(id: Long, statusId: Long): Status? {
        val taskId = taskRepository.updateTaskStatus(statusId, Date(), id).toLong()
        return taskId?.let { statusRepository.findByTaskId(it) }
    }
}

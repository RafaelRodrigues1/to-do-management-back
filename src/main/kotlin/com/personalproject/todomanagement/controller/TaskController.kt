package com.personalproject.todomanagement.controller

import com.personalproject.todomanagement.model.Status
import com.personalproject.todomanagement.model.Task
import com.personalproject.todomanagement.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("task")
class TaskController {

    @Autowired
    private lateinit var taskService: TaskService

    @GetMapping
    fun findByProjectId(@RequestParam projectId: Long): List<Task> = taskService.findByProjectId(projectId)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Task = taskService.findTaskById(id)

    @PostMapping
    fun saveTask(@RequestBody task: Task): Task = taskService.saveTask(task)

    @PutMapping
    fun updateTask(@RequestBody task: Task): Task? = taskService.updateTask(task)

    @PutMapping("/{id}/updateStatus/{statusId}")
    fun updateTaskStatus(@PathVariable id: Long, @PathVariable statusId: Long): Status? = taskService.updateTaskStatus(id, statusId)
}
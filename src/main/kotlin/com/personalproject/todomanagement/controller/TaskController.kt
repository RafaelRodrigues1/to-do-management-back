package com.personalproject.todomanagement.controller

import com.personalproject.todomanagement.model.Task
import com.personalproject.todomanagement.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("task")
class TaskController {

    @Autowired
    private lateinit var taskService: TaskService

    @GetMapping
    fun findByProjectId(@RequestParam projectId: Long): List<Task> = taskService.findByProjectId(projectId)

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): Task = taskService.findById(id)
}
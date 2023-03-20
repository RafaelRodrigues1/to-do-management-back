package com.personalproject.todomanagement.controller

import com.personalproject.todomanagement.model.Project
import com.personalproject.todomanagement.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("project")
class ProjectController {

    @Autowired
    private lateinit var projectService: ProjectService

    @GetMapping
    fun findAllProjects(): List<Project> = projectService.findAllProjects()

    @GetMapping("/{id}")
    fun findProjectById(@PathVariable id: Long): Project = projectService.findProjectById(id)

    @PostMapping
    fun saveProject(@RequestBody project: Project): Project = projectService.saveProject(project)
}
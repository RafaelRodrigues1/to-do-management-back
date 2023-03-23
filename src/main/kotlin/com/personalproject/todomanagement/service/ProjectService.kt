package com.personalproject.todomanagement.service

import com.personalproject.todomanagement.model.Project
import com.personalproject.todomanagement.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.Date

@Service
class ProjectService {

    @Autowired
    private lateinit var projectRepository: ProjectRepository

    fun findAllProjects(): List<Project> = projectRepository.findAll(Sort.by("id"))

    fun findProjectById(id: Long): Project = projectRepository.findById(id).orElseThrow{ NotFoundException() }

    fun saveProject(project: Project): Project {
        if(project.registerDate == null) {
            project.registerDate = Date()
        }
        return projectRepository.save(project)
    }

    fun updateProject(project: Project): Project {
        val projectId = projectRepository.updateProject(project.name, project.description, project.responsible.id, Date(), project.id).toLong()
        return findProjectById(projectId)
    }
}
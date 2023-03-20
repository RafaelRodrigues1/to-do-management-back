package com.personalproject.todomanagement.repository

import com.personalproject.todomanagement.model.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectRepository: JpaRepository<Project, Long>  {
}
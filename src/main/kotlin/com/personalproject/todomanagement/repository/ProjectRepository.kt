package com.personalproject.todomanagement.repository

import com.personalproject.todomanagement.model.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface ProjectRepository: JpaRepository<Project, Long>  {

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "UPDATE project p SET p.name = :name, p.description = :description, " +
            "p.responsible_user = :responsibleId, p.dt_alteration = :dataAlteration WHERE p.id = :id", nativeQuery = true)
    fun updateProject(@Param("name") name: String, @Param("description") description: String,
                      @Param("responsibleId") responsibleId: Long, @Param("dataAlteration") dataAlteration: Date,
                      @Param("id") id: Long): Integer
}
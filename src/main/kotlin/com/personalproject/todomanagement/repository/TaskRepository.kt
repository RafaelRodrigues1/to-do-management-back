package com.personalproject.todomanagement.repository

import com.personalproject.todomanagement.model.Task
import com.personalproject.todomanagement.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface TaskRepository: JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM task t WHERE t.id_project = :projectId", nativeQuery = true)
    fun findByProjectId(@Param("projectId") projectId: Long): List<Task>

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "UPDATE task t SET t.title = :title, t.description = :description, " +
            "t.responsible_user = :responsibleId, t.dt_alteration = :dataAlteration WHERE t.id = :id", nativeQuery = true)
    fun updateTask(@Param("title") title: String?, @Param("description") description: String?,
                      @Param("responsibleId") responsibleId: UUID?, @Param("dataAlteration") dataAlteration: Date,
                      @Param("id") id: Long): Integer

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "UPDATE task t SET t.id_status = :statusId, t.dt_alteration = :dataAlteration WHERE t.id = :id", nativeQuery = true)
    fun updateTaskStatus(@Param("statusId") statusId: Long?, @Param("dataAlteration") dataAlteration: Date, @Param("id") id: Long): Integer
}

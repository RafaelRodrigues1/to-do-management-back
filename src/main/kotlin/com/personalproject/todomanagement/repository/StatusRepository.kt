package com.personalproject.todomanagement.repository;

import com.personalproject.todomanagement.model.Status
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface StatusRepository: JpaRepository<Status, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE status s SET s.name = :name, s.description = :description, " +
            "s.dt_alteration = :dataAlteration WHERE s.id = :id", nativeQuery = true)
    fun updateStatus(@Param("name") name: String, @Param("description") description: String,
                     @Param("dataAlteration") dataAlteration: Date, @Param("id") id: Long): Integer
}
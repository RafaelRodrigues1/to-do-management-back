package com.personalproject.todomanagement.controller

import com.personalproject.todomanagement.model.Status
import com.personalproject.todomanagement.repository.StatusRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.ArrayList
import java.util.Date

@RestController
@RequestMapping("status")
class StatusController {

    @Autowired
    private lateinit var statusRepository: StatusRepository

    @GetMapping
    fun findAllStatus(): List<Status> = statusRepository.findAll()

    @PostMapping
    fun saveStatus(@RequestBody statusList: List<Status>): List<Status> {
        statusList.forEach{ it.registerDate = Date() }
        return statusRepository.saveAll(statusList)
    }

    @PutMapping
    fun updateStatus(@RequestBody statusList: List<Status>): List<Status> {
        val statusIdList = ArrayList<Long>()
        var statusId: Long
        statusList.forEach{
            statusId = statusRepository.updateStatus(it.name, it.description, Date(), it.id).toLong()
            statusIdList.add(statusId)
        }
        return statusRepository.findAllById(statusIdList)
    }
}
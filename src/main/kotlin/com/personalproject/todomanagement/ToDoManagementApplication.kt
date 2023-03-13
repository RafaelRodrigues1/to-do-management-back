package com.personalproject.todomanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoManagementApplication

fun main(args: Array<String>) {
	runApplication<ToDoManagementApplication>(*args)
}

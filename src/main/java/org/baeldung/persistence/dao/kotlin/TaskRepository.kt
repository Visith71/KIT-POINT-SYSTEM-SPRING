package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository:JpaRepository<Task,Long> {
    fun findAllByProjectId(id:Long):MutableList<Task>
}
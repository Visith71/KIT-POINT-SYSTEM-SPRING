package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>{
    fun findAllByStudentsId(id: Long) : MutableList<Project>
    fun findAllByFacultyId(id: Long):MutableList<Project>
}
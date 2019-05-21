package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Project
import org.baeldung.persistence.model.kotlin.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findAllByProjects(id:Project):MutableList<Student>
}
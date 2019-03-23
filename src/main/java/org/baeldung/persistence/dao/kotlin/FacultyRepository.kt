package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Faculty
import org.springframework.data.jpa.repository.JpaRepository

interface FacultyRepository : JpaRepository<Faculty, Long> {
    fun findFacultyByName(name:String) : Faculty
}
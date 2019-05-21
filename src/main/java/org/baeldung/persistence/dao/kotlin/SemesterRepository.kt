package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Semester
import org.springframework.data.jpa.repository.JpaRepository

interface SemesterRepository:JpaRepository<Semester,Long> {
}
package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Year
import org.springframework.data.jpa.repository.JpaRepository

interface YearRepository:JpaRepository<Year,Long> {
}
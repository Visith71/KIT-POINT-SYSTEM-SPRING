package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.PointValue
import org.springframework.data.jpa.repository.JpaRepository

interface PointValueRepository:JpaRepository<PointValue, Long> {
}
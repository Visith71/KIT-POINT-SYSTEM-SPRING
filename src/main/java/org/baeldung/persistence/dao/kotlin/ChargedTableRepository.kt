package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.ChargedTable
import org.springframework.data.jpa.repository.JpaRepository

interface ChargedTableRepository:JpaRepository<ChargedTable,Long> {
}
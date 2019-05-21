package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Batch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BatchRepository: JpaRepository<Batch, Long> {}
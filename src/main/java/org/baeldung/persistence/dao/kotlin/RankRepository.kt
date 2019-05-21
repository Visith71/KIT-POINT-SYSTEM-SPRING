package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Rank
import org.springframework.data.jpa.repository.JpaRepository

interface RankRepository: JpaRepository<Rank, Long> {}
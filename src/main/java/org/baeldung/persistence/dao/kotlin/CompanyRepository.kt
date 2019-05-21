package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository:JpaRepository<Company, Long> {
}
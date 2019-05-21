package org.baeldung.persistence.dao.kotlin

import org.baeldung.persistence.model.kotlin.ProjectCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectCategoryRepository:JpaRepository<ProjectCategory,Long> {}
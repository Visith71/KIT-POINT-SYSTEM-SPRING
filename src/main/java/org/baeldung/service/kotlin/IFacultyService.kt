package org.baeldung.service.kotlin

import org.baeldung.persistence.model.kotlin.Faculty
import java.util.*

interface IFacultyService {

    fun saveFaculty(faculty: Faculty)
    fun deleteFaculty(id: Long)
    fun updateStudent(faculty: Faculty)
    fun getAllFaculty(): MutableList<Faculty>
    fun getFaculty(id: Long) : Optional<Faculty>
}
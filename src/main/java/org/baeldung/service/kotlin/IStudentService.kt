package org.baeldung.service.kotlin

import org.baeldung.persistence.model.kotlin.Student
import java.util.*

interface IStudentService {
    fun saveStudent(student: Student)
    fun deleteStudent(id:Long)
    fun updateStudent(student: Student)
    fun getAllStudent(): MutableList<Student>
    fun getStudent(id:Long) : Optional<Student>
}
package org.baeldung.service.kotlin

import org.baeldung.persistence.dao.kotlin.StudentRepository
import org.baeldung.persistence.model.kotlin.Student
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class StudentService : IStudentService{

    @Autowired
    private lateinit var studentRepository : StudentRepository


    override fun saveStudent(student: Student){
        studentRepository.save(student)
    }

    override fun deleteStudent(id:Long){
        studentRepository.deleteById(id)
    }

    override fun updateStudent(student: Student){
        studentRepository.save(student)
    }
    override fun getAllStudent(): MutableList<Student> {
        return studentRepository.findAll()
    }
    override fun getStudent(id:Long) : Optional<Student> {
        return studentRepository.findById(id)
    }
}
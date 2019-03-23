package org.baeldung.service.kotlin

import org.baeldung.persistence.dao.kotlin.FacultyRepository
import org.baeldung.persistence.model.kotlin.Faculty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
open class FacultyService : IFacultyService{

    @Autowired
    private lateinit var facultyRepository:FacultyRepository

    override fun saveFaculty(faculty:Faculty){
        facultyRepository.save(faculty)
    }

    override fun deleteFaculty(id: Long){
        facultyRepository.deleteById(id)
    }

    override fun updateStudent(faculty: Faculty){
        facultyRepository.save(faculty)
    }

    override fun getAllFaculty(): MutableList<Faculty> {
        return facultyRepository.findAll()
    }

    override fun getFaculty(id: Long) : Optional<Faculty> {
        return facultyRepository.findById(id)
    }
}
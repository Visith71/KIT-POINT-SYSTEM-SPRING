package org.baeldung.web.controller.kotlin

import org.baeldung.persistence.dao.kotlin.ProjectRepository
import org.baeldung.persistence.dao.kotlin.StudentRepository
import org.baeldung.persistence.model.kotlin.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
open class StudentController {

    @Autowired
    lateinit var studentRepository:StudentRepository

    @Autowired
    lateinit var projectRepository: ProjectRepository

//    @CrossOrigin("http://localhost:8081/")
//    @GetMapping(value= ["/batches"])
//    open fun blog(): Optional<Student> {
//     return studentRepository.findById(78)
//    }



    @RequestMapping(value = ["/students"], method = [RequestMethod.GET])
    fun getStudent():  ModelAndView{
        val students:MutableList<Student> = studentRepository.findAll()
        System.out.print(students)
        return ModelAndView("students", "students", students)
    }
//    @RequestMapping(value = ["/batches"], method = [RequestMethod.GET])
//    @ResponseBody fun getBatch():  MutableList<Batch>{
//        var batch:MutableList<Batch> = batchRepository.findAll()
//        System.out.print(batch)
//        return batchRepository.findAll()
//    }
}
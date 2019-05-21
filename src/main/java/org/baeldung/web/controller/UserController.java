package org.baeldung.web.controller;

import org.baeldung.persistence.dao.kotlin.BatchRepository;
import org.baeldung.persistence.dao.kotlin.ProjectRepository;
import org.baeldung.persistence.dao.kotlin.StudentRepository;
import org.baeldung.persistence.dao.kotlin.TaskRepository;
import org.baeldung.persistence.model.kotlin.Batch;
import org.baeldung.persistence.model.kotlin.Project;
import org.baeldung.persistence.model.kotlin.Student;
import org.baeldung.persistence.model.kotlin.Task;
import org.baeldung.security.ActiveUserStore;
import org.baeldung.service.IUserService;
import org.baeldung.service.kotlin.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    ActiveUserStore activeUserStore;

    @Autowired
    BatchRepository batchRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    IStudentService iStudentService;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/batches", method = RequestMethod.GET)
    public String getBatches(Model model)  {
        List<Batch> batches = batchRepository.findAll();
        model.addAttribute("batches", batches);
        return "batches";
    }
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String getStudent(Model model, @PathVariable Long id) {
        List<Project> projects = projectRepository.findAllByStudentsId(id);
        List<Batch> batches = batchRepository.findAll();
        iStudentService.getStudent(id).ifPresent(o->model.addAttribute("student",o));
        List<Student>students = studentRepository.findAllByProjects(projectRepository.findById(184L).get());
        List<Task> tasks = taskRepository.findAllByProjectId(184L);
        model.addAttribute("batches", batches);
        model.addAttribute("members", students);
        model.addAttribute("projects", projects);
        model.addAttribute("tasks", tasks);
        return "students";
    }

    @RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
    public String getLoggedUsers(final Locale locale, final Model model) {
        model.addAttribute("users", activeUserStore.getUsers());
        return "users";
    }

    @RequestMapping(value = "/loggedUsersFromSessionRegistry", method = RequestMethod.GET)
    public String getLoggedUsersFromSessionRegistry(final Locale locale, final Model model) {
        model.addAttribute("users", userService.getUsersFromSessionRegistry());
        return "users";
    }
}

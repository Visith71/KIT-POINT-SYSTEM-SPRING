package org.baeldung.spring;

import java.util.*;

import org.baeldung.persistence.dao.*;
import org.baeldung.persistence.dao.kotlin.FacultyRepository;
import org.baeldung.persistence.model.*;
import org.baeldung.persistence.model.kotlin.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FacultyRepository facultyRepository;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<Privilege>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
        final List<Privilege> userPrivileges = new ArrayList<Privilege>(Arrays.asList(readPrivilege, passwordPrivilege));
        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

        createRoleIfNotFound("ROLE_USER", userPrivileges);

        // == create initial user
        User user = createUserIfNotFound("admin@kit.edu.kh", "Admin",
                "KIT", "test", new ArrayList<>(Collections.singletonList(adminRole)));

        createFacultyIfNotFound(
                "Admin","admin@kit.edu.kh","098765432",
                "Kom Pong Spuer","Back office admin",
                user);


        alreadySetup = true;
    }

    @Transactional
    Faculty createFacultyIfNotFound(
            final String name, String email, String address,String contact, String position, User user ){
        Faculty faculty = facultyRepository.findFacultyByName(name);
        if (faculty==null){
            faculty = new Faculty();
            faculty.setName(name);
            faculty.setEmail(email);
            faculty.setAddress(address);
            faculty.setContact(contact);
            faculty.setPosition(position);
            faculty.setUser(user);
        }
        return facultyRepository.save(faculty);
    }


    @Transactional
    Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilege = privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
        }
        role.setPrivileges(privileges);
        role = roleRepository.save(role);
        return role;
    }

    @Transactional
    User createUserIfNotFound(final String email, final String firstName, final String lastName,
                              final String password, final Collection<Role> roles) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        return user;
    }

}
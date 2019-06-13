package org.baeldung.web.controller;

import org.baeldung.security.ActiveUserStore;
import org.baeldung.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    ActiveUserStore activeUserStore;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
    public String getLoggedUsers(final Locale locale, final Model model) {
        model.addAttribute("users", activeUserStore.getUsers());
        return "users";
    }

    @RequestMapping(value = "/loggedUsersFromSessionRegistry", method = RequestMethod.GET)
    public ModelAndView getLoggedUsersFromSessionRegistry() {
        return new ModelAndView(
          "users",
          "users",
          userService.getUsersFromSessionRegistry());
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
      return new ModelAndView("layout");
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView homepage(@RequestParam("user") String user) {
      return new ModelAndView("homepage", "user", user);
    }
}

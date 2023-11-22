package com.example.vacationhomedemo.security.controller;


import com.example.vacationhomedemo.security.model.User;
import com.example.vacationhomedemo.security.service.UserService;
import com.example.vacationhomedemo.security.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("webUser", new WebUser());

        return "register/registration-form";
    }

    @GetMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("webUser") WebUser theWebUser,
            BindingResult theBingingResult,
            HttpSession session, Model  theModel) {

       String userName = theWebUser.getUserName();
       logger.info("Processing registration from for: " + userName);

       // form validation
       if (theBingingResult.hasErrors()) {
           return "register/registration-form";
       }

       // check the database if user already exists
        User existing = userService.findByUserName(userName);
       if (existing != null) {
           theModel.addAttribute("webUser", new WebUser());
           theModel.addAttribute("registrationError", "User name already exists.");

           logger.warning("User name already exists.");
           return "register/registration-form";
       }

       // create user account and store in the database
        userService.save(theWebUser);

       logger.info("Successfully created user: " + userName);

       // place user in the web http session for later use
        session.setAttribute("user", theWebUser);

        return "register/registration-confirmation";
    }
}

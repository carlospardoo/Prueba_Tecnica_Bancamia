package com.bancamia.webapp.controller;

import com.bancamia.webapp.model.URL;
import com.bancamia.webapp.model.User;
import com.bancamia.webapp.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST
})

public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/login",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public URL canSignIn(@RequestBody User user){
        //boolean login = false;
        logger.info("Received user info: "+user.toString());
        User userTmp = userService.getUser(user.getUsername());
        
        if(userTmp != null){
            logger.info(userTmp.toString());
            if(userTmp.getPassword().equals(user.getPassword())){
                //return new RedirectView("redirect:/templates/main.html");
                URL route = new URL("/templates/main.html");
                //String route = ; 
                return route;
                //login = true;
            }
        }
        //return login;
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED) ;
    }

    @PostMapping(value = "/register",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    public boolean registerUser(@RequestBody User user){
        boolean registered = false;
        logger.info("Received user info: "+user.toString());

        registered = userService.addUser(user);

        if(registered)
            logger.info("New user: "+userService.getUser(user.getUsername()).toString());
        else
            logger.error("Error adding user: "+user.toString());

        return registered;
    }
}

package com.bancamia.webapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bancamia.webapp.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private List<User> usersRegistered;

    public UserService(){
        usersRegistered = new ArrayList<>();
        
        User user = new User("Carlos David", "Pardo Ortiz", "CC", 1234567890, 
            "01/01/1900", "Bogota", 3213933456L, "carlos", "carlos1");

        usersRegistered.add(user);
    }

    public boolean addUser(User user){
        if(getUser(user.getUsername()) == null){
            usersRegistered.add(user);
            return true;
        }
        return false;
    }

    public User getUser(String username){
        for(int i = 0; i< usersRegistered.size(); i++){
            User user = usersRegistered.get(i);
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}

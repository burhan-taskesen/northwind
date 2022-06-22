package com.nortwind.app.api.controllers;

import com.nortwind.app.business.abstracts.UserService;
import com.nortwind.app.core.Entity.User;
import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid User user){
        return ResponseEntity.ok(userService.add(user));
    }

    @GetMapping(value = "/findByEmail")
    public DataResult<User> findByEmail(String email){
        return userService.findByEmail(email);
    }
}

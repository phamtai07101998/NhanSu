package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_User;
import com.aht.NhanSu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<Aht_User>> findAllUser(){
        return ResponseEntity.ok().body(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_User>> findUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_User> createUser(@RequestBody Aht_User user){
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_User> updateUser(@PathVariable("id") Long id, @RequestBody Aht_User user){
        user.setUserId(id);
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return HttpStatus.OK;
    }
}

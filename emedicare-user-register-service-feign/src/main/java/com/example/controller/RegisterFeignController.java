package com.example.controller;

import com.example.dto.UserDTO;
import com.example.proxy.RegisterServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegisterFeignController {

    private final RegisterServiceProxy registerServiceProxy;

    @Autowired
    public RegisterFeignController(RegisterServiceProxy registerServiceProxy) {
        this.registerServiceProxy = registerServiceProxy;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        return registerServiceProxy.register(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
        return registerServiceProxy.login(userDTO);
    }

    @GetMapping("/readOne/{userId}")
    public ResponseEntity<Object> readOne(@PathVariable Long userId) {
        return registerServiceProxy.readOne(userId);
    }

    @GetMapping("/readOneByUsername/{username}")
    public ResponseEntity<Object> readOneByUsername(@PathVariable String username) {
        return registerServiceProxy.readOneByUsername(username);
    }

    @GetMapping("/readMany/{pageNumber}/{itemCount}")
    public ResponseEntity<Object> readMany(@PathVariable Integer pageNumber, @PathVariable Integer itemCount) {
        return registerServiceProxy.readMany(pageNumber, itemCount);
    }

    @GetMapping("/readManyByType/{userType}/{pageNumber}/{itemCount}")
    public ResponseEntity<Object> readManyByType(@PathVariable String userType, @PathVariable Integer pageNumber, @PathVariable Integer itemCount) {
        return registerServiceProxy.readManyByType(userType, pageNumber, itemCount);
    }

    @PutMapping("/updateOne")
    public ResponseEntity<Object> updateOne(@RequestBody UserDTO userDTO) {
        return registerServiceProxy.updateOne(userDTO);
    }

    @DeleteMapping("/removeOne/{userId}")
    public void removeOne(@PathVariable Long userId) {
        registerServiceProxy.removeOne(userId);
    }
}

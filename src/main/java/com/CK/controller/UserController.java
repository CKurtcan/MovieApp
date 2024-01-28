package com.CK.controller;

import com.CK.dto.request.LoginRequestDto;
import com.CK.dto.request.RegisterRequestDto;
import com.CK.dto.response.LoginResponseDto;
import com.CK.dto.response.RegisterResponseDto;
import com.CK.entity.User;
import com.CK.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<User>> findById(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    //basic register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getRePassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user.getEmail(), user.getPassword()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(@RequestParam Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    //dto register
    @PostMapping("/register-dto")
    public ResponseEntity<RegisterResponseDto> registerDto(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(userService.registerDto(dto));
    }

    @PostMapping("/login-dto")
    public ResponseEntity<LoginResponseDto> loginDto(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(userService.loginDto(dto));
    }

    @PostMapping("/login-mapper")
    public ResponseEntity<LoginResponseDto> loginMapper(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @PostMapping("/register-mapper")
    public ResponseEntity<RegisterResponseDto> registerMapper(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(userService.registerMapper(dto));
    }
    @GetMapping("/list-by-name")
    public ResponseEntity<List<User>> listByName() {
        return ResponseEntity.ok(userService.listByName());
    }

    @GetMapping("/check-user-name")
    public ResponseEntity<Boolean> checkUserName(@RequestParam String name) {
        return ResponseEntity.ok(userService.checkUserName(name));
    }

    @GetMapping("/search-users")
    public List<User> searchUsers(@RequestParam String keyword) {
        return userService.searchUsers(keyword);
    }


}

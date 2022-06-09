package com.trexion.helpdesk.controller.user;

import com.trexion.helpdesk.dto.request.user.UserCreationDto;
import com.trexion.helpdesk.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/access")
    public ResponseEntity getUsersAccess() {
        return ResponseEntity.ok(userService.getAllUsersAccess());
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreationDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping
    public ResponseEntity disableUser(@RequestParam String userName){
        userService.disableUser(userName);
        return ResponseEntity.ok(String.format("User %s disabled successfully", userName));
    }
}

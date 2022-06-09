package com.trexion.helpdesk.controller.user;

import com.trexion.helpdesk.dto.request.user.UserCreationDto;
import com.trexion.helpdesk.dto.request.user.UserEditDto;
import com.trexion.helpdesk.dto.response.user.UserDto;
import com.trexion.helpdesk.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/access/{userName}")
    public ResponseEntity getUserAccess(@PathVariable String userName){
        return ResponseEntity.ok(userService.getUserAccess(userName));
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userName}")
    public ResponseEntity getUser(@PathVariable String userName){
        return ResponseEntity.ok(userService.getUser(userName));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreationDto user) {
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity editUser(@RequestBody UserEditDto userEditDto){
        return ResponseEntity.ok(userService.editUser(userEditDto));
    }

    @DeleteMapping
    public ResponseEntity disableUser(@RequestParam String userName){
        userService.disableUser(userName);
        return ResponseEntity.ok(String.format("User %s disabled successfully", userName));
    }
}

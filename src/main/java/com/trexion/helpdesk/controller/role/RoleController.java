package com.trexion.helpdesk.controller.role;

import com.trexion.helpdesk.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRole(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @GetMapping("/details")
    public ResponseEntity getAllRolesDetails(){
        return ResponseEntity.ok(roleService.getAllRolesDetails());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity getRoleDetails(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getRoleDetails(id));
    }
}

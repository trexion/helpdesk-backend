package com.trexion.helpdesk.controller.role;

import com.trexion.helpdesk.dto.request.role.RoleRequestDto;
import com.trexion.helpdesk.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity createRole(@RequestBody RoleRequestDto roleRequestDto){
        return ResponseEntity.ok(roleService.createRole(roleRequestDto));
    }

    @DeleteMapping
    public ResponseEntity disableRole(@RequestParam Integer id){
        roleService.disableRole(id);
        return ResponseEntity.ok(String.format("Role %s disabled successfully", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity editRole(@PathVariable Integer id, @RequestBody RoleRequestDto roleRequestDto){
        return ResponseEntity.ok(roleService.editRole(id, roleRequestDto));
    }
}

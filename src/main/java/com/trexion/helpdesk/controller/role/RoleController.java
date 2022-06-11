package com.trexion.helpdesk.controller.role;

import com.trexion.helpdesk.dto.request.role.RoleRequestDto;
import com.trexion.helpdesk.dto.response.role.RoleAdminDto;
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

    @GetMapping("/details")
    public ResponseEntity getAllRolesDetails(){
        return ResponseEntity.ok(roleService.getAllRolesDetails());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity getRoleDetails(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getRoleDetails(id));
    }

    @GetMapping("/details/{id}/members")
    public ResponseEntity getRoleMembers(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getRoleMembers(id));
    }

    @GetMapping("/details/{id}/admins")
    public ResponseEntity getRoleAdmins(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getRoleAdmins(id));
    }

    @PostMapping("/details/{id}/members")
    public ResponseEntity addRoleMember(@PathVariable Integer id, @RequestParam String userName){
        roleService.addRoleMember(id, userName);
        return ResponseEntity.ok("Role member added successfully");
    }

    @PostMapping("/details/{id}/admins")
    public ResponseEntity addRoleAdmin(@PathVariable Integer id, @RequestBody RoleAdminDto roleAdminDto){
        roleService.addRoleAdmin(id, roleAdminDto);
        return ResponseEntity.ok("Role admin added successfully");
    }

    @DeleteMapping("/details/{id}/members")
    public ResponseEntity deleteRoleMember(@PathVariable Integer id, @RequestParam String userName){
        roleService.deleteRoleMember(id, userName);
        return ResponseEntity.ok("Role member deleted successfully");
    }

    @DeleteMapping("/details/{id}/admins")
    public ResponseEntity deleteRoleAdmin(@PathVariable Integer id, @RequestBody RoleAdminDto roleAdminDto){
        roleService.deleteRoleAdmin(id, roleAdminDto);
        return ResponseEntity.ok("Role admin deleted successfully");
    }
}

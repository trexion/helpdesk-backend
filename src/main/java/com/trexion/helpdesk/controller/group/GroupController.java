package com.trexion.helpdesk.controller.group;

import com.trexion.helpdesk.dto.request.group.GroupRequestDto;
import com.trexion.helpdesk.dto.response.group.GroupAdminDto;
import com.trexion.helpdesk.service.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity getAllGroups(){
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity getGroup(@PathVariable Integer id){
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @GetMapping("/details")
    public ResponseEntity getAllGroupsDetails(){
        return ResponseEntity.ok(groupService.getAllGroupDetails());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity getGroupDetails(@PathVariable Integer id){
        return ResponseEntity.ok(groupService.getGroupDetails(id));
    }

    @GetMapping("/details/{id}/admins")
    public ResponseEntity getGroupAdmins(@PathVariable Integer id){
        return ResponseEntity.ok(groupService.getGroupAdmins(id));
    }

    @GetMapping("/details/{id}/members")
    public ResponseEntity getGroupMembers(@PathVariable Integer id){
        return ResponseEntity.ok(groupService.getGroupMembers(id));
    }

    @PostMapping
    public ResponseEntity createGroup(@RequestBody GroupRequestDto groupRequestDto){
        return ResponseEntity.ok(groupService.createGroup(groupRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity editGroup(@PathVariable Integer id, @RequestBody GroupRequestDto groupRequestDto){
        return ResponseEntity.ok(groupService.editGroup(id, groupRequestDto));
    }

    @PostMapping("/details/{id}/members")
    public ResponseEntity addGroupMember(@PathVariable Integer id, @RequestParam String userName){
        groupService.addGroupMember(id, userName);
        return ResponseEntity.ok(String.format("Added %s successfully as member", userName));
    }

    @PostMapping("/details/{id}/admins")
    public ResponseEntity addGroupAdmin(@PathVariable Integer id, @RequestBody GroupAdminDto groupAdminDto){
        groupService.addGroupAdmin(id, groupAdminDto);
        return ResponseEntity.ok(String.format("Added %s successfully as %s", groupAdminDto.getUserName(), groupAdminDto.getAccessType()));
    }

    @DeleteMapping("/details/{id}/members")
    public ResponseEntity deleteGroupMember(@PathVariable Integer id, @RequestParam String userName){
        groupService.deleteGroupMember(id, userName);
        return ResponseEntity.ok(String.format("Removed %s successfully as member", userName));
    }

    @DeleteMapping("/details/{id}/admins")
    public ResponseEntity deleteGroupAdmin(@PathVariable Integer id, @RequestBody GroupAdminDto groupAdminDto){
        groupService.deleteGroupAdmin(id, groupAdminDto);
        return ResponseEntity.ok(String.format("Removed %s successfully as %s", groupAdminDto.getUserName(), groupAdminDto.getAccessType()));
    }
}

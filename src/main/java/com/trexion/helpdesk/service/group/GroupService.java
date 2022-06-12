package com.trexion.helpdesk.service.group;

import com.trexion.helpdesk.dto.response.group.GroupAdminDto;
import com.trexion.helpdesk.dto.response.group.GroupDetailsDto;
import com.trexion.helpdesk.dto.response.group.GroupDto;
import com.trexion.helpdesk.entity.group.Group;
import com.trexion.helpdesk.entity.group.GroupAdmin;
import com.trexion.helpdesk.repository.group.AccessGroupRepo;
import com.trexion.helpdesk.repository.group.GroupAdminAccessRepo;
import com.trexion.helpdesk.repository.group.GroupAdminRepo;
import com.trexion.helpdesk.repository.group.GroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupService {
    private final GroupRepo groupRepo;
    private final GroupAdminRepo groupAdminRepo;
    private final GroupAdminAccessRepo groupAdminAccessRepo;
    private final AccessGroupRepo accessGroupRepo;

    public List<GroupDto> getAllGroups(){
        return groupRepo.findAll().stream().map(GroupService::mapToGroupDto).collect(Collectors.toList());
    }

    public GroupDto getGroupById(Integer groupId){
        return mapToGroupDto(groupRepo.getById(groupId));
    }

    private static GroupDto mapToGroupDto(Group group){
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .build();
    }

    public List<GroupDetailsDto> getAllGroupDetails(){
        return groupRepo.findAll().stream().map(this::mapToGroupDetailsDto).collect(Collectors.toList());
    }

    public GroupDetailsDto getGroupDetails(Integer groupId){
        return mapToGroupDetailsDto(groupRepo.getById(groupId));
    }

    private GroupDetailsDto mapToGroupDetailsDto(Group group){
        return GroupDetailsDto.builder()
                .name(group.getName())
                .description(group.getDescription())
                .active(group.isActive())
                .createDateTime(group.getCreateDateTime())
                .updateDateTime(group.getUpdateDateTime())
                .admins(getGroupAdmins(group.getId()))
                .members(getGroupMembers(group.getId()))
                .build();
    }

    public List<GroupAdminDto> getGroupAdmins(Integer groupId){
        return groupAdminRepo.findAllByGroupId(groupId).stream().map(GroupService::mapToGroupAdminDto).collect(Collectors.toList());
    }

    private static GroupAdminDto mapToGroupAdminDto(GroupAdmin groupAdmin){
        return GroupAdminDto.builder()
                .userName(groupAdmin.getUserAccess().getUserName())
                .accessType(groupAdmin.getAccess().getName())
                .build();
    }

    public List<String> getGroupMembers(Integer groupId){
        return accessGroupRepo.findAllByGroupId(groupId).stream().map(x -> x.getUserAccess().getUserName()).collect(Collectors.toList());
    }
}

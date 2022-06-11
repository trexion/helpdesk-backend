package com.trexion.helpdesk.service.role;

import com.trexion.helpdesk.dto.request.role.RoleCreationDto;
import com.trexion.helpdesk.dto.response.role.RoleAdminDto;
import com.trexion.helpdesk.dto.response.role.RoleDetailsDto;
import com.trexion.helpdesk.dto.response.role.RoleDto;
import com.trexion.helpdesk.entity.role.AccessRole;
import com.trexion.helpdesk.entity.role.Role;
import com.trexion.helpdesk.entity.role.RoleAdmin;
import com.trexion.helpdesk.repository.role.AccessRoleRepo;
import com.trexion.helpdesk.repository.role.RoleAdminRepo;
import com.trexion.helpdesk.repository.role.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepo roleRepo;
    private final RoleAdminRepo roleAdminRepo;
    private final AccessRoleRepo accessRoleRepo;

    public List<RoleDto> getAllRoles(){
        return roleRepo.findAll().stream().map(RoleService::mapToRoleDto).collect(Collectors.toList());
    }

    public RoleDto getRole(Integer id){
        return mapToRoleDto(roleRepo.getById(id));
    }

    public List<RoleDetailsDto> getAllRolesDetails(){
        return roleRepo.findAll().stream().map(this::mapToRoleDetailsDto).collect(Collectors.toList());
    }

    public RoleDetailsDto getRoleDetails(Integer id){
        return mapToRoleDetailsDto(roleRepo.getById(id));
    }

    private static RoleDto mapToRoleDto(Role role){
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
            .build();
    }

    private RoleDetailsDto mapToRoleDetailsDto(Role role){
        return RoleDetailsDto.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .active(role.isActive())
                .createDateTime(role.getCreateDateTime())
                .updateDateTime(role.getUpdateDateTime())
                .admins(getRoleAdmins(role).stream().map(RoleService::mapToRoleAdminDto).collect(Collectors.toList()))
                .members(getRoleMembers(role).stream().map(x -> x.getUserAccess().getUserName()).collect(Collectors.toList()))
            .build();
    }

    public List<RoleAdmin> getRoleAdmins(Role role){
        return roleAdminRepo.findAllByRoleId(role.getId());
    }

    private static RoleAdminDto mapToRoleAdminDto(RoleAdmin roleAdmin){
        return RoleAdminDto.builder()
                .userName(roleAdmin.getUserAccess().getUserName())
                .accessType(roleAdmin.getAccess().getName())
            .build();
    }

    public List<AccessRole> getRoleMembers(Role role){
        return accessRoleRepo.findAllByRoleId(role.getId());
    }

    public RoleDto createRole(RoleCreationDto roleCreationDto){
        //validate role is valid - TODO
        Role newRole = roleRepo.save(Role.builder()
                        .name(roleCreationDto.getName())
                        .description(roleCreationDto.getDescription())
                        .active(true)
                .build());
        return mapToRoleDto(newRole);
    }

    public void disableRole(Integer id){
        Role role = roleRepo.getById(id);
        role.setActive(false);
        roleRepo.save(role);
    }
}

package com.trexion.helpdesk.service.role;

import com.trexion.helpdesk.dto.request.role.RoleRequestDto;
import com.trexion.helpdesk.dto.response.role.RoleAdminDto;
import com.trexion.helpdesk.dto.response.role.RoleDetailsDto;
import com.trexion.helpdesk.dto.response.role.RoleDto;
import com.trexion.helpdesk.entity.role.AccessRole;
import com.trexion.helpdesk.entity.role.Role;
import com.trexion.helpdesk.entity.role.RoleAdmin;
import com.trexion.helpdesk.entity.role.RoleAdminAccess;
import com.trexion.helpdesk.entity.user.access.UserAccess;
import com.trexion.helpdesk.repository.role.AccessRoleRepo;
import com.trexion.helpdesk.repository.role.RoleAdminAccessRepo;
import com.trexion.helpdesk.repository.role.RoleAdminRepo;
import com.trexion.helpdesk.repository.role.RoleRepo;
import com.trexion.helpdesk.repository.user.access.UserAccessRepo;
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
    private final RoleAdminAccessRepo roleAdminAccessRepo;
    private final AccessRoleRepo accessRoleRepo;
    private final UserAccessRepo userAccessRepo;

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
                .admins(getRoleAdmins(role.getId()))
                .members(getRoleMembers(role.getId()))
            .build();
    }

    public List<RoleAdminDto> getRoleAdmins(Integer roleId){
        return roleAdminRepo.findAllByRoleId(roleId).stream().map(RoleService::mapToRoleAdminDto).collect(Collectors.toList());
    }

    private static RoleAdminDto mapToRoleAdminDto(RoleAdmin roleAdmin){
        return RoleAdminDto.builder()
                .userName(roleAdmin.getUserAccess().getUserName())
                .accessType(roleAdmin.getAccess().getName())
            .build();
    }

    public List<String> getRoleMembers(Integer roleId){
        return accessRoleRepo.findAllByRoleId(roleId).stream().map(x -> x.getUserAccess().getUserName()).collect(Collectors.toList());
    }

    public RoleDto createRole(RoleRequestDto roleRequestDto){
        //validate role is valid - TODO
        Role newRole = roleRepo.save(Role.builder()
                        .name(roleRequestDto.getName())
                        .description(roleRequestDto.getDescription())
                        .active(true)
                .build());
        return mapToRoleDto(newRole);
    }

    public void disableRole(Integer id){
        Role role = roleRepo.getById(id);
        role.setActive(false);
        roleRepo.save(role);
    }

    public RoleDto editRole(Integer id, RoleRequestDto roleRequestDto){
        //validate role is valid
        Role role = roleRepo.getById(id);
        role.setName(roleRequestDto.getName());
        role.setDescription(roleRequestDto.getDescription());
        return mapToRoleDto(roleRepo.save(role));
    }

    public void addRoleMember(Integer roleId, String userName){
        //validate data - TODO
        UserAccess userAccess = userAccessRepo.findByUserName(userName).orElseThrow(/*TODO*/);
        Role role = roleRepo.getById(roleId);
        accessRoleRepo.save(AccessRole.builder()
                        .role(role)
                        .userAccess(userAccess)
                .build());
    }

    public void addRoleAdmin(Integer roleId, RoleAdminDto roleAdminDto){
        //validate data - TODO
        Role role = roleRepo.getById(roleId);
        RoleAdminAccess roleAdminAccess = roleAdminAccessRepo.findByName(roleAdminDto.getAccessType()).orElseThrow(/*TODO*/);
        UserAccess userAccess = userAccessRepo.findByUserName(roleAdminDto.getUserName()).orElseThrow(/*TODO*/);
        roleAdminRepo.save(RoleAdmin.builder()
                        .role(role)
                        .userAccess(userAccess)
                        .access(roleAdminAccess)
                .build());
    }

    public void deleteRoleMember(Integer roleId, String userName){
        //validate data - TODO
        UserAccess userAccess = userAccessRepo.findByUserName(userName).orElseThrow(/*TODO*/);
        AccessRole accessRole = accessRoleRepo.findByRoleIdAndUserAccessId(roleId, userAccess.getId());
        accessRoleRepo.delete(accessRole);
    }

    public void deleteRoleAdmin(Integer roleId, RoleAdminDto roleAdminDto){
        //validate data - TODO
        UserAccess userAccess = userAccessRepo.findByUserName(roleAdminDto.getUserName()).orElseThrow(/*TODO*/);
        RoleAdmin roleAdmin = roleAdminRepo.findByRoleIdAndUserAccessId(roleId, userAccess.getId());
        roleAdminRepo.delete(roleAdmin);
    }
}

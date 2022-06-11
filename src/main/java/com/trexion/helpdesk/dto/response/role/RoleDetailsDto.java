package com.trexion.helpdesk.dto.response.role;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class RoleDetailsDto {
    Integer id;
    String name;
    String description;
    Boolean active;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;
    List<RoleAdminDto> admins;
    List<String> members;
}

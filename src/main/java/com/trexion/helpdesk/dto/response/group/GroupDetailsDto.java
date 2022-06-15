package com.trexion.helpdesk.dto.response.group;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class GroupDetailsDto {
    Integer id;
    String name;
    String description;
    Boolean active;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;
    List<GroupAdminDto> admins;
    List<String> members;
}

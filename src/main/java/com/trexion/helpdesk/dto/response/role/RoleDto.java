package com.trexion.helpdesk.dto.response.role;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleDto {
    Integer id;
    String name;
}

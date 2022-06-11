package com.trexion.helpdesk.dto.request.role;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleRequestDto {
    String name;
    String description;
}

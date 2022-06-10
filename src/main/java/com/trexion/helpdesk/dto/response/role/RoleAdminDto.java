package com.trexion.helpdesk.dto.response.role;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleAdminDto {
    String userName;
    String accessType;
}

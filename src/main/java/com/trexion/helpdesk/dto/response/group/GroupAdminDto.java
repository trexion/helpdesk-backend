package com.trexion.helpdesk.dto.response.group;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GroupAdminDto {
    String userName;
    String accessType;
}

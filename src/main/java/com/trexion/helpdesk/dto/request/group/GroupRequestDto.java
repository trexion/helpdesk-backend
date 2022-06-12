package com.trexion.helpdesk.dto.request.group;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GroupRequestDto {
    String name;
    String description;
}

package com.trexion.helpdesk.dto.response.group;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GroupDto {
    Integer id;
    String name;
    String description;
}

package com.trexion.helpdesk.dto.response.user;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class UserFullDto {
    String firstName;
    String lastName;
    String userName;
    String email;
    Integer phone;
    String image;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;
}

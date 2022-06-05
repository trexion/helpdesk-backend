package com.trexion.helpdesk.dto.response.user;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class UserAccessDto {
    String firstName;
    String lastName;
    String userName;
    String email;
    Integer phone;
    String userStatus;
    String accountStatus;
    String image;
    List<String> roles;
    List<String> groups;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;
}

package com.trexion.helpdesk.dto.response.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    String firstName;
    String lastName;
    String userName;
    String email;
    Integer phone;
    String userStatus;
    String accessStatus;
    String image;
}

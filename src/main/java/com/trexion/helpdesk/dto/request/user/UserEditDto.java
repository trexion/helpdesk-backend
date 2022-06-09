package com.trexion.helpdesk.dto.request.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserEditDto {
    String firstName;
    String lastName;
    String userName;
    String email;
    Integer phone;
    Integer userStatus;
    Integer accessStatus;
    String image;
}

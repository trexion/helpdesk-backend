package com.trexion.helpdesk.dto.request.user;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class UserCreationDto {
    String firstName;
    String lastName;
    String userName;
    String password;
    String email;
    Integer phone;
    Integer userStatus;
    Integer accessStatus;
    String image;
    List<Integer> roles;
    List<Integer> groups;
}

package com.trexion.helpdesk.service.user;

import com.trexion.helpdesk.dto.response.user.UserAccessDto;
import com.trexion.helpdesk.entity.user.user.User;
import com.trexion.helpdesk.repository.user.user.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo userRepo;

    public List<UserAccessDto> getAllUsersAccess() {
        return userRepo.findAll().stream().map(this::mapToUserAccessDto).collect(Collectors.toList());
    }

    private UserAccessDto mapToUserAccessDto(User user) {
        return UserAccessDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .userName(user.getAccess().getUserName())
            .email(user.getEmail())
            .phone(user.getPhone())
            .userStatus(user.getUserStatus().getName())
            .accountStatus(user.getAccess().getStatus().getName())
            .roles(user.getAccess().getRoles().stream().map(x -> x.getRole().getName()).collect(Collectors.toList()))
            .groups(user.getAccess().getGroups().stream().map(x -> x.getGroup().getName()).collect(Collectors.toList()))
            .image(user.getImage())
            .createDateTime(user.getCreateDateTime())
            .updateDateTime(user.getUpdateDateTime())
            .build();
    }
}

package com.trexion.helpdesk.service.user;

import com.trexion.helpdesk.dto.response.user.UserFullDto;
import com.trexion.helpdesk.entity.user.user.User;
import com.trexion.helpdesk.repository.user.UserRepo;
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

    public List<UserFullDto> getAll() {
        return userRepo.findAll().stream().map(this::mapToUserFullDto).collect(Collectors.toList());
    }

    private UserFullDto mapToUserFullDto(User user) {
        return UserFullDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .userName(user.getAccess().getUserName())
            .email(user.getEmail())
            .phone(user.getPhone())
            .image(user.getImage())
            .createDateTime(user.getCreateDateTime())
            .updateDateTime(user.getUpdateDateTime())
            .build();
    }
}

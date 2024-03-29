package com.trexion.helpdesk.service.user;

import com.trexion.helpdesk.dto.request.user.UserCreationDto;
import com.trexion.helpdesk.dto.request.user.UserEditDto;
import com.trexion.helpdesk.dto.response.user.UserAccessDto;
import com.trexion.helpdesk.dto.response.user.UserDto;
import com.trexion.helpdesk.entity.user.access.UserAccess;
import com.trexion.helpdesk.entity.user.access.UserAccessStatus;
import com.trexion.helpdesk.entity.user.user.User;
import com.trexion.helpdesk.entity.user.user.UserStatus;
import com.trexion.helpdesk.repository.user.access.UserAccessStatusRepo;
import com.trexion.helpdesk.repository.user.access.UserAccessRepo;
import com.trexion.helpdesk.repository.user.user.UserRepo;
import com.trexion.helpdesk.repository.user.user.UserStatusRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo userRepo;
    private final UserAccessRepo userAccessRepo;
    private final UserStatusRepo userStatusRepo;
    private final UserAccessStatusRepo userAccessStatusRepo;

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
            .accessStatus(user.getAccess().getStatus().getName())
            .roles(user.getAccess().getRoles().stream().map(x -> x.getRole().getName()).collect(Collectors.toList()))
            .groups(user.getAccess().getGroups().stream().map(x -> x.getGroup().getName()).collect(Collectors.toList()))
            .image(user.getImage())
            .createDateTime(user.getCreateDateTime())
            .updateDateTime(user.getUpdateDateTime())
            .build();
    }

    public List<UserDto> getAllUsers(){
        return userRepo.findAll().stream().map(this::mapToUserDto).collect(Collectors.toList());
    }

    public UserDto getUser(String userName){
        return mapToUserDto(userAccessRepo.findByUserName(userName).get().getUser());
    }

    public UserAccessDto getUserAccess(String userName){
        return mapToUserAccessDto(userAccessRepo.findByUserName(userName).get().getUser());
    }

    private UserDto mapToUserDto(User user){
        return UserDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .userName(user.getAccess().getUserName())
            .email(user.getEmail())
            .phone(user.getPhone())
            .userStatus(user.getUserStatus().getName())
            .accessStatus(user.getAccess().getStatus().getName())
            .image(user.getImage())
            .build();
    }

    public UserDto createUser(UserCreationDto userReceived){
        //check it's a valid user
        Optional<UserAccessStatus> userAccessStatus = userAccessStatusRepo.findById(userReceived.getUserStatus());
        Optional<UserStatus> userStatus = userStatusRepo.findById(userReceived.getUserStatus());
        //create user's access and retrieve Id
        UserAccess userAccess = userAccessRepo.save(UserAccess.builder()
                .userName(userReceived.getUserName())
                .password(userReceived.getPassword())
                .status(userAccessStatus.get())
                .build());
        User user = userRepo.save(User.builder()
                .firstName(userReceived.getFirstName())
                .lastName(userReceived.getLastName())
                .email(userReceived.getEmail())
                .phone(userReceived.getPhone())
                .image(userReceived.getImage())
                .access(userAccess)
                .userStatus(userStatus.get())
                .build());
        userAccess.setUser(user);
        log.info("user: {}", userAccess.getUser().getEmail());
        return mapToUserDto(user);
    }

    public void disableUser(String userName){
        UserAccessStatus userAccessStatus = userAccessStatusRepo.findByName("Disabled").orElseThrow(/*add exception*/);
        UserAccess userAccess = userAccessRepo.findByUserName(userName).orElseThrow(/*add exception*/);
        userAccess.setStatus(userAccessStatus);
        userAccessRepo.save(userAccess);
    }

    public UserDto editUser(UserEditDto userDto){
        //check user exists
        UserAccess userAccess = userAccessRepo.findByUserName(userDto.getUserName()).orElseThrow(/*TODO*/);
        UserStatus userStatus = userStatusRepo.getById(userDto.getUserStatus());
        //check userDto has valid data - TODO
        //save user to db

        User user = userAccess.getUser();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setImage(userDto.getImage());
        user.setUserStatus(userStatus);

        return mapToUserDto(userRepo.save(user));
    }
}

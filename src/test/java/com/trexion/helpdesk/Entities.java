package com.trexion.helpdesk;

import com.trexion.helpdesk.entity.ticket.*;
import com.trexion.helpdesk.entity.user.User;
import com.trexion.helpdesk.entity.user.UserAccess;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextBoolean;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class Entities {
    public static TicketStatus randomPersistedTicketStatus() {
        TicketStatus status = randomTicketStatus();
        status.setId(nextInt());
        return status;
    }

    public static List<TicketStatus> randomTicketStatuses() {
        List<TicketStatus> list = new ArrayList<>();
        int size = nextInt(5, 10);
        for (int i = 0; i < size; i++)
            list.add(randomPersistedTicketStatus());
        return list;
    }

    public static TicketComment randomPersistedTicketComment(Ticket ticket) {
        return TicketComment.builder()
            .id(nextInt())
            .comment(randomAlphabetic(20))
            .userID(randomAlphabetic(5))
            .createDateTime(LocalDateTime.now())
            .ticket(ticket)
            .build();
    }

    public static Ticket randomTicket(User user,User requester, User technician) {
        return Ticket.builder()
            .id(UUID.randomUUID().toString())
            .subject(randomAlphabetic(20))
            .description(randomAlphabetic(20, 1000))
            .category(randomTicketCategory())
            .priority(randomTicketPriority())
            .groupID(nextInt())
            .user(user)
            .requester(requester)
            .technician(technician)
            .createDateTime(LocalDateTime.now())
            .updateDateTime(LocalDateTime.now())
            .status(randomTicketStatus())
            .comments(Collections.emptyList())
            .build();
    }

    public static TicketStatus randomTicketStatus() {
        return TicketStatus.builder()
            .name(randomAlphabetic(20))
            .tickets(Collections.emptyList())
            .build();
    }

    public static TicketCategory randomTicketCategory() {
        return TicketCategory.builder()
            .name(randomAlphabetic(10))
            .children(Collections.emptyList())
            .active(nextBoolean())
            .tickets(Collections.emptyList())
            .createDateTime(LocalDateTime.now())
            .updateDateTime(LocalDateTime.now())
            .build();
    }

    public static List<TicketCategory> randomTicketCategories() {
        List<TicketCategory> list = new ArrayList<>();
        int size = nextInt(5, 10);
        for (int i = 0; i < size; i++)
            list.add(randomPersistedTicketCategory());
        return list;
    }

    public static TicketCategory randomPersistedTicketCategory() {
        TicketCategory category = randomTicketCategory();
        category.setId(nextInt());
        return category;
    }

    public static String randomEmail(){
        String email = randomAlphabetic(10) + "@" + randomAlphabetic(8) + "." + randomAlphabetic(3);
        return email;
    }

    public static User randomUser() {
        return User.builder()
            .firstName(randomAlphabetic(10))
            .lastName(randomAlphabetic(10))
            .email(randomEmail())
            .phone(nextInt(100000000, 999999999))
            .image(randomAlphabetic(15))
            .active(nextBoolean())
            .createDateTime(LocalDateTime.now())
            .updateDateTime(LocalDateTime.now())
            .build();
    }

    public static User randomPersistedUser() {
        User user = randomUser();
        user.setId(UUID.randomUUID());
        return user;
    }

    public static List<User> randomUsers() {
        List<User> users = new ArrayList<>();
        int size = nextInt(5, 10);
        for (int i = 0; i < size; i++)
            users.add(randomPersistedUser());
        return users;
    }

    private static UserAccess randomUserAccess(User user) {
        return UserAccess.builder()
            .password(randomAlphanumeric(8))
            .user(user)
            .build();
    }

    public static TicketPriority randomTicketPriority() {
        return TicketPriority.builder()
            .name(randomAlphabetic(10))
            .active(nextBoolean())
            .tickets(Collections.emptyList())
            .build();
    }

    public static TicketPriority randomPersistedTicketPriority() {
        TicketPriority priority = randomTicketPriority();
        priority.setId(nextInt());
        return priority;
    }

    public static List<TicketPriority> randomTicketPriorities() {
        List<TicketPriority> list = new ArrayList<>();
        int size = nextInt(5, 10);
        for (int i = 0; i < size; i++)
            list.add(randomPersistedTicketPriority());
        return list;
    }
}

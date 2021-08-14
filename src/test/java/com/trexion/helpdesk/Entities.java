package com.trexion.helpdesk;

import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketCategory;
import com.trexion.helpdesk.entity.ticket.TicketComment;
import com.trexion.helpdesk.entity.ticket.TicketStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
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

    public static Ticket randomTicket() {
        return Ticket.builder()
                .id(UUID.randomUUID().toString())
                .subject(randomAlphabetic(20))
                .description(randomAlphabetic(20, 1000))
                .category(randomTicketCategory())
                .priorityID(nextInt())
                .groupID(nextInt())
                .userID(randomAlphabetic(20))
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .status(randomTicketStatus())
                .comments(Collections.emptyList())
                .requesterID(randomAlphabetic(10))
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

    private static TicketCategory randomPersistedTicketCategory() {
        TicketCategory category = randomTicketCategory();
        category.setId(nextInt());
        return category;
    }
}

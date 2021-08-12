package com.trexion.helpdesk;

import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketComment;
import com.trexion.helpdesk.entity.ticket.TicketStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class Entities {
    public static Ticket randomPersistedTicket() {
        return Ticket.builder()
                .id(UUID.randomUUID().toString())
                .subject(randomAlphabetic(20))
                .description(randomAlphabetic(20, 1000))
                .categoryID(nextInt())
                .priorityID(nextInt())
                .groupID(nextInt())
                .userID(randomAlphabetic(20))
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .status(randomPersistedTicketStatus())
                .comments(randomTicketComments())
                .requesterID(randomAlphabetic(10))
                .build();
    }

    public static TicketStatus randomPersistedTicketStatus() {
        return TicketStatus.builder()
                .id(nextInt())
                .name(randomAlphabetic(20))
                .build();
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
                .createDateTime(LocalDateTime.now())
                .ticket(ticket)
                .build();
    }

    public static List<TicketComment> randomTicketComments() {
        List<TicketComment> list = new ArrayList<>();
        int size = nextInt(5, 10);
        for (int i = 0; i < size; i++)
            list.add(randomPersistedTicketComment());
        return list;
    }
}

package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketStatus;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class Entities {
    public static Ticket randomTicket() {
        return Ticket.builder()
                .id("INC0000001")
                .subject(randomAlphabetic(20))
                .description(randomAlphabetic(20, 1000))
                .categoryID(nextInt())
                .priorityID(nextInt())
                .groupID(nextInt())
                .userID(randomAlphabetic(20))
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .status(randomTicketStatus())
                .build();
    }

    private static TicketStatus randomTicketStatus() {
        return TicketStatus.builder()
                .name(randomAlphabetic(20))
                .build();
    }
}
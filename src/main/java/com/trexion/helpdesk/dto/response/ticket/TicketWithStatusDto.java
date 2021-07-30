package com.trexion.helpdesk.dto.response.ticket;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketWithStatusDto {
    String id;
    String subject;
    String description;
    TicketStatusDto status;

    @Value
    public static class TicketStatusDto {
        String status;
    }
}

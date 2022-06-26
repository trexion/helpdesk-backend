package com.trexion.helpdesk.dto.request.ticket;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TicketRequestDto {
    String subject;
    String description;
    Integer category;
    Integer priority;
    String requester;
    String recipient;
    String technician;
    Integer group;
    Integer configurationItem;
}

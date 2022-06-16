package com.trexion.helpdesk.dto.request.ticket;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketPriorityRequestDto {
    String name;
    Boolean active;
}

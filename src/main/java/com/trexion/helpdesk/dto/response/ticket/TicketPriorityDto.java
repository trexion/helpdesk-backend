package com.trexion.helpdesk.dto.response.ticket;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketPriorityDto {
    Integer id;
    String name;
}

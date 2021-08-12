package com.trexion.helpdesk.dto.response.ticket;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketStatusDto {
    Integer id;
    String name;
}

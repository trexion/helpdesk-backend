package com.trexion.helpdesk.dto.response.ticket;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class TicketDto {
    Long id;
    String subject;
    String description;
    String status;
    String category;
    String priority;
    String requester;
    String recipient;
    String technician;
    String group;
    String configurationItem;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;
}

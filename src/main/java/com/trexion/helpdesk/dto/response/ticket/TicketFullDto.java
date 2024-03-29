package com.trexion.helpdesk.dto.response.ticket;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class TicketFullDto {
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
    List<TicketCommentDto> comments;

    @Value
    public static class TicketCommentDto {
        String comment;
        String userName;
        LocalDateTime createDateTime;
    }
}

package com.trexion.helpdesk.dto.response.ticket;

import com.trexion.helpdesk.entity.ticket.TicketCategory;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class TicketFullDto {
    String id;
    String subject;
    String description;
    String status;
    String category;
    List<TicketCommentDto> comments;

    @Value
    public static class TicketCommentDto {
        String comment;
        String userID;
        LocalDateTime createDateTime;
    }
}

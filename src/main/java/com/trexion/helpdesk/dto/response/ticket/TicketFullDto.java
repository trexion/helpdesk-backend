package com.trexion.helpdesk.dto.response.ticket;

import com.trexion.helpdesk.entity.ticket.TicketComment;
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
    TicketStatusDto status;
    List<TicketCommentDto> comments;

    @Value
    public static class TicketStatusDto {
        String status;
    }

    @Value
    public static class TicketCommentDto {
        Integer id;
        String comment;
        String userID;
        LocalDateTime createDateTime;
    }
}
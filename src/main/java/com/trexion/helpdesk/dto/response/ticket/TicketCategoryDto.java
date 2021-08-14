package com.trexion.helpdesk.dto.response.ticket;

import com.trexion.helpdesk.entity.ticket.TicketCategoryChildrenDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class TicketCategoryDto {
    Integer id;
    String name;
    List<TicketCategoryChildrenDto> children;
}
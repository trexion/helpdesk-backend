package com.trexion.helpdesk.entity.ticket;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class TicketCategoryChildrenDto {
    private Integer id;
    private String name;
    private List<TicketCategoryChildrenDto> children;
}

package com.trexion.helpdesk.dto.request.ticket;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketCategoryRequestDto {
    Integer id;
    String name;
    Boolean active;
    Integer parentId;
}

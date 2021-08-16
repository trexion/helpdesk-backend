package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.response.ticket.TicketPriorityDto;
import com.trexion.helpdesk.entity.ticket.TicketPriority;
import com.trexion.helpdesk.repository.ticket.TicketPriorityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketPriorityService {
    private final TicketPriorityRepo ticketPriorityRepo;

    public List<TicketPriorityDto> getAll() {
        return ticketPriorityRepo.findAllByActiveIsTrue().stream().map(this::mapToTicketPriorityDto).collect(Collectors.toList());
    }

    private TicketPriorityDto mapToTicketPriorityDto(TicketPriority ticketPriority) {
        return TicketPriorityDto.builder()
                .id(ticketPriority.getId())
                .name(ticketPriority.getName())
                .build();
    }
}

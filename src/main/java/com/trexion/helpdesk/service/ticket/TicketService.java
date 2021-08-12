package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.response.ticket.TicketFullDto;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.repository.ticket.TicketRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {
    private final TicketRepo ticketRepo;

    public Iterable<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    public TicketFullDto getTicket(String ticketID) {
        return mapTicketToDto(ticketRepo.getById(ticketID));
    }

    private TicketFullDto mapTicketToDto(Ticket ticket) {
        return TicketFullDto.builder()
                .id(ticket.getId())
                .subject(ticket.getSubject())
                .description(ticket.getDescription())
                .status(new TicketFullDto.TicketStatusDto(ticket.getStatus().getName()))
                .comments(new TicketFullDto.TicketCommentDto(ticket.getComments())
                .build();
    }
}

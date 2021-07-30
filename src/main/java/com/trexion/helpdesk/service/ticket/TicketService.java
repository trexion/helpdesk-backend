package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.response.ticket.TicketWithStatusDto;
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

  public TicketWithStatusDto getTicket(String ticketID) {
    return mapTicketToDto(ticketRepo.getById(ticketID));
  }

  private TicketWithStatusDto mapTicketToDto (Ticket ticket){
    return TicketWithStatusDto.builder()
        .id(ticket.getId())
        .subject(ticket.getSubject())
        .description(ticket.getDescription())
        .status(new TicketWithStatusDto.TicketStatusDto(ticket.getStatus().getName()))
        .build();
  }
}

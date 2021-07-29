package com.trexion.helpdesk.service.ticket;

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
}

package com.trexion.helpdesk.controller;

import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {
  private final TicketService ticketService;

  @GetMapping()
  public ResponseEntity<Iterable<Ticket>> getAllTickets(){
    return ResponseEntity.ok(ticketService.getAll());
  }

  @GetMapping("/{ticketID}")
  public ResponseEntity<Ticket> getTicket(@PathVariable("ticketID") String ticketID){
    return ResponseEntity.ok(ticketService.getTicket(ticketID));
  }
}

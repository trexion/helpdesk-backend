package com.trexion.helpdesk.controller;

import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TicketController {
  private final TicketService ticketService;

  @GetMapping("/api/ticket")
  public ResponseEntity<Iterable<Ticket>> getAllTickets(){
    return ResponseEntity.ok(ticketService.getAll());
  }
}

package com.trexion.helpdesk.controller;

import com.trexion.helpdesk.dto.response.ticket.TicketWithStatusDto;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {
  private final TicketService ticketService;

  @GetMapping
  public ResponseEntity getTicket(@RequestParam(required = false) String id){
    if(id==null)
      return ResponseEntity.ok(ticketService.getAll());
    else
      return ResponseEntity.ok(ticketService.getTicket(id));
  }
}

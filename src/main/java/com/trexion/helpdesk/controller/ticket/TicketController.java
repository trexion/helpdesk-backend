package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketRequestDto;
import com.trexion.helpdesk.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicket(id));
    }

    @PostMapping
    public ResponseEntity createTicket(@RequestBody TicketRequestDto ticketRequestDto) {
        return ResponseEntity.ok(ticketService.createTicket(ticketRequestDto));
    }
}

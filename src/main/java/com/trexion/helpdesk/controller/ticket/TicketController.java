package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity getTicket(@RequestParam(required = false) Long id) {
        if (id == null)
            return ResponseEntity.ok(ticketService.getAll());
        else
            return ResponseEntity.ok(ticketService.getTicket(id));
    }
}

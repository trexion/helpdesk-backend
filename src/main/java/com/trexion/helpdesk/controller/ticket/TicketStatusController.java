package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.service.ticket.TicketStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketStatus")
@RequiredArgsConstructor
public class TicketStatusController {
    private final TicketStatusService ticketStatusService;

    @GetMapping
    public ResponseEntity getTicket(@RequestParam(required = false) Integer id) {
        if (id == null)
            return ResponseEntity.ok(ticketStatusService.getAll());
        else
            return ResponseEntity.ok(ticketStatusService.getStatus(id));
    }
}

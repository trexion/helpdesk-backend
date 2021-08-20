package com.trexion.helpdesk.controller;

import com.trexion.helpdesk.service.ticket.TicketPriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketPriority")
@RequiredArgsConstructor
public class TicketPriorityController {
    private final TicketPriorityService ticketPriorityService;

    @GetMapping
    public ResponseEntity getTicket(@RequestParam(required = false) Integer id) {
        if (id == null)
            return ResponseEntity.ok(ticketPriorityService.getAll());
        else
            return ResponseEntity.ok(ticketPriorityService.getPriority(id));
    }
}

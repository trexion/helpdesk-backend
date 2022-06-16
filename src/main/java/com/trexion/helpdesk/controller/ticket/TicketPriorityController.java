package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketPriorityRequestDto;
import com.trexion.helpdesk.dto.response.ticket.TicketPriorityDto;
import com.trexion.helpdesk.service.ticket.TicketPriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticketPriority")
@RequiredArgsConstructor
public class TicketPriorityController {
    private final TicketPriorityService ticketPriorityService;

    @GetMapping
    public ResponseEntity getAllTicketPriorities() {
        return ResponseEntity.ok(ticketPriorityService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getTicketPriority(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketPriorityService.getTicketPriority(id));
    }

    @PostMapping
    public ResponseEntity createTicketPriority(@RequestBody TicketPriorityRequestDto ticketPriorityRequestDto) {
        return ResponseEntity.ok(ticketPriorityService.createTicketPriority(ticketPriorityRequestDto));
    }

    @PutMapping
    public ResponseEntity editTicketPriority(@RequestBody TicketPriorityDto ticketPriorityDto) {
        return ResponseEntity.ok(ticketPriorityService.editTicketPriority(ticketPriorityDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity disableTicketPriority(@PathVariable Integer id) {
        ticketPriorityService.disableTicketPriority(id);
        return ResponseEntity.ok(String.format("Ticket priority %d disabled successfully", id));
    }
}

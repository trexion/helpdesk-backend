package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketStatusRequestDto;
import com.trexion.helpdesk.dto.response.ticket.TicketStatusDto;
import com.trexion.helpdesk.service.ticket.TicketStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticketStatus")
@RequiredArgsConstructor
public class TicketStatusController {
    private final TicketStatusService ticketStatusService;

    @GetMapping
    public ResponseEntity getAllTicketStatus() {
            return ResponseEntity.ok(ticketStatusService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicketStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketStatusService.getTicketStatus(id));
    }

    @PostMapping
    public ResponseEntity createTicketStatus(@RequestBody TicketStatusRequestDto ticketStatusRequestDto) {
        return ResponseEntity.ok(ticketStatusService.createTicketStatus(ticketStatusRequestDto));
    }

    @PutMapping
    public ResponseEntity editTicketStatus(@RequestBody TicketStatusDto ticketStatusDto) {
        return ResponseEntity.ok(ticketStatusService.editTicketStatus(ticketStatusDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity disableTicketStatus(@PathVariable Integer id) {
        ticketStatusService.disableTicketStatus(id);
        return ResponseEntity.ok(String.format("Ticket status %d disabled successfully", id));
    }

}

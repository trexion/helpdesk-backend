package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketCategoryRequestDto;
import com.trexion.helpdesk.service.ticket.TicketCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticketCategory")
@RequiredArgsConstructor
public class TicketCategoryController {
    private final TicketCategoryService ticketCategoryService;

    @GetMapping
    public ResponseEntity getTicketCategories() {
        return ResponseEntity.ok(ticketCategoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicketCategory(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketCategoryService.getTicketCategory(id));
    }

    @PostMapping
    public ResponseEntity createTicketCategories(@RequestBody TicketCategoryRequestDto ticketCategoryRequestDto) {
        return ResponseEntity.ok(ticketCategoryService.createTicketCategory(ticketCategoryRequestDto));
    }

    @PutMapping
    public ResponseEntity editTicketCategories(@RequestBody TicketCategoryRequestDto ticketCategoryRequestDto) {
        return ResponseEntity.ok(ticketCategoryService.editTicketCategory(ticketCategoryRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity disableTicketCategory(@PathVariable Integer id) {
        ticketCategoryService.disableTicketCategory(id);
        return ResponseEntity.ok(String.format("Ticket Category %d disabled successfully", id));
    }
}

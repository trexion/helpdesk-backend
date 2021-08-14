package com.trexion.helpdesk.controller;

import com.trexion.helpdesk.service.ticket.TicketCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketCategory")
@RequiredArgsConstructor
public class TicketCategoryController {
    private final TicketCategoryService ticketCategoryService;
    @GetMapping
    public ResponseEntity getCategories() {
        return ResponseEntity.ok(ticketCategoryService.getAll());
    }
}

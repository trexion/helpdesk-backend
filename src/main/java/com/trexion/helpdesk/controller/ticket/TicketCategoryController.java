package com.trexion.helpdesk.controller.ticket;

import com.trexion.helpdesk.service.ticket.TicketCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketCategory")
@RequiredArgsConstructor
public class TicketCategoryController {
    private final TicketCategoryService ticketCategoryService;

    @GetMapping
    public ResponseEntity getCategories(@RequestParam(required = false) Integer id) {
        if (id == null)
            return ResponseEntity.ok(ticketCategoryService.getAll());
        else
            return ResponseEntity.ok(ticketCategoryService.getCategory(id));
    }
}

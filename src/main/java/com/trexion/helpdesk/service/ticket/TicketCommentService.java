package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.entity.ticket.TicketComment;
import com.trexion.helpdesk.repository.ticket.TicketCommentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketCommentService {
    private final TicketCommentRepo ticketCommentRepo;

    public List<TicketComment> getAll() {
        return ticketCommentRepo.findAll();
    }
}

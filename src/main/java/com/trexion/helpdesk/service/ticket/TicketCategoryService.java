package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.entity.ticket.TicketCategory;
import com.trexion.helpdesk.repository.ticket.TicketCategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketCategoryService {
    private final TicketCategoryRepo ticketCategoryRepo;

    public List<TicketCategory> getAll(){
        return ticketCategoryRepo.findAll();
    }

}

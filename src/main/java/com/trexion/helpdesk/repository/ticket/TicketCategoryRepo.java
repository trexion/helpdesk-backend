package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketCategoryRepo extends JpaRepository<TicketCategory, Integer> {
    List<TicketCategory> findAllByParent(TicketCategory parent);
}

package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoryRepo extends JpaRepository<TicketCategory, Integer> {
}

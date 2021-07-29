package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketStatusRepo extends JpaRepository<TicketStatus, Integer> {
}

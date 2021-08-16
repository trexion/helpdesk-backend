package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.TicketPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPriorityRepo extends JpaRepository<TicketPriority, Integer> {
}

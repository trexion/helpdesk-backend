package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,String> {
}

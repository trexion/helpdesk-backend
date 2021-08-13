package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.TicketComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCommentRepo extends JpaRepository<TicketComment, Integer> {
}

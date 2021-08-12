package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketComment;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TicketCommentRepoTest {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private TicketStatusRepo ticketStatusRepo;
    @Autowired
    private TicketCommentRepo ticketCommentRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_(){
        //Given
        TicketStatus ticketStatus = Entities.randomPersistedTicketStatus();
        ticketStatusRepo.save(ticketStatus);

        Ticket ticket = Entities.randomPersistedTicket();
        ticketRepo.save(ticket);

        TicketComment ticketComment = Entities.randomPersistedTicketComment(ticket);
        //When
        ticketCommentRepo.save(ticketComment);
        //Then
        assertThat(ticketCommentRepo.getById(ticketComment.getId()));
    }
}
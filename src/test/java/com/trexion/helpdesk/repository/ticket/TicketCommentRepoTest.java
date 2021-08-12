package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketComment;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import org.junit.jupiter.api.BeforeEach;
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

    private Ticket newTicket;

    @BeforeEach
    void init() {
        newTicket = Entities.randomTicket();
        ticketStatusRepo.save(newTicket.getStatus());
        ticketRepo.save(newTicket);
    }

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        TicketComment ticketComment = Entities.randomPersistedTicketComment(newTicket);

        //When
        ticketCommentRepo.save(ticketComment);

        //Then
        assertThat(ticketComment.getId()).satisfies(
                v -> {
                    assertThat(v).isNotNull();
                    assertThat(ticketCommentRepo.findById(v)).isNotNull();
                }
        );
    }
}
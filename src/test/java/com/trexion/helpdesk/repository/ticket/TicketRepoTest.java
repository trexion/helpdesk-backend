package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TicketRepoTest {

    @Autowired
    private TicketRepo repo;
    @Autowired
    private TicketStatusRepo ticketStatusRepo;

    @Test
    @DisplayName("Ticket should be 'saveable'")
    void ticket_() {
        //Given
        Ticket ticket = Entities.randomTicket();
        ticketStatusRepo.save(ticket.getStatus());

        //When
        repo.save(ticket);

        //Then
        assertThat(ticket).extracting(Ticket::getId).isNotNull();
    }
}
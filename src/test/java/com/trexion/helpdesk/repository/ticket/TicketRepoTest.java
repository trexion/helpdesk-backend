package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.entity.ticket.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TicketRepoTest {

    @Autowired
    private TicketRepo repo;
    @Autowired
    private TicketStatusRepo ticketStatusRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        Ticket ticket = Entities.randomTicket();
        ticketStatusRepo.save(ticket.getStatus());

        //When
        repo.save(ticket);

        //Then
        assertThat(repo.getById(ticket.getId())).isEqualTo(ticket);
    }
}
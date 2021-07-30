package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TicketStatusRepoTest {
    @Autowired
    private TicketStatusRepo ticketStatusRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        TicketStatus ticketStatus = Entities.randomTicketStatus();

        //When
        ticketStatusRepo.save(ticketStatus);

        //Then
        assertThat(ticketStatusRepo.getById(ticketStatus.getId())).isEqualTo(ticketStatus);
    }

}
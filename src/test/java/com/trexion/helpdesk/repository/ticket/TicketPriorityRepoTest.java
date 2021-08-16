package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.ticket.TicketPriority;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TicketPriorityRepoTest {
    @Autowired
    private TicketPriorityRepo ticketPriorityRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        TicketPriority ticketPriority = Entities.randomTicketPriority();

        //When
        ticketPriorityRepo.save(ticketPriority);

        //Then
        assertThat(ticketPriorityRepo.getById(ticketPriority.getId())).isEqualTo(ticketPriority);
    }
}
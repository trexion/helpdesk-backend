package com.trexion.helpdesk.repository.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.ticket.TicketCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class TicketCategoryRepoTest {
    @Autowired
    private TicketCategoryRepo ticketCategoryRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        TicketCategory ticketCategory = Entities.randomTicketCategory();

        //When
        ticketCategoryRepo.save(ticketCategory);

        //Then
        assertThat(ticketCategoryRepo.getById(ticketCategory.getId())).isEqualTo(ticketCategory);
    }
}
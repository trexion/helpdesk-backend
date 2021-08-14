package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.dto.response.ticket.TicketCategoryDto;
import com.trexion.helpdesk.entity.ticket.TicketCategory;
import com.trexion.helpdesk.repository.ticket.TicketCategoryRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketCategoryServiceTest {
    @Mock
    TicketCategoryRepo ticketCategoryRepo;

    @InjectMocks
    TicketCategoryService ticketCategoryService;

    @Test
    @DisplayName("getAll should map all ticket category entities to DTOs")
    void getAll() {
        //Given
        List<TicketCategory> ticketCategories = Entities.randomTicketCategories();
        when(ticketCategoryRepo.findAllByParent(null)).thenReturn(ticketCategories);

        //When
        List<TicketCategoryDto> result = ticketCategoryService.getAll();

        //Then
        assertThat(result).isNotEmpty().hasSize(ticketCategories.size());

    }
}
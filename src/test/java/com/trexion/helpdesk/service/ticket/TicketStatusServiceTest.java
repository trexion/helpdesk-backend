package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.dto.response.ticket.TicketStatusDto;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import com.trexion.helpdesk.repository.ticket.TicketStatusRepo;
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
class TicketStatusServiceTest {
    @Mock
    private TicketStatusRepo repo;

    @InjectMocks
    private TicketStatusService service;

    @Test
    @DisplayName("getAll should map all ticket status entities to DTOs")
    void getAll() {
        //Given
        List<TicketStatus> statuses = Entities.randomTicketStatuses();
        when(repo.findAll()).thenReturn(statuses);

        //When
        List<TicketStatusDto> result = service.getAll();

        //Then
        assertThat(result).isNotEmpty().hasSize(statuses.size());
    }
}
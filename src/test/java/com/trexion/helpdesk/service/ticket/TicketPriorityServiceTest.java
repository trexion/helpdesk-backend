package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.dto.response.ticket.TicketPriorityDto;
import com.trexion.helpdesk.dto.response.ticket.TicketStatusDto;
import com.trexion.helpdesk.entity.ticket.TicketPriority;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import com.trexion.helpdesk.repository.ticket.TicketPriorityRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketPriorityServiceTest {
    @Mock
    private TicketPriorityRepo ticketPriorityRepo;

    @InjectMocks
    private TicketPriorityService ticketPriorityService;

    @Test
    @DisplayName("getAll should map all ticket priority entities to DTOs")
    void getAll(){
        //Given
        List<TicketPriority> priorities = Entities.randomTicketPriorities();
        when(ticketPriorityRepo.findAllByActiveIsTrue()).thenReturn(priorities);

        //When
        List<TicketPriorityDto> result = ticketPriorityService.getAll();

        //Then
        assertThat(result).isNotEmpty().hasSize(priorities.size());
    }
}
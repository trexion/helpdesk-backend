package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.response.ticket.TicketStatusDto;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import com.trexion.helpdesk.repository.ticket.TicketStatusRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketStatusService {
    private final TicketStatusRepo ticketStatusRepo;

    public List<TicketStatusDto> getAll() {
        return ticketStatusRepo.findAll().stream().map(t -> mapTicketStatusToDto(t));

    }

    public TicketStatusDto getStatus(Integer id) {
        return mapTicketStatusToDto(ticketStatusRepo.getById(id));
    }


    private TicketStatusDto mapTicketStatusToDto(TicketStatus ticketStatus) {
        return TicketStatusDto.builder()
                .id(ticketStatus.getId())
                .name(ticketStatus.getName())
                .build();
    }
}

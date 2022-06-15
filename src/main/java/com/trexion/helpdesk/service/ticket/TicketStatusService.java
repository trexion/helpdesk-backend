package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketStatusRequestDto;
import com.trexion.helpdesk.dto.response.ticket.TicketStatusDto;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import com.trexion.helpdesk.repository.ticket.TicketStatusRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketStatusService {
    private final TicketStatusRepo ticketStatusRepo;

    public List<TicketStatusDto> getAll() {
        return ticketStatusRepo.findAll().stream().map(TicketStatusService::mapTicketStatusToDto).collect(Collectors.toList());
    }

    public TicketStatusDto getTicketStatus(Integer id) {
        return mapTicketStatusToDto(ticketStatusRepo.getById(id));
    }

    public TicketStatusDto createTicketStatus(TicketStatusRequestDto ticketStatusRequestDto){
        return mapTicketStatusToDto(ticketStatusRepo.save(TicketStatus.builder()
                .name(ticketStatusRequestDto.getName())
                .active(ticketStatusRequestDto.getActive())
            .build()));
    }

    public TicketStatusDto editTicketStatus(TicketStatusDto ticketStatusDto){
        TicketStatus ticketStatus = ticketStatusRepo.getById(ticketStatusDto.getId());
        ticketStatus.setName(ticketStatusDto.getName());
        return mapTicketStatusToDto(ticketStatusRepo.save(ticketStatus));
    }

    public void disableTicketStatus(Integer id){
        TicketStatus ticketStatus = ticketStatusRepo.getById(id);
        ticketStatus.setActive(false);
        ticketStatusRepo.save(ticketStatus);
    }

    private static TicketStatusDto mapTicketStatusToDto(TicketStatus ticketStatus) {
        return TicketStatusDto.builder()
            .id(ticketStatus.getId())
            .name(ticketStatus.getName())
            .build();
    }
}

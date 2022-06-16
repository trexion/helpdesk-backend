package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketPriorityRequestDto;
import com.trexion.helpdesk.dto.response.ticket.TicketPriorityDto;
import com.trexion.helpdesk.entity.ticket.TicketPriority;
import com.trexion.helpdesk.repository.ticket.TicketPriorityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketPriorityService {
    private final TicketPriorityRepo ticketPriorityRepo;

    public List<TicketPriorityDto> getAll() {
        return ticketPriorityRepo.findAllByActiveIsTrue().stream().map(this::mapToTicketPriorityDto).collect(Collectors.toList());
    }

    public TicketPriorityDto getTicketPriority(Integer id){
        return mapToTicketPriorityDto(ticketPriorityRepo.getById(id));
    }

    public TicketPriorityDto createTicketPriority(TicketPriorityRequestDto ticketPriorityRequestDto){
        return mapToTicketPriorityDto(ticketPriorityRepo.save(TicketPriority.builder()
                .name(ticketPriorityRequestDto.getName())
                .active(ticketPriorityRequestDto.getActive())
            .build()));
    }

    public TicketPriorityDto editTicketPriority(TicketPriorityDto ticketPriorityDto){
        TicketPriority ticketPriority = ticketPriorityRepo.getById(ticketPriorityDto.getId());
        ticketPriority.setName(ticketPriorityDto.getName());
        return mapToTicketPriorityDto(ticketPriorityRepo.save(ticketPriority));
    }

    public void disableTicketPriority(Integer id){
        TicketPriority ticketPriority = ticketPriorityRepo.getById(id);
        ticketPriority.setActive(false);
        ticketPriorityRepo.save(ticketPriority);
    }

    private TicketPriorityDto mapToTicketPriorityDto(TicketPriority ticketPriority) {
        return TicketPriorityDto.builder()
            .id(ticketPriority.getId())
            .name(ticketPriority.getName())
            .build();
    }
}

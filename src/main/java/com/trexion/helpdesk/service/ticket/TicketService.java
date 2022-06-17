package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.response.ticket.TicketDto;
import com.trexion.helpdesk.dto.response.ticket.TicketFullDto;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.repository.ticket.TicketRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {
    private final TicketRepo ticketRepo;

    public List<TicketDto> getAllTickets() {
        return ticketRepo.findAll().stream().map(TicketService::mapToTicketDto).collect(Collectors.toList());
    }

    public TicketFullDto getTicket(Long ticketID) {
        return mapTicketToFullDto(ticketRepo.getById(ticketID));
    }

    private static TicketDto mapToTicketDto(Ticket ticket){
        return TicketDto.builder()
                .id(ticket.getId())
                .subject(ticket.getSubject())
                .description(ticket.getDescription())
                .status(ticket.getStatus().getName())
                .category(ticket.getCategory().getName())
                .priority(ticket.getPriority().getName())
                .requester(ticket.getRequester().getAccess().getUserName())
                .recipient(ticket.getUser().getAccess().getUserName())
                .technician(ticket.getTechnician().getAccess().getUserName())
                .group(ticket.getGroup().getName())
                .configurationItem(ticket.getConfigurationItem().getName())
                .createDateTime(ticket.getCreateDateTime())
                .updateDateTime(ticket.getUpdateDateTime())
                .build();
    }

    private TicketFullDto mapTicketToFullDto(Ticket ticket) {
        return TicketFullDto.builder()
            .id(ticket.getId())
            .subject(ticket.getSubject())
            .description(ticket.getDescription())
            .status(ticket.getStatus().getName())
            .category(ticket.getCategory().getName())
            .priority(ticket.getPriority().getName())
            .requester(ticket.getRequester().getAccess().getUserName())
            .recipient(ticket.getUser().getAccess().getUserName())
            .technician(ticket.getTechnician().getAccess().getUserName())
            .group(ticket.getGroup().getName())
            .configurationItem(ticket.getConfigurationItem().getName())
            .createDateTime(ticket.getCreateDateTime())
            .updateDateTime(ticket.getUpdateDateTime())
            .comments(mapCommentsToCommentDto(ticket))
            .build();
    }

    private List<TicketFullDto.TicketCommentDto> mapCommentsToCommentDto(Ticket ticket) {
        return ticket.getComments().stream()
            .map(v -> new TicketFullDto.TicketCommentDto(v.getComment(), v.getUserAccess().getUserName(), v.getCreateDateTime()))
            .collect(Collectors.toList());
    }
}

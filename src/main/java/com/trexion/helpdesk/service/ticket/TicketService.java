package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketRequestDto;
import com.trexion.helpdesk.dto.response.ticket.TicketDto;
import com.trexion.helpdesk.dto.response.ticket.TicketFullDto;
import com.trexion.helpdesk.entity.configuration_item.ConfigurationItem;
import com.trexion.helpdesk.entity.group.Group;
import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.ticket.TicketCategory;
import com.trexion.helpdesk.entity.ticket.TicketPriority;
import com.trexion.helpdesk.entity.ticket.TicketStatus;
import com.trexion.helpdesk.entity.user.access.UserAccess;
import com.trexion.helpdesk.repository.configuration_item.ConfigurationItemRepo;
import com.trexion.helpdesk.repository.group.GroupRepo;
import com.trexion.helpdesk.repository.ticket.*;
import com.trexion.helpdesk.repository.user.access.UserAccessRepo;
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
    private final UserAccessRepo userAccessRepo;
    private final TicketPriorityRepo ticketPriorityRepo;
    private final TicketCategoryRepo ticketCategoryRepo;
    private final TicketStatusRepo ticketStatusRepo;
    private final TicketCommentRepo ticketCommentRepo;
    private final GroupRepo groupRepo;
    private final ConfigurationItemRepo configurationItemRepo;

    public List<TicketDto> getAllTickets() {
        return ticketRepo.findAll().stream().map(TicketService::mapToTicketDto).collect(Collectors.toList());
    }

    public TicketFullDto getTicket(Long ticketID) {
        return mapTicketToFullDto(ticketRepo.getById(ticketID));
    }

    public TicketDto createTicket(TicketRequestDto ticketRequestDto){
        UserAccess requester = userAccessRepo.findByUserName(ticketRequestDto.getRequester()).orElseThrow(/*TODO*/);
        UserAccess recipient = userAccessRepo.findByUserName(ticketRequestDto.getRecipient()).orElseThrow(/*TODO*/);
        UserAccess technician = userAccessRepo.findByUserName(ticketRequestDto.getTechnician()).orElseThrow(/*TODO*/);

        TicketPriority ticketPriority = ticketPriorityRepo.getById(ticketRequestDto.getPriority());
        TicketCategory ticketCategory = ticketCategoryRepo.getById(ticketRequestDto.getCategory());
        TicketStatus ticketStatus = ticketStatusRepo.findByName("Submitted");

        Group group = groupRepo.getById(ticketRequestDto.getGroup());
        ConfigurationItem configurationItem = configurationItemRepo.getById(ticketRequestDto.getConfigurationItem());

        return mapToTicketDto(ticketRepo.save(Ticket.builder()
                        .subject(ticketRequestDto.getSubject())
                        .description(ticketRequestDto.getDescription())
                        .status(ticketStatus)
                        .requester(requester)
                        .user(recipient)
                        .technician(technician)
                        .priority(ticketPriority)
                        .category(ticketCategory)
                        .group(group)
                        .configurationItem(configurationItem)
                .build()));
    }

    private static TicketDto mapToTicketDto(Ticket ticket){
        return TicketDto.builder()
                .id(ticket.getId())
                .subject(ticket.getSubject())
                .description(ticket.getDescription())
                .status(ticket.getStatus().getName())
                .category(ticket.getCategory().getName())
                .priority(ticket.getPriority().getName())
                .requester(ticket.getRequester().getUserName())
                .recipient(ticket.getUser().getUserName())
                .technician(ticket.getTechnician().getUserName())
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
            .requester(ticket.getRequester().getUserName())
            .recipient(ticket.getUser().getUserName())
            .technician(ticket.getTechnician().getUserName())
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

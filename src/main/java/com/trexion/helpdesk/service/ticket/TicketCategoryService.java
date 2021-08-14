package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.response.ticket.TicketCategoryDto;
import com.trexion.helpdesk.entity.ticket.TicketCategory;
import com.trexion.helpdesk.repository.ticket.TicketCategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketCategoryService {
    private final TicketCategoryRepo ticketCategoryRepo;

    public List<TicketCategoryDto> getAll() {
        return ticketCategoryRepo.findAllByParent(null).stream().map(this::mapToTicketCategoryDto).collect(Collectors.toList());
    }

    public TicketCategoryDto getCategory(Integer id) {
        return mapToTicketCategoryDto(ticketCategoryRepo.getById(id));
    }

    private TicketCategoryDto mapToTicketCategoryDto(TicketCategory ticketCategory) {
        return TicketCategoryDto.builder()
                .id(ticketCategory.getId())
                .name(ticketCategory.getName())
                .children(ticketCategory.getChildren().stream().map(this::mapToTicketCategoryDto).collect(Collectors.toList()))
                .build();
    }
}

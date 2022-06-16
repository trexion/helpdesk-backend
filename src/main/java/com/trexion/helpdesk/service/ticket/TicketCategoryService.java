package com.trexion.helpdesk.service.ticket;

import com.trexion.helpdesk.dto.request.ticket.TicketCategoryRequestDto;
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
        return ticketCategoryRepo.findAllParentCategories().stream().map(this::mapToTicketCategoryDto).collect(Collectors.toList());
    }

    public TicketCategoryDto getTicketCategory(Integer id) {
        return mapToTicketCategoryDto(ticketCategoryRepo.getById(id));
    }

    public TicketCategoryRequestDto createTicketCategory(TicketCategoryRequestDto ticketCategoryRequestDto){
        return mapToTicketCategoryRequestDto(ticketCategoryRepo.save(TicketCategory.builder()
                .name(ticketCategoryRequestDto.getName())
                .active(ticketCategoryRequestDto.getActive())
                .parent(ticketCategoryRequestDto.getParentId() != null ? ticketCategoryRepo.getById(ticketCategoryRequestDto.getParentId()) : null)
            .build()));
    }

    public TicketCategoryDto editTicketCategory(TicketCategoryRequestDto ticketCategoryRequestDto){
        TicketCategory ticketCategory = ticketCategoryRepo.getById(ticketCategoryRequestDto.getId());
        ticketCategory.setName(ticketCategoryRequestDto.getName());
        ticketCategory.setParent(ticketCategoryRepo.getById(ticketCategoryRequestDto.getParentId()));
        return mapToTicketCategoryDto(ticketCategoryRepo.save(ticketCategory));
    }

    public void disableTicketCategory(Integer id){
        TicketCategory ticketCategory = ticketCategoryRepo.getById(id);
        if(ticketCategory.getChildren().isEmpty()){
            ticketCategory.setActive(false);
            ticketCategoryRepo.save(ticketCategory);
        }
    }

    private TicketCategoryDto mapToTicketCategoryDto(TicketCategory ticketCategory) {
        return TicketCategoryDto.builder()
            .id(ticketCategory.getId())
            .name(ticketCategory.getName())
            .children(ticketCategory.getChildren().stream().map(this::mapToTicketCategoryDto).collect(Collectors.toList()))
            .build();
    }

    private static TicketCategoryRequestDto mapToTicketCategoryRequestDto(TicketCategory ticketCategory) {
        return TicketCategoryRequestDto.builder()
            .id(ticketCategory.getId())
            .name(ticketCategory.getName())
            .active(ticketCategory.isActive())
            .parentId(ticketCategory.getParent() != null ? ticketCategory.getParent().getId(): null)
            .build();
    }
}

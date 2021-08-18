package com.trexion.helpdesk.controller;

import com.trexion.helpdesk.controller.ticket.TicketController;
import com.trexion.helpdesk.service.ticket.TicketService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TicketController.class)
@ActiveProfiles("test")
class TicketControllerTest {

    @MockBean
    private TicketService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("getTicket should return all if id is null")
    @SneakyThrows
    void getTicket_() {
        //Given When
        mockMvc.perform(get("/api/ticket"))
                .andExpect(status().isOk());

        //Then
        verify(service, times(1)).getAll();
    }

}
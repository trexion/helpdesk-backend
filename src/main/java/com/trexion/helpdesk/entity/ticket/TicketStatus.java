package com.trexion.helpdesk.entity.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketStatus {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @NonNull
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active;
    @OneToMany(mappedBy = "status")
    private List<Ticket> tickets;
}

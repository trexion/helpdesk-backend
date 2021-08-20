package com.trexion.helpdesk.entity.ticket;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketPriority {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @NonNull
    @Column(nullable = false)
    private String name;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active = true;
    @OneToMany(mappedBy = "priority")
    private List<Ticket> tickets;
}

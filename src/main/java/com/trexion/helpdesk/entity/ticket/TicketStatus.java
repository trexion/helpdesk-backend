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
public class TicketStatus {
  @Id
  @Column(name = "ticket_status_id")
  @EqualsAndHashCode.Include
  private Integer ticketStatusID;
  @NonNull
  private String ticketStatusName;
  @Builder.Default
  private boolean active = true;
  @OneToMany(mappedBy = "status_id")
  private List<Ticket> tickets;
}

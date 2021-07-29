package com.trexion.helpdesk.entity.ticket;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket {
  @Id
  @Column(name = "ticket_id")
  @EqualsAndHashCode.Include
  private String ticketID;
  @NonNull
  private String subject;
  @NonNull
  @Column(columnDefinition = "VARCHAR(1000)")
  private String description;
  @NonNull
  @Column(name = "category_id")
  private Integer categoryID;
  @NonNull
  @Column(name = "priority_id")
  private Integer priorityID;
  @NonNull
  @Column(name = "status_id")
  private Integer statusID;
  @NonNull
  @Column(name = "group_id")
  private Integer groupID;
  @NonNull
  @Column(name = "user_id")
  private String userID;
  @CreationTimestamp
  private LocalDateTime createDateTime;
  @UpdateTimestamp
  private LocalDateTime updateDateTime;
}

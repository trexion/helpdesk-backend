package com.trexion.helpdesk.entity.ticket;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @NonNull
    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String comment;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;
    @NonNull
    @Column(nullable = false)
    private String userID;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime createDateTime;
}
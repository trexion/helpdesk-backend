package com.trexion.helpdesk.entity.ticket;

import com.trexion.helpdesk.entity.user.access.UserAccess;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @JoinColumn(nullable = false, name = "ticket_id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_access_id")
    private UserAccess userAccess;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime createDateTime;
}
package com.trexion.helpdesk.entity.ticket;

import com.trexion.helpdesk.entity.configuration_item.ConfigurationItem;
import com.trexion.helpdesk.entity.group.Group;
import com.trexion.helpdesk.entity.user.access.UserAccess;
import com.trexion.helpdesk.entity.user.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String subject;
    @NonNull
    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String description;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private TicketCategory category;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private TicketPriority priority;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private UserAccess user;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "requester_id")
    private UserAccess requester;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private UserAccess technician;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "configuration_item_id")
    private ConfigurationItem configurationItem;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Ticket> myTickets;
    @OneToMany(mappedBy = "requester")
    @ToString.Exclude
    private List<Ticket> requestedTickets;
    @OneToMany(mappedBy = "technician")
    @ToString.Exclude
    private List<Ticket> technicianTickets;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createDateTime = LocalDateTime.now();
    @UpdateTimestamp
    @NonNull
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime updateDateTime = LocalDateTime.now();
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "status_id")
    @ToString.Exclude
    private TicketStatus status;
    @OneToMany(mappedBy = "ticket")
    private List<TicketComment> comments;
}

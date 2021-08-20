package com.trexion.helpdesk.entity.ticket;

import com.trexion.helpdesk.entity.user.User;
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
    @EqualsAndHashCode.Include
    private String id;
    @NonNull
    @Column(nullable = false)
    private String subject;
    @NonNull
    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String description;
    @NonNull
    @ManyToOne
    private TicketCategory category;
    @NonNull
    @ManyToOne
    private TicketPriority priority;
    @NonNull
    @Column(nullable = false, name = "group_id")
    private Integer groupID;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private User requester;
    @ManyToOne
    @JoinColumn()
    private User technician;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime updateDateTime;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "status_id", referencedColumnName = "id")
    @ToString.Exclude
    private TicketStatus status;
    @OneToMany(mappedBy = "ticket")
    @Singular
    private List<TicketComment> comments;
}

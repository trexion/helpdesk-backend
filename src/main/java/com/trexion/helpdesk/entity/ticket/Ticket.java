package com.trexion.helpdesk.entity.ticket;

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
    @Column(nullable = false, name = "category_id")
    private Integer categoryID;
    @NonNull
    @Column(nullable = false, name = "priority_id")
    private Integer priorityID;
    @NonNull
    @Column(nullable = false, name = "group_id")
    private Integer groupID;
    @NonNull
    @Column(nullable = false, name = "user_id")
    private String userID;
    @NonNull
    @Column(nullable = false, name = "requester_id")
    private String requesterID;
    @NonNull
    @Column(nullable = false, name = "technician_id")
    private String technicianID;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "status_id", referencedColumnName = "ticket_status_id")
    @ToString.Exclude
    private TicketStatus status;
    @OneToMany(mappedBy = "ticket")
    @Singular
    private List<TicketComment> comments;
}

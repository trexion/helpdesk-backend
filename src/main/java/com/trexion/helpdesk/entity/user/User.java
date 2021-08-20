package com.trexion.helpdesk.entity.user;

import com.trexion.helpdesk.entity.ticket.Ticket;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    @EqualsAndHashCode.Include
    private UUID id;
    @NonNull
    @Column(nullable = false)
    private String firstName;
    @NonNull
    @Column(nullable = false)
    private String lastName;
    @NonNull
    @Column(nullable = false,unique = true)
    @Email
    private String email;
    @NonNull
    @Column(nullable = false)
    private Integer phone;
    @NonNull
    private String image;
    @OneToOne
    @JoinColumn(name = "accessId")
    private UserAccess access;
    @OneToMany(mappedBy = "user")
    private List<Ticket> myTickets;
    @OneToMany(mappedBy = "requester")
    private List<Ticket> requestedTickets;
    @OneToMany(mappedBy = "technician")
    private List<Ticket> technicianTickets;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active = true;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime updateDateTime;
}

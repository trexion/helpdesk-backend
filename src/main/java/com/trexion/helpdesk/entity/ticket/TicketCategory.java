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
@Table(uniqueConstraints = {@UniqueConstraint(name = "uniqueName", columnNames = {"name"})})
public class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @NonNull
    @Column(nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private TicketCategory parent;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<TicketCategory> children;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Ticket> tickets;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active = true;
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
}

package com.trexion.helpdesk.entity.configuration_item;

import com.trexion.helpdesk.entity.group.Group;
import com.trexion.helpdesk.entity.ticket.Ticket;
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
public class ConfigurationItem {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @NonNull
    @Column(nullable = false)
    private String name;
    @NonNull
    @Column(nullable = false)
    private String description;
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
    @OneToMany(mappedBy = "configurationItem")
    private List<Ticket> tickets;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}

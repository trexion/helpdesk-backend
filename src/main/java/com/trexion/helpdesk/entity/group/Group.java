package com.trexion.helpdesk.entity.group;

import com.trexion.helpdesk.entity.configuration_item.ConfigurationItem;
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
@Table(name = "user_group", uniqueConstraints = {@UniqueConstraint(name = "uniqueName", columnNames = {"name"})})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Group {
    @Id
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
    @Column(columnDefinition = "boolean default true")
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
    @OneToMany(mappedBy = "group")
    private List<GroupAdmin> groupAdmins;
    @OneToMany(mappedBy = "group")
    private List<AccessGroup> accessGroups;
    @OneToMany(mappedBy = "group")
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "group")
    private List<ConfigurationItem> configurationItems;
}

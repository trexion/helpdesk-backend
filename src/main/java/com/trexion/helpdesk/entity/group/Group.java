package com.trexion.helpdesk.entity.group;

import com.trexion.helpdesk.entity.role.AccessRole;
import com.trexion.helpdesk.entity.role.RoleAdmin;
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
@Table(name = "user_group")
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
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime updateDateTime;
    @OneToMany(mappedBy = "group")
    private List<GroupAdmin> groupAdmins;
    @OneToMany(mappedBy = "group")
    private List<AccessGroup> accessGroups;
    @OneToMany(mappedBy = "group")
    private List<Ticket> tickets;
}

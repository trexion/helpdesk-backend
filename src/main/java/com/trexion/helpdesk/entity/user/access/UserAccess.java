package com.trexion.helpdesk.entity.user.access;

import com.trexion.helpdesk.entity.group.AccessGroup;
import com.trexion.helpdesk.entity.group.GroupAdmin;
import com.trexion.helpdesk.entity.role.AccessRole;
import com.trexion.helpdesk.entity.role.RoleAdmin;
import com.trexion.helpdesk.entity.ticket.TicketComment;
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
@Table(uniqueConstraints = {@UniqueConstraint(name = "uniqueUserName", columnNames = {"userName"})})
public class UserAccess {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @NonNull
    @Column(nullable = false)
    private LocalDateTime updateDateTime;
    @OneToOne(mappedBy = "access")
    private User user;
    @ManyToOne
    private AccessStatus status;
    @OneToMany(mappedBy = "userAccess")
    private List<AccessRole> roles;
    @OneToMany(mappedBy = "userAccess")
    private List<RoleAdmin> roleAdmins;
    @OneToMany(mappedBy = "userAccess")
    private List<AccessGroup> groups;
    @OneToMany(mappedBy = "userAccess")
    private List<GroupAdmin> groupAdmins;
    @OneToMany(mappedBy = "userAccess")
    private List<TicketComment> ticketComments;
}

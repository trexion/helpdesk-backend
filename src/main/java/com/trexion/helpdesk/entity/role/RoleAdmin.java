package com.trexion.helpdesk.entity.role;

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
@Table(uniqueConstraints = {@UniqueConstraint(name = "uniqueRoleUserAccess", columnNames = {"user_access_id", "role_id", "access_id"})})
public class RoleAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_access_id")
    UserAccess userAccess;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
    @ManyToOne
    @JoinColumn(name = "access_id")
    RoleAdminAccess access;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createDateTime = LocalDateTime.now();
}

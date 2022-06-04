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
    private LocalDateTime createDateTime;
}

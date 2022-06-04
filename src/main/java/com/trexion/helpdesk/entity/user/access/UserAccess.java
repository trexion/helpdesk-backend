package com.trexion.helpdesk.entity.user.access;

import com.trexion.helpdesk.entity.user.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccess {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    @EqualsAndHashCode.Include
    private UUID id;
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
}

package com.trexion.helpdesk.entity.group;

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
@Table(uniqueConstraints = {@UniqueConstraint(name = "uniqueUserGroup", columnNames = {"user_access_id", "group_id"})})
public class AccessGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_access_id")
    UserAccess userAccess;
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;
    @CreationTimestamp
    @NonNull
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createDateTime = LocalDateTime.now();
}

package com.trexion.helpdesk.entity.user.user;

import com.trexion.helpdesk.entity.ticket.Ticket;
import com.trexion.helpdesk.entity.user.access.UserAccess;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(uniqueConstraints = {@UniqueConstraint(name = "uniqueEmail", columnNames = {"email"})})
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String firstName;
    @NonNull
    @Column(nullable = false)
    private String lastName;
    @NonNull
    @Column(nullable = false)
    @Email
    private String email;
    @NonNull
    @Column(nullable = false)
    private Integer phone;
    @NonNull
    private String image;
    @OneToOne
    @JoinColumn(name = "accessId")
    @ToString.Exclude
    private UserAccess access;
    @ManyToOne
    @ToString.Exclude
    private UserStatus userStatus;
    @CreationTimestamp
    @Builder.Default
    @NonNull
    @Column(nullable = false)
    private LocalDateTime createDateTime = LocalDateTime.now();
    @UpdateTimestamp
    @Builder.Default
    @NonNull
    @Column(nullable = false)
    private LocalDateTime updateDateTime = LocalDateTime.now();
}

package com.trexion.helpdesk.entity.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @OneToOne
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private User user;
    @Column(nullable = false)
    private String password;
}

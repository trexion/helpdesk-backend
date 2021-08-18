package com.trexion.helpdesk.entity.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    @EqualsAndHashCode.Include
    private UUID id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String userName;
    @NonNull
    @Email
    private String email;
    @NonNull
    private Integer phone;
    @NonNull
    private String image;
}

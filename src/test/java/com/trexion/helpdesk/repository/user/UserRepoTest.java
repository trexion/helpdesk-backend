package com.trexion.helpdesk.repository.user;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        User user = Entities.randomUser();
        //When
        userRepo.save(user);
        //Then
        System.out.println(user.toString());
        assertThat(userRepo.getById(user.getId())).isEqualTo(user);
    }
}
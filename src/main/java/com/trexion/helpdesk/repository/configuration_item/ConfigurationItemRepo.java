package com.trexion.helpdesk.repository.configuration_item;

import com.trexion.helpdesk.entity.configuration_item.ConfigurationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationItemRepo extends JpaRepository<ConfigurationItem, Integer> {
}

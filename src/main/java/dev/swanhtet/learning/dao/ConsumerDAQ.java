package dev.swanhtet.learning.dao;

import dev.swanhtet.learning.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerDAQ extends JpaRepository<Consumer,Long> {
}

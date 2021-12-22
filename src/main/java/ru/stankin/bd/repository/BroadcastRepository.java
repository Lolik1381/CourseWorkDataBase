package ru.stankin.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stankin.bd.entity.BroadcastEntity;

public interface BroadcastRepository extends JpaRepository<BroadcastEntity, String> {
}
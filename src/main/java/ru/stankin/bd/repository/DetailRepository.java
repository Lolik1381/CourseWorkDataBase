package ru.stankin.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stankin.bd.entity.DetailEntity;

public interface DetailRepository extends JpaRepository<DetailEntity, String> {
}
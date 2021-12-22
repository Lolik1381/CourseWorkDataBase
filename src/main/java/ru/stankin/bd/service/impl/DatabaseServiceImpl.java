package ru.stankin.bd.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stankin.bd.entity.DetailEntity;
import ru.stankin.bd.mapper.DatabaseMapper;
import ru.stankin.bd.model.Database;
import ru.stankin.bd.repository.DetailRepository;
import ru.stankin.bd.service.DatabaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseServiceImpl implements DatabaseService {

    private final DetailRepository detailRepository;
    private final DatabaseMapper databaseMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Database> findAll() {
        List<DetailEntity> detailEntities = detailRepository.findAll();

        return detailEntities.stream()
                .map(detailEntity -> databaseMapper.toDto(detailEntity, detailEntity.getBroadcastEntity()))
                .collect(Collectors.toList());
    }
}
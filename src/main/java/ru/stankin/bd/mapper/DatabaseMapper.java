package ru.stankin.bd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.stankin.bd.entity.BroadcastEntity;
import ru.stankin.bd.entity.DetailEntity;
import ru.stankin.bd.model.Database;

@Mapper(componentModel = "spring")
public interface DatabaseMapper {

    @Mapping(target = "id", source = "source.id")
    Database toDto(DetailEntity source, BroadcastEntity broadcast);
}
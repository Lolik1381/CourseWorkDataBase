package ru.stankin.bd.factory;

import ru.stankin.bd.model.DriveType;
import ru.stankin.bd.model.LoadType;

import java.util.Map;

public final class DynamicLoadFactorFactory {

    private static final Map<Map<LoadType, DriveType>, Double> DYNAMIC_LOAD_FACTOR_MAP = Map.of(
            Map.of(LoadType.CALM, DriveType.INTERNAL_COMBUSTION_HYDRAULICALLY_DRIVEN), 1.0,
            Map.of(LoadType.CALM, DriveType.ELECTRIC_MOTOR_OR_TURBINE), 1.0,
            Map.of(LoadType.CALM, DriveType.INTERNAL_COMBUSTION_WITH_MECHANICAL_DRIVE), 1.2,
            Map.of(LoadType.MODERATE, DriveType.INTERNAL_COMBUSTION_HYDRAULICALLY_DRIVEN), 1.2,
            Map.of(LoadType.MODERATE, DriveType.ELECTRIC_MOTOR_OR_TURBINE), 1.3,
            Map.of(LoadType.MODERATE, DriveType.INTERNAL_COMBUSTION_WITH_MECHANICAL_DRIVE), 1.4,
            Map.of(LoadType.HEAVY, DriveType.INTERNAL_COMBUSTION_HYDRAULICALLY_DRIVEN), 1.4,
            Map.of(LoadType.HEAVY, DriveType.ELECTRIC_MOTOR_OR_TURBINE), 1.5,
            Map.of(LoadType.HEAVY, DriveType.INTERNAL_COMBUSTION_WITH_MECHANICAL_DRIVE), 1.7
    );

    /**
     * Вернуть коэффициент динамической нагрузки Kд
     */
    public static Double getDynamicLoadFactor(LoadType loadType, DriveType driveType) {
        return DYNAMIC_LOAD_FACTOR_MAP.get(Map.of(loadType, driveType));
    }
}
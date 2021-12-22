package ru.stankin.bd.model;

/**
 * Тип привода
 */
public enum DriveType {

    /**
     * Внутреннее сгорание с гидравлическим приводом
     */
    INTERNAL_COMBUSTION_HYDRAULICALLY_DRIVEN,

    /**
     * Электромотор или турбина
     */
    ELECTRIC_MOTOR_OR_TURBINE,

    /**
     * Внутреннее сгорание с механическим приводом
     */
    INTERNAL_COMBUSTION_WITH_MECHANICAL_DRIVE
}
package ru.stankin.bd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calculation {

    /**
     * Число зубьев звездочки z1. Возможные значения (20, 25, 30)
     */
    private Long z1;

    /**
     * Мощность N
     */
    private Long n;

    /**
     * Проекция опорной поверхности шарнира
     */
    private Long sop;

    /**
     * Параметры для текущей передачи
     */
    private List<CurrentTransmission> currentTransmissions;

    private DriveType driveType;
    private LoadType loadType;
    private ChainRowRation chainRowRation;
}
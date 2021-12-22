package ru.stankin.bd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Параметры для текущей передачи
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentTransmission {

    /**
     * Время работы текущей передачи
     */
    private Double tv;

    /**
     * Частота вращения ведущей звездочки для текущей передачи
     */
    private Double n;

    /**
     * F для текущей передачи
     */
    private Double f;
}
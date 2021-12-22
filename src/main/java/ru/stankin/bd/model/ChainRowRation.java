package ru.stankin.bd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Коэффициент, учитывающий число рядов цепи
 */
@Getter
@AllArgsConstructor
public enum ChainRowRation {

    ONE("Однорядная", 1.0),
    TWO("Двухрядная", 1.7),
    THREE("Трехрядная", 2.5),
    FOUR("Четырехрядная", 3.0);

    private String name;
    private Double km;
}
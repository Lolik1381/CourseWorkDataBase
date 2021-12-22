package ru.stankin.bd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Цепь по ГОСТУ
 */
@Getter
@AllArgsConstructor
public enum GostChainName {

    GOST1("ПР-12,7-1870-2");

    private String name;
}
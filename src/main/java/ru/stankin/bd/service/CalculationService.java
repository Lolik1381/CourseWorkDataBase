package ru.stankin.bd.service;

import ru.stankin.bd.model.Calculation;
import ru.stankin.bd.model.ResponseCalculation;

import java.util.List;

public interface CalculationService {

    List<ResponseCalculation> calculation(Calculation calculation);
}
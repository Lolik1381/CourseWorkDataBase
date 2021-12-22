package ru.stankin.bd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.stankin.bd.model.Calculation;
import ru.stankin.bd.model.ResponseCalculation;
import ru.stankin.bd.service.CalculationService;

import java.util.List;

@Controller
@RequestMapping("/calculation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping
    public @ResponseBody List<ResponseCalculation> calculation(@RequestBody Calculation calculation) {
        return calculationService.calculation(calculation);
    }
}
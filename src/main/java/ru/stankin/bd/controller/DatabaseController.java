package ru.stankin.bd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.stankin.bd.model.Database;
import ru.stankin.bd.service.DatabaseService;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/database")
public class DatabaseController {

    private final DatabaseService databaseService;

    @GetMapping("/all")
    public @ResponseBody List<Database> findAll() {
        return databaseService.findAll();
    }
}
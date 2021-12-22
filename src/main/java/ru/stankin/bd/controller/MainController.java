package ru.stankin.bd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

    @GetMapping("/")
    public String main() {
        return "/main/index";
    }

    @GetMapping("/database")
    public String database() {
        return "/database/index";
    }
}
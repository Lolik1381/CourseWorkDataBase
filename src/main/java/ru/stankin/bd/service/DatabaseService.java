 package ru.stankin.bd.service;

import ru.stankin.bd.model.Database;

import java.util.List;

public interface DatabaseService {

    List<Database> findAll();
}
package com.example.controller;

import com.example.datasource.impl.db.DatabaseService;
import com.example.datasource.impl.random.RandomNumberService;
import com.example.datasource.impl.rest.RestDataService;
import com.example.model.addition.AdditionResult;
import com.example.model.addition.NumericInput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final DatabaseService dbDataSource;

    private final RestDataService restDataSource;

    private final RandomNumberService randomDataSource;

    public AppController(DatabaseService dbDataSource,
                         RestDataService restDataSource,
                         RandomNumberService randomDataSource) {
        this.dbDataSource = dbDataSource;
        this.restDataSource = restDataSource;
        this.randomDataSource = randomDataSource;
    }

    /**
     * Returns sum of numbers of the following sources:
     * 1 : database
     * 2 : random number (Java generator)
     * 3 : number via REST API
     */
    @GetMapping("/sum")
    public double getResult() {

        NumericInput[] input = new NumericInput[]{
                dbDataSource.getData(),
                randomDataSource.getData(),
                restDataSource.getData()
        };

        return new AdditionResult().from(input).getSum();
    }
}

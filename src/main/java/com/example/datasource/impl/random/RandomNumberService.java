package com.example.datasource.impl.random;

import com.example.datasource.NumericDataProvider;
import com.example.model.addition.NumericInput;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Provides data by generating random values
 */
@Service
@Log4j2
public class RandomNumberService implements NumericDataProvider {

    @Override
    public NumericInput getData() {
        double randomValue = ThreadLocalRandom.current().nextDouble(0.01d);

        NumericInput value = new NumericInput(randomValue);
        log.info("Getting random value: {}", value.getValue());
        return value;
    }
}

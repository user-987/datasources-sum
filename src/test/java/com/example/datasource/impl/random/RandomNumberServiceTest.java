package com.example.datasource.impl.random;

import com.example.model.addition.NumericInput;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomNumberServiceTest {

    private final RandomNumberService randomNumberService = new RandomNumberService();

    @Test
    public void shouldGetRandomNumber() {
        // when
        NumericInput randomData = randomNumberService.getData();

        // then
        assertTrue(randomData.getValue() >= 0.0d);
    }
}

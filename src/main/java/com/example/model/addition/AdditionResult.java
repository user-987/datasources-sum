package com.example.model.addition;

import com.example.model.Result;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

/**
 * Represents numeric addition result
 */
@NoArgsConstructor
@Getter
@Log4j2
public class AdditionResult extends Result<NumericInput> {

    private double sum;

    @Override
    public AdditionResult from(NumericInput[] input) {
        this.sum = Arrays.stream(input)
                .map(NumericInput::getValue)
                .reduce(0d, (a, b) -> a + b);

        log.info("Result sum: {}", this.sum);
        return this;
    }
}

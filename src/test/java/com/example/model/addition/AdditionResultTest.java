package com.example.model.addition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdditionResultTest {

    @Test
    public void shouldAddTwoNumbers() {
        // given
        NumericInput first = new NumericInput(1d);
        NumericInput second = new NumericInput(2d);
        NumericInput[] input = new NumericInput[]{first, second};

        // when
        AdditionResult result = new AdditionResult().from(input);

        // then
        assertEquals(result.getSum(), 3d, 0.001);
    }

    @Test
    public void shouldAddOnlyOneNumberToDefaultZero() {
        // given
        NumericInput first = new NumericInput(1.5d);
        NumericInput[] input = new NumericInput[]{first};

        // when
        AdditionResult result = new AdditionResult().from(input);

        // then
        assertEquals(result.getSum(), 1.5d, 0.001);
    }

    @Test
    public void shouldAddEmptyArguments() {
        // given
        NumericInput[] input = new NumericInput[]{};

        // when
        AdditionResult result = new AdditionResult().from(input);

        // then
        assertEquals(result.getSum(), 0d, 0.001);
    }
}

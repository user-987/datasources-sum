package com.example.model.addition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class NumericInputTest {

    @Test
    public void shouldCreateNumericInput() {
        // when
        NumericInput input = new NumericInput(12d);

        // then
        assertEquals(input.getValue(), 12d, 0.001);
    }
}

package com.example.model.addition;

import com.example.model.Input;

/**
 * Represents numeric operation input
 */
public class NumericInput extends Input {

    private double value;

    public NumericInput() {
    }

    public NumericInput(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

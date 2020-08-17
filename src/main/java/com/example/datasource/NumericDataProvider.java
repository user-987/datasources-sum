package com.example.datasource;

import com.example.model.addition.NumericInput;

/**
 * Provides input data
 */
public interface NumericDataProvider extends DataProvider {

    @Override
    NumericInput getData();
}

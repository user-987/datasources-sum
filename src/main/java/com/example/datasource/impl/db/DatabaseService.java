package com.example.datasource.impl.db;

import com.example.datasource.NumericDataProvider;
import com.example.datasource.impl.db.mapper.InputMapper;
import com.example.datasource.impl.db.model.InputValue;
import com.example.model.addition.NumericInput;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

/**
 * Provides data of database
 */
@Service
@Log4j2
public class DatabaseService implements NumericDataProvider {

    private final String SECRET_VALUE = "secret-value";

    private final ValueRepository repository;

    private final InputMapper mapper = Mappers.getMapper(InputMapper.class);

    public DatabaseService(ValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public NumericInput getData() {
        InputValue inputValueFromDb = repository.findById(SECRET_VALUE)
                .orElse(new InputValue(0d));

        NumericInput value = mapper.map(inputValueFromDb);
        log.info("Getting constant (or default zero) value from database: {}", value.getValue());
        return value;
    }
}

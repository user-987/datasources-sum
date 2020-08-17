package com.example.datasource.impl.db;


import com.example.datasource.impl.db.model.InputValue;
import com.example.model.addition.NumericInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseServiceTest {

    @InjectMocks
    private DatabaseService databaseService;

    @Mock
    private ValueRepository repository;

    @Test
    public void shouldGetNumberFromDb() {
        // given
        Optional<InputValue> dbResult = Optional.of(new InputValue(0.123d));
        given(repository.findById(anyString())).willReturn(dbResult);

        // when
        NumericInput dataFromDb = databaseService.getData();

        // then
        assertEquals(dataFromDb.getValue(), 0.123d, 0.001);
    }

    @Test
    public void shouldNotGetNumberFromDbAndReturnDefaultZero() {
        // given
        Optional<InputValue> dbResult = Optional.empty();
        given(repository.findById(anyString())).willReturn(dbResult);

        // when
        NumericInput dataFromDb = databaseService.getData();

        // then
        assertEquals(dataFromDb.getValue(), 0.0d, 0.001);
    }
}

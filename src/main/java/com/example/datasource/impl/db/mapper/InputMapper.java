package com.example.datasource.impl.db.mapper;

import com.example.datasource.impl.db.model.InputValue;
import com.example.model.addition.NumericInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InputMapper {
    @Mapping(target = "value", source = "inputValue.value")
    NumericInput map(InputValue inputValue);
}
package com.example.datasource.impl.db.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(
        name = "INPUT",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"value"})}
)
public class InputValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String key;

    @NotBlank(message = "Value is mandatory")
    private Double value;

    public InputValue() {
    }

    public InputValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

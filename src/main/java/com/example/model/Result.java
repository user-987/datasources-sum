package com.example.model;

/**
 * Represents operation result
 */
public abstract class Result<I extends Input> {

    protected abstract Result from(I[] input);
}

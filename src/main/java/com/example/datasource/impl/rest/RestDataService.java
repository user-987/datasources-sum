package com.example.datasource.impl.rest;

import com.example.datasource.NumericDataProvider;
import com.example.model.addition.NumericInput;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Provides data via REST API
 */
@Service
@Log4j2
public class RestDataService implements NumericDataProvider {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public NumericInput getData() {
        Try<ResponseEntity<String>> responseEntity = Try.of(() -> restTemplate
                .getForEntity("https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new", String.class));

        return get(responseEntity);
    }

    private NumericInput get(Try<ResponseEntity<String>> responseEntity) {

        Double d = Double.valueOf(responseEntity
                .getOrElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("0"))
                .getBody());

        NumericInput value = new NumericInput(d);
        if(responseEntity.isSuccess()) {
            log.info("Getting value from REST API: {}", value.getValue());
        } else {
            log.info("Getting value from REST API failed, default value: {}", value.getValue());
        }
        return value;
    }
}

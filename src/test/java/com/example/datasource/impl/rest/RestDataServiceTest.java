package com.example.datasource.impl.rest;

import com.example.model.addition.NumericInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RestDataServiceTest {

    @InjectMocks
    private RestDataService restDataService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ResponseEntity<String> responseEntity;

    @Test
    public void shouldGetNumberFromDb() {
        // given
        given(restTemplate.getForEntity("https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new", String.class))
                .willReturn(responseEntity);
        given(responseEntity.getBody()).willReturn("13");

        // when
        NumericInput dataFromRestApi = restDataService.getData();

        // then
        assertEquals(dataFromRestApi.getValue(), 13d, 0.001);
    }

    @Test
    public void shouldNotGetNumberFromDbAndReturnDefaultZero() {
        // given
        given(restTemplate.getForEntity("https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new", String.class))
                .willThrow(RuntimeException.class);

        // when
        NumericInput dataFromRestApi = restDataService.getData();

        // then
        assertEquals(dataFromRestApi.getValue(), 0d, 0.001);
    }
}

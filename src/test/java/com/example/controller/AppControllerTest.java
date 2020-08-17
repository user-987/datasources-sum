package com.example.controller;

import com.example.datasource.impl.db.DatabaseService;
import com.example.datasource.impl.random.RandomNumberService;
import com.example.datasource.impl.rest.RestDataService;
import com.example.model.addition.NumericInput;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DatabaseService dbDataSource;

    @MockBean
    private RestDataService restDataSource;

    @MockBean
    private RandomNumberService randomDataSource;

    private NumericInput numericInput;

    @Before
    public void setUp() {
        numericInput = new NumericInput(3d);
    }

    @Test
    public void shouldGetResultFromDifferentDataSources() throws Exception {

        given(dbDataSource.getData()).willReturn(numericInput);
        given(restDataSource.getData()).willReturn(numericInput);
        given(randomDataSource.getData()).willReturn(numericInput);

        mockMvc.perform(get("/sum")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("9.0"));
    }
}

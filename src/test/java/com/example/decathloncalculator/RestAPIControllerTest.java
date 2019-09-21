package com.example.decathloncalculator;

import com.example.decathloncalculator.model.Points;
import com.example.decathloncalculator.validate.ValidationErrors;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWrongRawPerformanceLetter() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/calculatePointsAPI")
                .content("{\"event\":1, \"rawPerformance\": \"a\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseStatus);

        String content = mvcResult.getResponse().getContentAsString();
        ValidationErrors validateError = new ObjectMapper().readValue(content, ValidationErrors.class);
        assertEquals(1, validateError.getErrors().size());
    }

    @Test
    public void testWrongEventLetter() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/calculatePointsAPI")
                .content("{\"event\":\"a\", \"rawPerformance\": 1}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseStatus);

        String content = mvcResult.getResponse().getContentAsString();
        ValidationErrors validateError = new ObjectMapper().readValue(content, ValidationErrors.class);
        assertEquals(2, validateError.getErrors().size());
    }

    @Test
    public void testRightRequest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/calculatePointsAPI")
                .content("{\"event\": 1, \"rawPerformance\": 1}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), responseStatus);

        String content = mvcResult.getResponse().getContentAsString();
        Points points = new ObjectMapper().readValue(content, Points.class);
        assertEquals(4290, points.getPoints());
    }

    @Test
    public void testWrongEventNonExistent() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/calculatePointsAPI")
                .content("{\"event\": 11, \"rawPerformance\": 1}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseStatus);

        String content = mvcResult.getResponse().getContentAsString();
        ValidationErrors validateError = new ObjectMapper().readValue(content, ValidationErrors.class);
        assertEquals(1, validateError.getErrors().size());
    }

    @Test
    public void testWrongRawPerformanceNegative() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/calculatePointsAPI")
                .content("{\"event\": 10, \"rawPerformance\": -1}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        int responseStatus = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseStatus);

        String content = mvcResult.getResponse().getContentAsString();
        ValidationErrors validateError = new ObjectMapper().readValue(content, ValidationErrors.class);
        assertEquals(1, validateError.getErrors().size());
    }

}
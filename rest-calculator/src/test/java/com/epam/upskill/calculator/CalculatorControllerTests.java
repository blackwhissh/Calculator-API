package com.epam.upskill.calculator;

import static org.junit.Assert.assertEquals;

import com.epam.upskill.calculator.controllers.CalculatorController;
import com.epam.upskill.calculator.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;


    //thi method test the add operation of 1 + 1
    @Test
    public void addPositiveOperatorTest() throws Exception {

        String jsonBody = "{\"operand1\": 1, \"operand2\": 1}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":2}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void addNegativeOperatorTest() throws Exception {

        String jsonBody = "{\"operand1\": -1, \"operand2\": -1}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":-2}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void addNullValueOperatorTest() throws Exception {

        String jsonBody = "{\"operand1\": null, \"operand2\": null}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: One of the operands is not valid\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());

    }
    //
    @Test
    public void subtractOperationTest() throws Exception {

        String jsonBody = "{\"operand1\": -1, \"operand2\": 10}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/subtract").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":-11}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    //
    @Test
    public void divideZeroOperatorTest() throws Exception {
        String jsonBody = "{\"operand1\": -1, \"operand2\": 0}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: Can't divide by zero\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void negativeDivisionOperatorTest() throws Exception {
        String jsonBody = "{\"operand1\": 5, \"operand2\": -1}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":-5.0000000000}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void negativeMultiplicationOperatorTest() throws Exception {
        String jsonBody = "{\"operand1\": -4, \"operand2\": -1}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/multiply").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":4}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void multiplyByZeroTest1() throws Exception {
        String jsonBody = "{\"operand1\": -4, \"operand2\": 0}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/multiply").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: Can't multiply by zero, all results will be 0\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void multiplyByZeroTest2() throws Exception {
        String jsonBody = "{\"operand1\": 0, \"operand2\": 12}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/multiply").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: Can't multiply by zero, all results will be 0\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void factorialTest() throws Exception {
        String jsonBody = "{\"operand1\": 5, \"operand2\": null}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/factorial").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":120}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void factorialNullValueTest() throws Exception {
        String jsonBody = "{\"operand1\": 0, \"operand2\": null}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/factorial").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":1}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void factorialMainOperandNullTest() throws Exception {
        String jsonBody = "{\"operand1\": null, \"operand2\": 5}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/factorial").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: Main operand should not be null\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void factorialSecondOperandNonNullTest() throws Exception {
        String jsonBody = "{\"operand1\": 5.323, \"operand2\": 42}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/factorial").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: Second operand should be null\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }

    @Test
    public void factorialMainOperandNonIntegerTest() throws Exception {
        String jsonBody = "{\"operand1\": 5.323, \"operand2\": null}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/factorial").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        String expectedResult = "{\"message\":\"Error: Operand must be a positive integer\",\"error\":true,\"result\":null}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(expectedResult, response.getContentAsString());
    }


}

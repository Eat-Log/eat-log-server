package com.kuba.eatlog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuba.eatlog.controller.meal.MealController;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.user.UserEntity;
import com.kuba.eatlog.rest.request.SaveMealRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.kuba.eatlog.controller.ApiConstraints.*;
import static com.kuba.eatlog.controller.meal.MealController.SAVE_MEAL;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MealControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void whenSaveMealRequest_thenCorrectResponse() throws Exception {
        //given
        String url = "http://localhost:8080" + MEAL + SAVE_MEAL;
        UserEntity user = new UserEntity();
        user.setId(2L);
        MealDetails details = new MealDetails();
        details.setDetails("3 eggs");

        SaveMealRequest request = SaveMealRequest.builder()
                .title("Breakfast")
                .time(LocalTime.parse("09:00"))
                .date(LocalDate.parse("2023-04-19"))
                .details(details)
                .user(user)
                .build();

        //when
        var result = mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(toJsonString(request)));

        //then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.meal.title", is("Breakfast")))
                .andExpect(jsonPath("$.meal.time", is("09:00")))
                .andExpect(jsonPath("$.meal.date", is("2023-04-19")))
                .andExpect(jsonPath("$.meal.details", is("details")));

    }

    private String toJsonString(SaveMealRequest request) throws JsonProcessingException {
        return objectMapper.writeValueAsString(request);
    }
}

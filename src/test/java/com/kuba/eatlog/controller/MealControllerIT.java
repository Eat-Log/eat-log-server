package com.kuba.eatlog.controller;

import com.kuba.eatlog.BaseIT;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.rest.request.meal.SaveMealRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.kuba.eatlog.controller.ApiConstraints.*;
import static com.kuba.eatlog.controller.meal.MealController.SAVE_MEAL;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MealControllerIT extends BaseIT {


    @Test
    public void whenSaveMealRequest_thenCorrectResponse() throws Exception {
        //given
        String url = BASE_URL + MEAL + SAVE_MEAL;

        int detailsId = 1;

        String mealDetails = "3 eggs";

        MealDetails details = new MealDetails();
        details.setDetails("3 eggs");

        MealDetails newDetails = new MealDetails();
        newDetails.setDetails(details.getDetails());

        SaveMealRequest request = SaveMealRequest.builder()
                .title("Breakfast")
                .time(LocalTime.parse("09:00"))
                .date(LocalDate.parse("2023-04-19"))
                .details(newDetails)
                .build();

        //when
        var result = mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(toJsonString(request)));

        //then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.meal.title", is("Breakfast")))
                .andExpect(jsonPath("$.meal.time", is("09:00:00")))
                .andExpect(jsonPath("$.meal.date", is("2023-04-19")))
                .andExpect(jsonPath("$.meal.details.id", is(detailsId)))
                .andExpect(jsonPath("$.meal.details.details", is(details.getDetails())));

    }

    @Test
    void whenSavePersonRequest_thenBadRequestResponse() throws Exception{
        //given
        String url = BASE_URL + MEAL + SAVE_MEAL;
        HttpStatus expectedStatus = HttpStatus.BAD_REQUEST;
        Integer expectedErrors = 3;

        var request = new SaveMealRequest();

        //when
        var result = mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(request)));

        //then
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code", is(expectedStatus.value())))
                .andExpect(jsonPath("$.error", is(expectedStatus.getReasonPhrase())))
                .andExpect(jsonPath("$.message.size()", is(expectedErrors)));

    }


}

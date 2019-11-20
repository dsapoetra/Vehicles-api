package com.udacity.pricing.web;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class pricingServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPrice() throws Exception {
        mockMvc.perform(get("/services/price?vehicleId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.currency").value("USD"))
                .andExpect(jsonPath("$.vehicleId").value(1));
    }
}

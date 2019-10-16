package com.cognizant.shipmentservice.controller;

import com.cognizant.shipmentservice.model.Shipment;
import com.cognizant.shipmentservice.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShipmentController.class)
public class ShipmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    private static final Shipment SHIPMENT_TO_SAVE = new Shipment("Abe", 200100);
    private static final Shipment SAVED_SHIPMENT = new Shipment(1, "Abe", 200100);

    private static final int TRACKING_NUMBER = 200100;

    @Before
    public void setUp() {

        when(serviceLayer.addShipment(SHIPMENT_TO_SAVE)).thenReturn(SAVED_SHIPMENT);
        when(serviceLayer.retrieveShipment(TRACKING_NUMBER)).thenReturn(SAVED_SHIPMENT);
    }

    @Test
    public void retrieveShipment() throws Exception {

        String expectedJsonOutput = mapper.writeValueAsString(SAVED_SHIPMENT);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/clientfe/shipment/{trackingnumber}", TRACKING_NUMBER)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(expectedJsonOutput));

    }

    @Test
    public void addShipment() throws Exception {
        String expectedJsonOutput = mapper.writeValueAsString(SAVED_SHIPMENT);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/clientfe/addshipment")
                .content(mapper.writeValueAsString(SHIPMENT_TO_SAVE))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedJsonOutput));

    }
}
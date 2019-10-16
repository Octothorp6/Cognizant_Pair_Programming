package com.cognizant.uspsshippingservice.controller;

import com.cognizant.uspsshippingservice.dao.ShipmentRepository;
import com.cognizant.uspsshippingservice.dto.Shipment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UspsShippingServiceController.class)
public class UspsShippingServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShipmentRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createShipment() {

    }

    @Test
    public void getShipmentByTrackingNumber() throws Exception {
        Shipment shipment = new Shipment();
        shipment.setTrackingNumber(200100);
        shipment.setName("Brian Lora");
        shipment.setId(5);


        String outputJson = mapper.writeValueAsString(shipment);
        when(repository.findByTrackingNumber(200100)).thenReturn(shipment);

        this.mockMvc.perform(get("/shipment/200100")).andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .json(outputJson));
    }
}
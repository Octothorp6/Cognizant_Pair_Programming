package com.cognizant.shipmentservice.controller;

import com.cognizant.shipmentservice.model.Shipment;
import com.cognizant.shipmentservice.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ShipmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    private static final Shipment SHIPMENT_TO_SAVE = new Shipment("Abe", 200100);
    private static final Shipment SAVED_SHIPMENT = new Shipment(1, "Abe", 200100);

    @Before
    public void setUp() {

        when(serviceLayer.addShipment(SHIPMENT_TO_SAVE)).thenReturn(SAVED_SHIPMENT);
    }

    @Test
    public void retrieveShipment() {
    }

    @Test
    public void addShipment() {
    }
}
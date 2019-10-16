package com.cognizant.uspsshippingservice.dao;

import com.cognizant.uspsshippingservice.dto.Shipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentRepositoryTest {

    @Autowired
    ShipmentRepository shipmentRepository;

    private Shipment shipment;
    private Shipment shipment1;
    private Shipment shipment2;

    @Before
    public void setUp() throws Exception {
        shipmentRepository.deleteAll();

        shipment = new Shipment();
        shipment.setTrackingNumber(12345);
        shipment.setName("Brian Lora");

        shipment1 = new Shipment();
        shipment1.setTrackingNumber(12345);
        shipment1.setName("Abraham Leal");

        shipment2 = new Shipment();
        shipment2.setTrackingNumber(12345);
        shipment2.setName("Sal Hobbi");
    }

    @Test
    public void shouldSaveAndRetrieveShipment() {
        shipment = shipmentRepository.save(shipment);
        Shipment shipment3 = shipmentRepository.findById(shipment.getId()).get();
        assertEquals(shipment3, shipment);
    }

    @Test
    public void shouldUpdateShipment() {
        shipment1 = shipmentRepository.save(shipment1);
        shipment1.setName("Voldemort");
        shipmentRepository.save(shipment1);

        Shipment shipment3 = shipmentRepository.findById(shipment1.getId()).get();
        assertEquals(shipment3, shipment1);
    }

    @Test
    public void shouldfindByTrackingNumber() {
        shipment2 = shipmentRepository.save(shipment2);
        Shipment shipment3 = shipmentRepository.findByTrackingNumber(shipment2.getTrackingNumber());
        assertEquals(shipment3, shipment2);
    }

    @Test
    public void shouldFindAllShipments() {
        shipmentRepository.save(shipment);
        shipmentRepository.save(shipment1);
        shipmentRepository.save(shipment2);

        List<Shipment> shipments = shipmentRepository.findAll();
        assertEquals(3, shipments.size());
    }




}
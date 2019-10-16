package com.cognizant.shipmentservice.controller;

import com.cognizant.shipmentservice.model.Shipment;
import com.cognizant.shipmentservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping(value = "/clientfe/shipment/{trackingnumber}")
    @ResponseStatus(HttpStatus.OK)
    public Shipment retrieveShipment(@PathVariable int trackingnumber) {
        Shipment shipment = serviceLayer.retrieveShipment(trackingnumber);
        return shipment;
    }

    @PostMapping(value = "/clientfe/addshipment")
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment addShipment(@RequestBody Shipment shipment) {
        Shipment returnShipment = serviceLayer.addShipment(shipment);
        return returnShipment;
    }
}

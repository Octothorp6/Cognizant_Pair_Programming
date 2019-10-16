package com.cognizant.uspsshippingservice.controller;

import com.cognizant.uspsshippingservice.dao.ShipmentRepository;
import com.cognizant.uspsshippingservice.dto.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shipment")
public class UspsShippingServiceController {
    @Autowired
    ShipmentRepository shipmentRepository;

    @PostMapping(value = "/addshipment")
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment createShipment(@RequestBody @Valid Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @GetMapping(value = "/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Shipment getShipmentByTrackingNumber(@PathVariable int trackingNumber) {
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber);
        if (shipment == null) {
            throw new IllegalArgumentException("Not found.");
        }
        return shipment;
    }
}

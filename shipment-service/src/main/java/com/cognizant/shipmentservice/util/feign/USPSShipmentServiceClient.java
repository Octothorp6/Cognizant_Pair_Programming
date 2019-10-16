package com.cognizant.shipmentservice.util.feign;

import com.cognizant.shipmentservice.model.Shipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "usps-shipment-service")
public interface USPSShipmentServiceClient {

    @PostMapping(value = "/shipment/addshipment")
    Shipment createShipment(@RequestBody @Valid Shipment shipment);

    @GetMapping(value = "/shipment/{trackingNumber}")
    Shipment getShipmentByTrackingNumber(@PathVariable int trackingNumber);
}

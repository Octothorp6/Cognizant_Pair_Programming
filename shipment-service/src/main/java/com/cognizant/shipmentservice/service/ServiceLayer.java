package com.cognizant.shipmentservice.service;

import com.cognizant.shipmentservice.model.Shipment;
import com.cognizant.shipmentservice.util.feign.USPSShipmentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ServiceLayer {

    @Autowired
    private USPSShipmentServiceClient uspsShipmentServiceClient;

    @Autowired
    ServiceLayer(USPSShipmentServiceClient uspsShipmentServiceClient) {
        this.uspsShipmentServiceClient = uspsShipmentServiceClient;
    }

    /**
     * Retrieves shipment from database via feign client
     * when passed a valid tracking number
     * @param trackingnumber
     * @return
     */
    public Shipment retrieveShipment(@PathVariable int trackingnumber) {
        Shipment shipment = new Shipment();
        Shipment returnShipment = uspsShipmentServiceClient.getShipmentByTrackingNumber(trackingnumber);
        return returnShipment;
    }

    /**
     * Adds a shipment entry to the database when passed a valid
     * shipment object
     * @param shipment
     * @return
     */
    public Shipment addShipment(@RequestBody Shipment shipment) {
        Shipment returnShipment = uspsShipmentServiceClient.createShipment(shipment);
        return returnShipment;
    }


}

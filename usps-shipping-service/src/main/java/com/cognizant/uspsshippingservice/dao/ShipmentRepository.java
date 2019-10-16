package com.cognizant.uspsshippingservice.dao;

import com.cognizant.uspsshippingservice.dto.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    Shipment findByTrackingNumber(int trackingNumber);
}

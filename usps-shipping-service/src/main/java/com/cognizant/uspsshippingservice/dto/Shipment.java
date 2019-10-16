package com.cognizant.uspsshippingservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "Must enter a value for Tracking Number.")
    private int trackingNumber;
    @NotNull(message = "Must enter a value for name.")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return id == shipment.id &&
                trackingNumber == shipment.trackingNumber &&
                Objects.equals(name, shipment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackingNumber, name);
    }
}

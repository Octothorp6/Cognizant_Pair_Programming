package com.cognizant.uspsshippingservice.dto;

import javax.persistence.*;
import java.util.Objects;

/*Task:
 *
 */
@Entity
@Table
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private int trackingNumber;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return trackingNumber == shipment.trackingNumber &&
                Objects.equals(id, shipment.id) &&
                Objects.equals(name, shipment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackingNumber, name);
    }
}

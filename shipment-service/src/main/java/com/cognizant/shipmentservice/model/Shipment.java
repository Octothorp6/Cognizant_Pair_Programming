package com.cognizant.shipmentservice.model;

import java.util.Objects;

public class Shipment {

    private int id;
    private String name;
    private int trackingNumber;

    public Shipment() {
    }

    public Shipment(String name, int trackingNumber) {
        this.name = name;
        this.trackingNumber = trackingNumber;
    }

    public Shipment(int id, String name, int trackingNumber) {
        this.id = id;
        this.name = name;
        this.trackingNumber = trackingNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return getId() == shipment.getId() &&
                getTrackingNumber() == shipment.getTrackingNumber() &&
                getName().equals(shipment.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTrackingNumber());
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trackingNumber=" + trackingNumber +
                '}';
    }
}

package com.company.rll.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class BusEntity {
  @Id
  @Column(name = "bus_id")
  public int bus_id;

  @Column(name = "location")
  public String location;

  @Column(name = "departure")
  public String departure;

  @Column(name = "ETA")
  public String eta;

  @Column(name = "price")
  public long price;

  @Column(name = "availability")
  public String availability;

  public BusEntity(
    int bus_id,
    String location,
    String eta,
    long price,
    String availability
  ) {
    super();
    this.bus_id = bus_id;
    this.location = location;
    this.eta = eta;
    this.price = price;
    this.availability = availability;
  }

  public BusEntity() {}

  public int getBus_id() {
    return bus_id;
  }

  public void setBus_id(int bus_id) {
    this.bus_id = bus_id;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEta() {
    return eta;
  }

  public void setEta(String eta) {
    this.eta = eta;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public String getAvailability() {
    return availability;
  }

  public void setAvailability(String availability) {
    this.availability = availability;
  }
}

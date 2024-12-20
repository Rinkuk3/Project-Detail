package com.td.mbna.msec.midtier.mbnaad.request.response;

import com.td.mbna.msec.midtier.mbnaad.request.response.error.Status;

import java.io.Serializable;
import java.lang.String;

public class DeliveryAddress implements Serializable {

    private String city;

    private String postalCode;

    private String countryCd;

    private String addressLine1;

    private String addressLine2;

    private String territory;

    private Status status;

    public String getCity() {
      return this.city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getPostalCode() {
      return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
    }

    public String getCountryCd() {
      return this.countryCd;
    }

    public void setCountryCd(String countryCd) {
      this.countryCd = countryCd;
    }

    public String getAddressLine1() {
      return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
      return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
    }

    public String getTerritory() {
      return this.territory;
    }

    public void setTerritory(String territory) {
      this.territory = territory;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

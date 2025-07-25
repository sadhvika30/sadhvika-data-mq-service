package com.sadhvika.activemqdemo.Dto;

public class CustomMessage {

    private String customerName;
    private String cityRegion;
    private String provinceArea;
    private String countryRegion;

    // Default constructor
    public CustomMessage() {}

    // Parameterized constructor
    public CustomMessage(String customerName, String cityRegion, String provinceArea, String countryRegion) {
        this.customerName = customerName;
        this.cityRegion = cityRegion;
        this.provinceArea = provinceArea;
        this.countryRegion = countryRegion;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCityRegion() {
        return cityRegion;
    }

    public String getProvinceArea() {
        return provinceArea;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public void setProvinceArea(String provinceArea) {
        this.provinceArea = provinceArea;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }
}

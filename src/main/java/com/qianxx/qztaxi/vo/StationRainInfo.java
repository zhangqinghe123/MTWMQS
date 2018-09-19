package com.qianxx.qztaxi.vo;

public class StationRainInfo {
    private String stcd;
    private String name;
    private double latitude;
    private double longitude;
    private double rainfall;
    private String adminTownName;

    public String getAdminTownName() {
        return adminTownName;
    }

    public void setAdminTownName(String adminTownName) {
        this.adminTownName = adminTownName;
    }

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }
}

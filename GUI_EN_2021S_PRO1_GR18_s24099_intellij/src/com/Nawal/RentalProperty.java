package com.Nawal;

public class RentalProperty  {
    String PropNo;
    String PropType;
    double Volume;
    double saleValue;
    double rentAmt;
    char available;

    public RentalProperty(String propNo, String propType, double Volume, double saleValue, double rentAmt) {
        PropNo = propNo;
        PropType = propType;
        this.Volume = Volume;
        this.saleValue = saleValue;
        this.rentAmt = rentAmt;
        this.available='Y';
    }
    public RentalProperty(RentalProperty p) {
        PropNo = p.PropNo;
        PropType = p.PropType;
        this.Volume = p.Volume;
        this.saleValue = p.saleValue;
        this.rentAmt = p.rentAmt;
        this.available=p.available;
    }
    public String getPropNo() {
        return PropNo;
    }
    public String getPropType() {
        return PropType;
    }
    public double getVolume() {
        return Volume;
    }
    public double getSaleValue() {
        return saleValue;
    }
    public double getRentAmt() {
        return rentAmt;
    }
    public char getAvailable() {
        return available;
    }
    public void setPropNo(String propNo) {
        PropNo = propNo;
    }
    public void setPropType(String propType) {
        PropType = propType;
    }
    public void setVolume(double Volume) {
        this.Volume = Volume;
    }
    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }
    public void setRentAmt(double rentAmt) {
        this.rentAmt = rentAmt;
    }
    public void setAvailable(char available) {
        this.available = available;
    }
    @Override
    public String toString() {
        return "RentalProperty [PropNo=" + PropNo + ", PropType=" + PropType + ", Volume=" + Volume + ", saleValue=" + saleValue + ", rentAmt="
                + rentAmt + ", available=" + available + "]";
    }
}

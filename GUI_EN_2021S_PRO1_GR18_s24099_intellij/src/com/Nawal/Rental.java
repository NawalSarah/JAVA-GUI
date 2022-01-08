package com.Nawal;

public class Rental {
    String rentalstartDate;
    RentalProperty rentalProperty;
    double VolP;
    Tenant tenant;
    String term;

    public Rental(RentalProperty rentalProperty, Tenant tenant, double VolP,String date, String rentalDate, String term) {
        this.rentalstartDate = rentalDate;
        this.rentalProperty = rentalProperty;
        this.VolP = VolP;
        this.rentalProperty.setAvailable('N');
        this.tenant = tenant;
        this.term = term;
    }
    public Rental(Rental r) {
        this.rentalstartDate = r.rentalstartDate;
        this.rentalProperty = r.rentalProperty;
        this.VolP = r.VolP;
        this.rentalProperty.setAvailable('N');
        this.tenant = r.tenant;
        this.term = r.term;
    }
    public String getRentalDate() {
        return rentalstartDate;
    }
    public RentalProperty getRentalProperty() {
        return rentalProperty;
    }
    public double getVolP() {
        return VolP;
    }
    public Tenant getTenant() {
        return tenant;
    }
    public String getTerm() {
        return term;
    }
    public void setRentalDate(String rentalDate) {
        this.rentalstartDate = rentalDate;
    }
    public void setRentalProperty(RentalProperty rentalProperty) {
        this.rentalProperty = rentalProperty;
    }
    public void setVoip(double VolP) {
        this.VolP = VolP;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    @Override
    public String toString() {
        return "RentalDate=" + rentalstartDate + ", rentalProperty=" + rentalProperty.toString() + ", tVol of parking=" + VolP + ", tenant=" + tenant.toString()
                + ", term=" + term + "]";
    }

}

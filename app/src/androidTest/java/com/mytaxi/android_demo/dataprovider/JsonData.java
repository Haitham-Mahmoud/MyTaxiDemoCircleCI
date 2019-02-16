package com.mytaxi.android_demo.dataprovider;

public class JsonData {

    private String invalidUsername
            , invalidPassword
            , validUsername
            , validPassword
            , searchDriver
            , fullnameDriver
            , locationDriver
            , dateDriver
            , telephoneDriver;

    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getSearchDriver() {
        return searchDriver;
    }

    public String getFullnameDriver() {
        return fullnameDriver;
    }

    public String getLocationDriver() {
        return locationDriver;
    }

    public String getDateDriver() {
        return dateDriver;
    }

    public String getTelephoneDriver() {
        return telephoneDriver;
    }

    public void setValidUsername(String validUsername) {
        this.validUsername = validUsername;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    public void setInvalidUsername(String invalidUsername) {
        this.invalidUsername = invalidUsername;
    }

    public void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }

    public void setSearchDriver(String searchDriver) {
        this.searchDriver = searchDriver;
    }

    public void setFullnameDriver(String fullnameDriver) {
        this.fullnameDriver = fullnameDriver;
    }

    public void setLocationDriver(String locationDriver) {
        this.locationDriver = locationDriver;
    }

    public void setDateDriver(String dateDriver) {
        this.dateDriver = dateDriver;
    }

    public void setTelephoneDriver(String telephoneDriver) {
        this.telephoneDriver = telephoneDriver;
    }
}

package com.naveen.librarybook.model;

public class Main
{
    private double temp;

    private double feels_like;

    private double temp_min;

    private double temp_max;

    private int pressure;

    private int humidity;

    public void setTemp(double temp){
        this.temp = temp;
    }
    public double getTemp(){
        return this.temp;
    }
    public void setFeels_like(double feels_like){
        this.feels_like = feels_like;
    }
    public double getFeels_like(){
        return this.feels_like;
    }
    public void setTemp_min(double temp_min){
        this.temp_min = temp_min;
    }
    public double getTemp_min(){
        return this.temp_min;
    }
    public void setTemp_max(double temp_max){
        this.temp_max = temp_max;
    }
    public double getTemp_max(){
        return this.temp_max;
    }
    public void setPressure(int pressure){
        this.pressure = pressure;
    }
    public int getPressure(){
        return this.pressure;
    }
    public void setHumidity(int humidity){
        this.humidity = humidity;
    }
    public int getHumidity(){
        return this.humidity;
    }
}


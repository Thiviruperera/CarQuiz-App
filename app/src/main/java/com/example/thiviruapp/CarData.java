package com.example.thiviruapp;

class CarData {

    private int imageId;
    private String carMake;

    CarData(int imageId, String carMake) {
        this.imageId = imageId;
        this.carMake = carMake;
    }

    public int getImageId() {
        return imageId;
    }


    public String getCarMake() {
        return carMake;
    }


}

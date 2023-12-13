package com.productiveplant.Spring.Initializer.Project.model;

public class Watered {

    private boolean isWatered;

    public Watered(boolean isWatered) {
        this.isWatered = isWatered;
    }

    public boolean isWatered() {
        return isWatered;
    }

    public void setWatered(boolean watered) {
        isWatered = watered;
    }

}

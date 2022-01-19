package uz.epam.parking.model;

import lombok.Data;

@Data
public class ParkModel {

    private static ParkModel partInstance = null;

    // this is limit of parking which can be max number of cars at the same time
    private final Integer limit = 10;

    private Integer currentCarsCount;

    private ParkModel(){
        this.currentCarsCount = 0;
    }

    public static ParkModel getPark(){
        if (partInstance == null) {
            partInstance = new ParkModel();
        }

        return partInstance;
    }

}

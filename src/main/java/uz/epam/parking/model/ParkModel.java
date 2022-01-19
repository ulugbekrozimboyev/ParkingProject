package uz.epam.parking.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkModel {

    private static ParkModel partInstance = null;

    private final Integer levels;
    // this is limit of parking which can be max number of cars at the same time
    private final Integer limitPerLevel;

    private List<Spot> availableSpots = new ArrayList<>();

    private ParkModel(Integer levels, Integer limitPerLevel){
        this.levels = levels;
        this.limitPerLevel = limitPerLevel;
        for (int level = 1; level <= levels; level++){
            for (int spotNumber = 1; spotNumber <= limitPerLevel; spotNumber++){
                availableSpots.add(new Spot(level, spotNumber, true));
            }
        }
    }

    public static ParkModel getPark(Integer levels, Integer limitPerLevel){
        if (partInstance == null) {
            partInstance = new ParkModel(levels, limitPerLevel);
        }

        return partInstance;
    }

    public String toString(){
        StringBuffer toStr = new StringBuffer();
        toStr.append("Current park state:\n");
        this.getAvailableSpots().forEach(spot -> {
            toStr.append(
                    String.format(
                            "Spot on level %d number %s is %s\n",
                            spot.getLevel(),
                            spot.getSpotNumber(),
                            spot.freeMsg()
                    )
            );
        });

        return toStr.toString();
    }

}

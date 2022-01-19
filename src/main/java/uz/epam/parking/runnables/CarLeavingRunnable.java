package uz.epam.parking.runnables;

import uz.epam.parking.helpers.ParkingHelper;
import uz.epam.parking.model.ParkModel;

public class CarLeavingRunnable implements Runnable {

    @Override
    public void run() {
        int carNumber = ParkingHelper.leaveCars(ParkModel.getPark(), 1);
        System.out.printf("Car with number %d leaving \n", carNumber);
    }
}

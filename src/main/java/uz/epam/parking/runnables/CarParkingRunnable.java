package uz.epam.parking.runnables;

import uz.epam.parking.exceptions.ParkIsFullException;
import uz.epam.parking.helpers.ParkingHelper;
import uz.epam.parking.model.ParkModel;

public class CarParkingRunnable implements Runnable {

    @Override
    public void run() {
//        boolean carWasAdded = false;
//        do {
//            try {
//                int carSpot = ParkingHelper.addCars(ParkModel.getPark(4, 10), 1);
//                System.out.printf("Car parking spot number: %d \n", carSpot);
//                carWasAdded = true;
//            } catch (ParkIsFullException e) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(e.getMessage());
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
//            }
//        } while (!carWasAdded);
    }
}

package uz.epam.parking;

import uz.epam.parking.exceptions.ParkIsFullException;
import uz.epam.parking.helpers.ParkingHelper;
import uz.epam.parking.model.ParkModel;
import uz.epam.parking.runnables.CarLeavingRunnable;
import uz.epam.parking.runnables.CarParkingRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkingApplication {

    private static ExecutorService exec = Executors.newFixedThreadPool(15);

    public static void main(String[] args){
        System.out.println("Park is ready to accept cars");

        // for simple one
//        simpleTest();

        // only used Runnables
        simpleTestWithCustomRunnable();

        // I used unit tests also, please look at test folder


        exec.shutdown();
    }

    public static void simpleTest(){

        // parking
        for (int i = 0; i < 15; i++) {
            final int carNumber = i;
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    boolean carWasAdded = false;
                    do {
                        try {
                            int carSpot = ParkingHelper.addCars(ParkModel.getPark(), 1);
                            System.out.printf("Car with number %d parking spot number: %d \n", carNumber, carSpot);
                            carWasAdded = true;
                        } catch (ParkIsFullException e) {
                            try {
                                Thread.sleep(1000);
                                System.out.println(e.getMessage());
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                    } while (!carWasAdded);
                }
            });
        }
        // leaving
        for (int i = 0; i < 15; i++) {
            final int carNumber = i;
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    ParkingHelper.leaveCars(ParkModel.getPark(), 1);
                    System.out.printf("Car with number %d leaving \n", carNumber);
                }
            });
        }
    }

    public static void simpleTestWithCustomRunnable(){
        // parking
        for (int i = 0; i < 15; i++) {
            exec.submit(new CarParkingRunnable());
        }

        // leaving
        for (int i = 0; i < 15; i++) {
            final int carNumber = i;
            exec.submit(new CarLeavingRunnable());
        }
    }
}

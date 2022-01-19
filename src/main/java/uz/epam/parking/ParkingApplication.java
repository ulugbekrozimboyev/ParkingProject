package uz.epam.parking;

import uz.epam.parking.exceptions.ParkIsFullException;
import uz.epam.parking.helpers.ParkingHelper;
import uz.epam.parking.model.ParkModel;
import uz.epam.parking.model.Spot;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkingApplication {

    private static ExecutorService exec = Executors.newFixedThreadPool(4);

    private static Boolean finishedParking = false;

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Input park level's count:");
        int levelCount = input.nextInt();

        System.out.println("Input park spot count in each level:");
        int spotCount = input.nextInt();

        ParkModel park = ParkModel.getPark(levelCount, spotCount);

        System.out.println("Park is ready to accept cars");
        while (!finishedParking) {
            System.out.println("Please, choose one of above operation");
            System.out.println("1. Add a car to parking.");
            System.out.println("2. Leave parking.");
            System.out.println("3. Current state of Parking station.");
            System.out.println("4. Finish testping.");
            switch (input.nextInt()) {
                case 1 :
                    try {
                        Spot spot = ParkingHelper.addCars(park);
                        System.out.printf("New car was plased to spot number: %d at level %d\n", spot.getSpotNumber(), spot.getLevel());
                    } catch (ParkIsFullException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2 :
                    try {
                        Spot spot = ParkingHelper.leaveCars(park);
                        System.out.printf("A car leave to spot number: %d at level %d\n", spot.getSpotNumber(), spot.getLevel());
                    } catch (ParkIsFullyEmptyException e) {
                        e.printStackTrace();
                    }
                break;
                case 3 : System.out.println(park.toString()); break;
                case 4 : finishedParking = true; break;
            }
        }


    }

}

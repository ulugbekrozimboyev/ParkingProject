package uz.epam.parking;

public class ParkIsFullyEmptyException extends Exception {

    public ParkIsFullyEmptyException() {
        super("Park is empty now");
    }

}

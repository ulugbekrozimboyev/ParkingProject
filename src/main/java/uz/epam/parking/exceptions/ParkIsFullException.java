package uz.epam.parking.exceptions;

public class ParkIsFullException extends Exception {

    public ParkIsFullException(){
        super("Park is full right now. Please came later!");
    }

}

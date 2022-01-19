package uz.epam.parking;

import org.junit.jupiter.api.Test;
import uz.epam.parking.exceptions.ParkIsFullException;
import uz.epam.parking.helpers.ParkingHelper;
import uz.epam.parking.model.ParkModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingApplicationTest {

//    @Test
//    public void testParking() throws ParkIsFullException {
//
//        int carSpot = ParkingHelper.addCars(ParkModel.getPark(4, 10), 1);
//        assertEquals(carSpot, 1);
//    }
//
//    @Test
//    public void testParkingOverload() {
//
//        Integer carSpot = null;
//        String errorMsg = null;
//        try {
//            carSpot = ParkingHelper.addCars(ParkModel.getPark(4, 10), 11);
//        } catch (Exception e) {
//            errorMsg = e.getMessage();
//        }
//        assertEquals(carSpot, null);
//        assertEquals(errorMsg, "Park is full right now. Please came later!");
//    }
}

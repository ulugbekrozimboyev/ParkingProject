package uz.epam.parking.helpers;

import lombok.RequiredArgsConstructor;
import uz.epam.parking.ParkIsFullyEmptyException;
import uz.epam.parking.exceptions.ParkIsFullException;
import uz.epam.parking.model.ParkModel;
import uz.epam.parking.model.Spot;

import java.util.Optional;

@RequiredArgsConstructor
public final class ParkingHelper {

    public static Spot addCars(ParkModel parkModel) throws ParkIsFullException {
        synchronized(parkModel) {

            Optional<Spot> spotOptional = parkModel.getAvailableSpots()
                    .stream()
                    .filter(s -> s.getIsFree())
                    .findFirst();

            if(!spotOptional.isPresent()) throw new ParkIsFullException();

            spotOptional.get().setIsFree(false);
            return spotOptional.get();
        }
    }

    public static Spot leaveCars(ParkModel parkModel) throws ParkIsFullyEmptyException {
        synchronized (parkModel) {

            Optional<Spot> spotOptional = parkModel.getAvailableSpots()
                    .stream()
                    .filter(s -> !s.getIsFree())
                    .findFirst();

            if(!spotOptional.isPresent()) throw new ParkIsFullyEmptyException();

            spotOptional.get().setIsFree(true);
            return spotOptional.get();
        }
    }

}

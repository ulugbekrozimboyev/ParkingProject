package uz.epam.parking.helpers;

import uz.epam.parking.exceptions.ParkIsFullException;
import uz.epam.parking.model.ParkModel;

public final class ParkingHelper {

    public static Integer addCars(ParkModel parkModel, Integer joinCarCount) throws ParkIsFullException {
        synchronized(parkModel) {
            if (parkModel.getLimit() > parkModel.getCurrentCarsCount() + joinCarCount) {
                parkModel.setCurrentCarsCount(parkModel.getCurrentCarsCount() + joinCarCount);
                return parkModel.getCurrentCarsCount();
            } else {
                throw new ParkIsFullException();
            }
        }
    }

    public static Integer leaveCars(ParkModel parkModel, Integer leaveCarCount) {
        synchronized (parkModel) {
            if (parkModel.getCurrentCarsCount() < leaveCarCount) {
                parkModel.setCurrentCarsCount(0);
            } else {
                parkModel.setCurrentCarsCount(parkModel.getCurrentCarsCount() - leaveCarCount);
            }
            return parkModel.getCurrentCarsCount();
        }
    }

}

package solutions.fluidity;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case CAR:
                return new Car();
            case ELECTRIC_CAR:
                return new ElectricCar();
            case TRUCK:
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public enum VehicleType {
        CAR, ELECTRIC_CAR, TRUCK
    }
}
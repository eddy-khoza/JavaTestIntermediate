package solutions.fluidity;

public class ElectricCar extends AbstractVehicle implements CargoLoadable, Maintainable {
    private static final int MAX_CARGO_CAPACITY = 500;

    @Override
    public void loadCargo(int kgs) {
        if (kgs > MAX_CARGO_CAPACITY) {
            throw new IllegalArgumentException("too heavy");
        }
        this.cargoSpace = kgs;
    }

    @Override
    public int getMaxCargoCapacity() {
        return MAX_CARGO_CAPACITY;
    }

    @Override
    public void performMaintenance() {
        chargeBattery();
    }

    private void chargeBattery() {
    }
}
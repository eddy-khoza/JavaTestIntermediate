package solutions.fluidity;

public class Truck extends AbstractVehicle implements CargoLoadable, Maintainable {
    private static final int MAX_CARGO_CAPACITY = 18000;

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
        fillUpDiesel();
        checkTrailer();
    }

    private void fillUpDiesel() {
    }

    private void checkTrailer() {
    }
}
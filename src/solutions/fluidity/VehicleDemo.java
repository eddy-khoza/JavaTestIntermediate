package solutions.fluidity;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Test Demonstration ===\n");

        Vehicle car = new Car();
        Vehicle electricCar = new ElectricCar();
        Vehicle truck = new Truck();

        System.out.println("1. Testing Drive Functionality:");
        System.out.print("Car: ");
        car.drive();

        System.out.print("Electric Car: ");
        electricCar.drive();

        System.out.print("Truck: ");
        truck.drive();
        System.out.println();

        System.out.println("2. Testing Cargo Loading:");
        testCargoLoading((CargoLoadable) car, 300, "Car");
        testCargoLoading((CargoLoadable) car, 600, "Car");

        testCargoLoading((CargoLoadable) electricCar, 400, "Electric Car");
        testCargoLoading((CargoLoadable) electricCar, 550, "Electric Car");

        testCargoLoading((CargoLoadable) truck, 10000, "Truck");
        testCargoLoading((CargoLoadable) truck, 20000, "Truck");
        System.out.println();

        System.out.println("3. Testing Maintenance:");
        System.out.print("Car Maintenance: ");
        car.performMaintenance();

        System.out.print("Electric Car Maintenance: ");
        electricCar.performMaintenance();

        System.out.print("Truck Maintenance: ");
        truck.performMaintenance();
        System.out.println();

        System.out.println("4. Testing Vehicle Factory:");
        testVehicleFactory();

        System.out.println("5. Testing Print Stats:");
        car.printStats();
        electricCar.printStats();
        truck.printStats();
    }

    private static void testCargoLoading(CargoLoadable vehicle, int cargoWeight, String vehicleType) {
        try {
            vehicle.loadCargo(cargoWeight);
            System.out.println(vehicleType + " loaded " + cargoWeight + " kgs successfully (Max: " + vehicle.getMaxCargoCapacity() + " kgs)");
        } catch (IllegalArgumentException e) {
            System.out.println(vehicleType + " failed to load " + cargoWeight + " kgs: " + e.getMessage() + " (Max: " + vehicle.getMaxCargoCapacity() + " kgs)");
        }
    }

    private static void testVehicleFactory() {
        try {
            Vehicle factoryCar = VehicleFactory.createVehicle(VehicleFactory.VehicleType.CAR);
            Vehicle factoryElectricCar = VehicleFactory.createVehicle(VehicleFactory.VehicleType.ELECTRIC_CAR);
            Vehicle factoryTruck = VehicleFactory.createVehicle(VehicleFactory.VehicleType.TRUCK);

            System.out.println("Factory created vehicles successfully:");
            System.out.println("- " + factoryCar.getClass().getSimpleName());
            System.out.println("- " + factoryElectricCar.getClass().getSimpleName());
            System.out.println("- " + factoryTruck.getClass().getSimpleName());

            ((CargoLoadable) factoryCar).loadCargo(200);
            System.out.println("Factory car loaded cargo successfully");

        } catch (Exception e) {
            System.out.println("Factory test failed: " + e.getMessage());
        }
        System.out.println();
    }
}
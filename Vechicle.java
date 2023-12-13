import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    String company;
    String model;
    double mileage;
    double fuelCapacity;
    double displacement;

    Vehicle(String company, String model, double mileage, double fuelCapacity, double displacement) {
        this.company = company;
        this.model = model;
        this.mileage = mileage;
        this.fuelCapacity = fuelCapacity;
        this.displacement = displacement;
    }
}

class TwoWheeler extends Vehicle {
    String frontBrake;
    String rearBrake;
    String tyreType;
    String headLamp;
    String userReviews;

    TwoWheeler(String company, String model, double mileage, double fuelCapacity, double displacement,
               String frontBrake, String rearBrake, String tyreType, String headLamp, String userReviews) {
        super(company, model, mileage, fuelCapacity, displacement);
        this.frontBrake = frontBrake;
        this.rearBrake = rearBrake;
        this.tyreType = tyreType;
        this.headLamp = headLamp;
        this.userReviews = userReviews;
    }
}

class FourWheeler extends Vehicle {
    boolean airConditioner;
    boolean airBags;
    boolean powerSteering;
    boolean rainSensingWiper;

    FourWheeler(String company, String model, double mileage, double fuelCapacity, double displacement,
                boolean airConditioner, boolean airBags, boolean powerSteering, boolean rainSensingWiper) {
        super(company, model, mileage, fuelCapacity, displacement);
        this.airConditioner = airConditioner;
        this.airBags = airBags;
        this.powerSteering = powerSteering;
        this.rainSensingWiper = rainSensingWiper;
    }
}

public class VehicleComparisonApp {
    public static void main(String[] args) {
        List<TwoWheeler> twoWheelers = initializeTwoWheelers();
        List<FourWheeler> fourWheelers = initializeFourWheelers();

        displayVehicleDetails(twoWheelers, "Two Wheeler");
        displayVehicleDetails(fourWheelers, "Four Wheeler");

        compareAndChooseModels(twoWheelers, fourWheelers);
    }

    private static List<TwoWheeler> initializeTwoWheelers() {
        List<TwoWheeler> twoWheelers = new ArrayList<>();
        twoWheelers.add(new TwoWheeler("Honda", "Activa", 60, 5, 110, "Disc", "Drum", "Tubeless", "LED", "Positive"));
        twoWheelers.add(new TwoWheeler("TVS", "Jupiter", 55, 5.5, 125, "Drum", "Drum", "Tubeless", "Bulb", "Good"));
        // Add more two-wheelers as needed
        return twoWheelers;
    }

    private static List<FourWheeler> initializeFourWheelers() {
        List<FourWheeler> fourWheelers = new ArrayList<>();
        fourWheelers.add(new FourWheeler("Maruti Suzuki", "Swift", 20, 40, 1200, true, false, true, true));
        fourWheelers.add(new FourWheeler("Honda", "City", 18, 45, 1500, true, true, true, true));
        // Add more four-wheelers as needed
        return fourWheelers;
    }

    private static void displayVehicleDetails(List<? extends Vehicle> vehicles, String vehicleType) {
        System.out.println("Details of " + vehicleType + "s:");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Company: " + vehicle.company);
            System.out.println("Model: " + vehicle.model);
            System.out.println("Mileage: " + vehicle.mileage + " km/l");
            System.out.println("Fuel Capacity: " + vehicle.fuelCapacity + " liters");
            System.out.println("Displacement: " + vehicle.displacement + " cc");
            System.out.println("------------------------------");
        }
    }

    private static void compareAndChooseModels(List<TwoWheeler> twoWheelers, List<FourWheeler> fourWheelers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to compare Two Wheeler or Four Wheeler? (Enter '2' or '4')");
        int choice = scanner.nextInt();

        if (choice == 2) {
            System.out.println("Enter the models to compare (e.g., Activa Jupiter):");
            scanner.nextLine(); // consume the newline character
            String model1 = scanner.next();
            String model2 = scanner.next();

            compareTwoWheelers(twoWheelers, model1, model2);
        } else if (choice == 4) {
            System.out.println("Enter the models to compare (e.g., Swift City):");
            scanner.nextLine(); // consume the newline character
            String model1 = scanner.next();
            String model2 = scanner.next();

            compareFourWheelers(fourWheelers, model1, model2);
        } else {
            System.out.println("Invalid choice. Please enter '2' or '4'.");
        }

        scanner.close();
    }

    private static void compareTwoWheelers(List<TwoWheeler> twoWheelers, String model1, String model2) {
        TwoWheeler selectedModel1 = findTwoWheeler(twoWheelers, model1);
        TwoWheeler selectedModel2 = findTwoWheeler(twoWheelers, model2);

        if (selectedModel1 != null && selectedModel2 != null) {
            System.out.println("Comparison Result for Two Wheelers:");
            System.out.println("Model 1 - " + selectedModel1.company + " " + selectedModel1.model);
            System.out.println("Model 2 - " + selectedModel2.company + " " + selectedModel2.model);
        } else {
            System.out.println("Invalid model names. Please enter valid model names.");
        }
    }

    private static void compareFourWheelers(List<FourWheeler> fourWheelers, String model1, String model2) {
        FourWheeler selectedModel1 = findFourWheeler(fourWheelers, model1);
        FourWheeler selectedModel2 = findFourWheeler(fourWheelers, model2);

        if (selectedModel1 != null && selectedModel2 != null) {
            System.out.println("Comparison Result for Four Wheelers:");
            System.out.println("Model 1 - " + selectedModel1.company + " " + selectedModel1.model);
            System.out.println("Model 2 - " + selectedModel2.company + " " + selectedModel2.model);
        } else {
            System.out.println("Invalid model names. Please enter valid model names.");
        }
    }

    private static TwoWheeler findTwoWheeler(List<TwoWheeler> twoWheelers, String model) {
        for (TwoWheeler twoWheeler : twoWheelers) {
            if (twoWheeler.model.equalsIgnoreCase(model)) {
                return twoWheeler;
            }
        }
        return null;
    }

    private static FourWheeler findFourWheeler(List<FourWheeler> fourWheelers, String model) {
        for (FourWheeler fourWheeler : fourWheelers) {
            if (fourWheeler.model.equalsIgnoreCase(model)) {
                return fourWheeler;
            }
        }
        return null;
    }
}


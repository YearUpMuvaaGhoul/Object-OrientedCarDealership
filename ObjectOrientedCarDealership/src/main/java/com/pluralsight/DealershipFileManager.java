package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public Dealership getDealership() throws IOException {
        Dealership dealership = new Dealership("Dealership Name", "Address", "Phone Number");
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Vehicle vehicle = getVehicle(line);
                dealership.addVehicle(vehicle);
            }
        }
        return dealership;
    }

    public static Vehicle getVehicle(String line) {
        String[] details = line.split(" ");
        int vin = Integer.parseInt(details[0]);
        int year = Integer.parseInt(details[1]);
        String make = details[2];
        String model = details[3];
        String vehicleType = details[4];
        String color = details[5];
        int odometer = Integer.parseInt(details[6]);
        double price = Double.parseDouble(details[7]);

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        return vehicle;
    }

    public void saveDealership(Dealership dealership) {
        // Placeholder for saving logic
    }
}

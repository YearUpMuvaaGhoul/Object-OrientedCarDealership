package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public Dealership getDealership() throws IOException {
        Dealership dealership = new Dealership("Dealership Name", "Address", "Phone Number");
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) { //opens file for reading
            String line;
            while ((line = br.readLine()) != null) { //reads the file line by line until the end of file
                Vehicle vehicle = getVehicle(line); // converts each line into vehicle object using getVehicle method
                dealership.addVehicle(vehicle); //adds the created Vehicle object to the dealerships inventory
            }
        }
        return dealership;
    }

    public static Vehicle getVehicle(String line) {
        String[] details = line.split(" "); //Creates detail string which will include all info necessary to add a new vehicle
        int vin = Integer.parseInt(details[0]); // First element in the details array (vin  is variable that stores value)
        int year = Integer.parseInt(details[1]);
        String make = details[2];
        String model = details[3];
        String vehicleType = details[4];
        String color = details[5];
        int odometer = Integer.parseInt(details[6]); // converts string into integer
        double price = Double.parseDouble(details[7]); //converts string into double

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        return vehicle;
    }
// each line extracts specific piece of data from details array, converts it, and stores the type in a variable.


    public void saveDealership(Dealership dealership) {
        // Placeholder for saving logic
    }
}

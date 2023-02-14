import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class ResidentialSociety {
    String societyName;
    String location;
    String secretaryName;
    
    public ResidentialSociety(String societyName, String location, String secretaryName) {
        this.societyName = societyName;
        this.location = location;
        this.secretaryName = secretaryName;
    }
    
    public void viewSocietyDetails() {
        System.out.println("Society Name: " + societyName);
        System.out.println("Location: " + location);
        System.out.println("Society Secretary Name: " + secretaryName+"\n\n");
    }
}

class Building extends ResidentialSociety {
    String buildingName;
    int totalNumberOfApartments;
    List<Apartment > apartments=new ArrayList<>();  
    
    public Building(String societyName, String location, String secretaryName, String buildingName, int totalNumberOfApartments) {
        super(societyName, location, secretaryName);
        this.buildingName = buildingName;
        this.totalNumberOfApartments = totalNumberOfApartments;
        
    }
    
    public void viewBuildingDetails() {
        System.out.println("Building Name: " + buildingName);
        System.out.println("Number of Apartments: " + totalNumberOfApartments);
    }
    
    public void viewApartmentDetails() {
        System.out.println("Apartment Details:");
        for (int i = 0; i <apartments.size(); i++) {
            System.out.println("Apartment " + (i + 1) + ":");
            apartments.get(i).viewApartmentDetails();
          
        }
    }
}

class Apartment extends Building {
    int apartmentNumber;
    String ownerName;
    String electricMeterNumber;
    
    public Apartment(String societyName, String location, String secretaryName, String buildingName, int totalNumberOfApartments, int apartmentNumber, String ownerName, String electricMeterNumber) {
        super(societyName, location, secretaryName, buildingName, totalNumberOfApartments);
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
        this.electricMeterNumber = electricMeterNumber;
    }
    
    public void viewApartmentDetails() {
        System.out.println("Apartment Number: " + apartmentNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Electric Meter Number: " + electricMeterNumber+"\n\n");
    }
}

public class File {
    public static void main(String[] args) {
        ResidentialSociety society = new ResidentialSociety("Aditya Residential Society", "SuramPalem, East Godavari", "ACBESD");
        
        Building buildingA = new Building("Aditya Residential Society", "SuramPalem, East Godavari", "ACBESD", "Building A", 10);
        Building buildingB = new Building("Aditya Residential Society", "SuramPalem, East Godavari","ACBESD","Building B", 10);
        Building buildingC = new Building("Aditya Residential Society", "SuramPalem, East Godavari", "ACBESD", "Building C", 10);
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ApartmentDetails.csv"));
            String line;
        
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int apartmentNumber = Integer.parseInt(data[0]);
                String buildingName = data[1];
                String ownerName = data[2];
                String electricMeterNumber = data[3];
                
                Building building = null;
                if (buildingName.equals("A")) {
                    building = buildingA;
                } else if (buildingName.equals("B")) {
                    building = buildingB;
                } else if (buildingName.equals("C")) {
                    building = buildingC;
                }
                
                Apartment apartment = new Apartment(society.societyName, society.location, society.secretaryName, buildingName, building.totalNumberOfApartments, apartmentNumber, ownerName, electricMeterNumber);
                building.apartments.add(apartment);
              
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
        
        System.out.println("Society Details:");
        society.viewSocietyDetails();
        System.out.println();
        
        System.out.println("Building A Details:");
        buildingA.viewBuildingDetails();
        buildingA.viewApartmentDetails();
        System.out.println();
        
        System.out.println("Building B Details:");
        buildingB.viewBuildingDetails();
        buildingB.viewApartmentDetails();
        System.out.println();
        
        System.out.println("Building C Details:");
        buildingC.viewBuildingDetails();
        buildingC.viewApartmentDetails();
    }
}

// Represents a driver's license with all relevant info
public class DriverLisence {
    // Static counters for unique IDs and plate numbers
    private static int nextDriverID = 100000;
    private static int nextRegistrationPlate = 60000000;

    // Fields for driver and vehicle details
    private String driverName;
    private int driverID;
    private String address;
    private String experience; // "novice" or "expert"
    private String vehicleType; // "car", "truck", or "motor bike"
    private String vehicleBrand;
    private int manufacturingYear;
    private int registrationPlateNumber;
    private int issuingYear;
    private int validityPeriod; // 1 year for novice, 4 years for expert

    // Constructor for new licenses (auto-assigns IDs)
    public DriverLisence(String driverName, String address, String experience, String vehicleType, String vehicleBrand, int manufacturingYear, int issuingYear) {
        this.driverName = driverName;
        this.driverID = nextDriverID++;
        this.address = address;
        this.experience = experience;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.manufacturingYear = manufacturingYear;
        this.registrationPlateNumber = nextRegistrationPlate++;
        this.issuingYear = issuingYear;
        // Set validity based on experience
        if ("novice".equalsIgnoreCase(experience)) {
            this.validityPeriod = 1;
        } else if ("expert".equalsIgnoreCase(experience)) {
            this.validityPeriod = 4;
        } else {
            this.validityPeriod = 0; // Unknown experience
        }
    }

    // Constructor for loading licenses with known IDs
    public DriverLisence(String driverName, int driverID, String address, String experience, String vehicleType, String vehicleBrand, int manufacturingYear, int registrationPlateNumber, int issuingYear) {
        this.driverName = driverName;
        this.driverID = driverID;
        this.address = address;
        this.experience = experience;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.manufacturingYear = manufacturingYear;
        this.registrationPlateNumber = registrationPlateNumber;
        this.issuingYear = issuingYear;
        // Set validity based on experience
        if ("novice".equalsIgnoreCase(experience)) {
            this.validityPeriod = 1;
        } else if ("expert".equalsIgnoreCase(experience)) {
            this.validityPeriod = 4;
        } else {
            this.validityPeriod = 0; // Unknown experience
        }
    }

    // Getter and setter for driver name
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    // Getter for driver ID
    public int getDriverID() {
        return driverID;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter for experience, updates validity
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
        if ("novice".equalsIgnoreCase(experience)) {
            this.validityPeriod = 1;
        } else if ("expert".equalsIgnoreCase(experience)) {
            this.validityPeriod = 4;
        } else {
            this.validityPeriod = 0;
        }
    }

    // Getter and setter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Getter and setter for vehicle brand
    public String getVehicleBrand() {
        return vehicleBrand;
    }
    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    // Getter and setter for manufacturing year
    public int getManufacturingYear() {
        return manufacturingYear;
    }
    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    // Getter for registration plate number
    public int getRegistrationPlateNumber() {
        return registrationPlateNumber;
    }

    // Getter and setter for issuing year
    public int getIssuingYear() {
        return issuingYear;
    }
    public void setIssuingYear(int issuingYear) {
        this.issuingYear = issuingYear;
    }

    // Getter for validity period
    public int getValidityPeriod() {
        return validityPeriod;
    }

    // String representation for easy printing
    @Override
    public String toString() {
        return "DriverLisence{" +
                "driverName='" + driverName + '\'' +
                ", driverID=" + driverID +
                ", address='" + address + '\'' +
                ", experience='" + experience + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", registrationPlateNumber=" + registrationPlateNumber +
                ", issuingYear=" + issuingYear +
                ", validityPeriod=" + validityPeriod +
                '}';
    }
} 
public class DriverLisence {
    private static int nextDriverID = 100000;
    private static int nextRegistrationPlate = 60000000;

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
        if ("novice".equalsIgnoreCase(experience)) {
            this.validityPeriod = 1;
        } else if ("expert".equalsIgnoreCase(experience)) {
            this.validityPeriod = 4;
        } else {
            this.validityPeriod = 0; // Unknown experience
        }
    }

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
        if ("novice".equalsIgnoreCase(experience)) {
            this.validityPeriod = 1;
        } else if ("expert".equalsIgnoreCase(experience)) {
            this.validityPeriod = 4;
        } else {
            this.validityPeriod = 0; // Unknown experience
        }
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverID() {
        return driverID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getRegistrationPlateNumber() {
        return registrationPlateNumber;
    }

    public int getIssuingYear() {
        return issuingYear;
    }

    public void setIssuingYear(int issuingYear) {
        this.issuingYear = issuingYear;
    }

    public int getValidityPeriod() {
        return validityPeriod;
    }

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
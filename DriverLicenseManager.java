import java.util.ArrayList;
import java.util.List;

// Manages a list of driver licenses
public class DriverLicenseManager {
    private List<DriverLisence> licenses;

    // Constructor initializes the license list
    public DriverLicenseManager() {
        licenses = new ArrayList<>();
    }

    // Add a new license to the list
    public void addLicense(DriverLisence license) {
        licenses.add(license);
    }

    // Update license info by driver ID
    public boolean updateLicense(int driverID, DriverLisence updatedLicense) {
        // Search for license by ID and replace if found
        for (int i = 0; i < licenses.size(); i++) {
            if (licenses.get(i).getDriverID() == driverID) {
                licenses.set(i, updatedLicense);
                return true;
            }
        }
        return false; // Not found
    }

    // Search for a license by driver ID
    public DriverLisence searchLicense(int driverID) {
        for (DriverLisence license : licenses) {
            if (license.getDriverID() == driverID) {
                return license;
            }
        }
        return null; // Not found
    }

    // Remove a license by driver ID
    public boolean removeLicense(int driverID) {
        // Remove license if ID matches
        return licenses.removeIf(license -> license.getDriverID() == driverID);
    }

    // Return a copy of all licenses
    public List<DriverLisence> getAllLicenses() {
        return new ArrayList<>(licenses);
    }

    // Internal getter for testing purposes
    List<DriverLisence> getLicensesInternal() {
        return licenses;
    }
} 
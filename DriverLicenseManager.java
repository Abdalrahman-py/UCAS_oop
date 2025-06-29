import java.util.ArrayList;
import java.util.List;

public class DriverLicenseManager {
    private List<DriverLisence> licenses;

    public DriverLicenseManager() {
        licenses = new ArrayList<>();
    }

    // Add a new license
    public void addLicense(DriverLisence license) {
        licenses.add(license);
    }

    // Update license info by driver ID
    public boolean updateLicense(int driverID, DriverLisence updatedLicense) {
        for (int i = 0; i < licenses.size(); i++) {
            if (licenses.get(i).getDriverID() == driverID) {
                licenses.set(i, updatedLicense);
                return true;
            }
        }
        return false;
    }

    // Search for a license by driver ID
    public DriverLisence searchLicense(int driverID) {
        for (DriverLisence license : licenses) {
            if (license.getDriverID() == driverID) {
                return license;
            }
        }
        return null;
    }

    // Remove a license by driver ID
    public boolean removeLicense(int driverID) {
        return licenses.removeIf(license -> license.getDriverID() == driverID);
    }

    // List all licenses
    public List<DriverLisence> getAllLicenses() {
        return new ArrayList<>(licenses);
    }

    // Package-private getter for testing
    List<DriverLisence> getLicensesInternal() {
        return licenses;
    }
} 
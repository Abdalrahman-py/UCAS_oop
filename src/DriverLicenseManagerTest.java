import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

// Unit tests for DriverLicenseManager
class DriverLicenseManagerTest {
    @Test
    void testAddAndGetAllLicenses() {
        // Test adding a license and retrieving all licenses
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLicense lic = new DriverLicense("Alice", 100001, "123 St", "novice", "car", "Toyota", 2015, 60000001, 2022);
        manager.addLicense(lic);
        List<DriverLicense> all = manager.getAllLicenses();
        assertEquals(1, all.size());
        assertEquals("Alice", all.get(0).getDriverName());
    }

    @Test
    void testUpdateLicense() {
        // Test updating a license and checking updated fields
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLicense lic = new DriverLicense("Bob", 100002, "456 Ave", "expert", "truck", "Ford", 2018, 60000002, 2021);
        manager.addLicense(lic);
        DriverLicense updated = new DriverLicense("Bob Updated", 100002, "789 Blvd", "novice", "car", "Honda", 2020, 60000002, 2023);
        boolean result = manager.updateLicense(100002, updated);
        assertTrue(result);
        DriverLicense found = manager.searchLicense(100002);
        assertEquals("Bob Updated", found.getDriverName());
        assertEquals("789 Blvd", found.getAddress());
    }

    @Test
    void testSearchLicense() {
        // Test searching for a license by ID
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLicense lic = new DriverLicense("Carol", 100003, "321 Rd", "novice", "motor bike", "Yamaha", 2017, 60000003, 2020);
        manager.addLicense(lic);
        DriverLicense found = manager.searchLicense(100003);
        assertNotNull(found);
        assertEquals("Carol", found.getDriverName());
    }

    @Test
    void testRemoveLicense() {
        // Test removing a license and ensuring it's gone
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLicense lic = new DriverLicense("Dave", 100004, "654 Ln", "expert", "car", "BMW", 2019, 60000004, 2022);
        manager.addLicense(lic);
        boolean removed = manager.removeLicense(100004);
        assertTrue(removed);
        assertNull(manager.searchLicense(100004));
    }

    @Test
    void testListIsCopy() {
        // Test that getAllLicenses returns a copy, not the original list
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLicense lic = new DriverLicense("Eve", 100005, "987 Pkwy", "novice", "truck", "Chevy", 2016, 60000005, 2021);
        manager.addLicense(lic);
        List<DriverLicense> all = manager.getAllLicenses();
        all.clear();
        assertEquals(1, manager.getAllLicenses().size());
    }

    @Test
    void testAutomaticIdsAndLicenseCount() {
        // Test automatic driver ID and registration plate assignment, and license count
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLicense lic1 = new DriverLicense("Test1", "Addr1", "novice", "car", "Brand1", 2010, 2020);
        DriverLicense lic2 = new DriverLicense("Test2", "Addr2", "expert", "truck", "Brand2", 2012, 2021);
        manager.addLicense(lic1);
        manager.addLicense(lic2);
        // Check that IDs are unique and incremented
        assertEquals(lic1.getDriverID() + 1, lic2.getDriverID());
        assertEquals(lic1.getRegistrationPlateNumber() + 1, lic2.getRegistrationPlateNumber());
        // Check the number of licenses
        assertEquals(2, manager.getAllLicenses().size());
    }
} 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class DriverLicenseManagerTest {
    @Test
    void testAddAndGetAllLicenses() {
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLisence lic = new DriverLisence("Alice", 100001, "123 St", "novice", "car", "Toyota", 2015, 60000001, 2022);
        manager.addLicense(lic);
        List<DriverLisence> all = manager.getAllLicenses();
        assertEquals(1, all.size());
        assertEquals("Alice", all.get(0).getDriverName());
    }

    @Test
    void testUpdateLicense() {
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLisence lic = new DriverLisence("Bob", 100002, "456 Ave", "expert", "truck", "Ford", 2018, 60000002, 2021);
        manager.addLicense(lic);
        DriverLisence updated = new DriverLisence("Bob Updated", 100002, "789 Blvd", "novice", "car", "Honda", 2020, 60000002, 2023);
        boolean result = manager.updateLicense(100002, updated);
        assertTrue(result);
        DriverLisence found = manager.searchLicense(100002);
        assertEquals("Bob Updated", found.getDriverName());
        assertEquals("789 Blvd", found.getAddress());
    }

    @Test
    void testSearchLicense() {
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLisence lic = new DriverLisence("Carol", 100003, "321 Rd", "novice", "motor bike", "Yamaha", 2017, 60000003, 2020);
        manager.addLicense(lic);
        DriverLisence found = manager.searchLicense(100003);
        assertNotNull(found);
        assertEquals("Carol", found.getDriverName());
    }

    @Test
    void testRemoveLicense() {
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLisence lic = new DriverLisence("Dave", 100004, "654 Ln", "expert", "car", "BMW", 2019, 60000004, 2022);
        manager.addLicense(lic);
        boolean removed = manager.removeLicense(100004);
        assertTrue(removed);
        assertNull(manager.searchLicense(100004));
    }

    @Test
    void testListIsCopy() {
        DriverLicenseManager manager = new DriverLicenseManager();
        DriverLisence lic = new DriverLisence("Eve", 100005, "987 Pkwy", "novice", "truck", "Chevy", 2016, 60000005, 2021);
        manager.addLicense(lic);
        List<DriverLisence> all = manager.getAllLicenses();
        all.clear();
        assertEquals(1, manager.getAllLicenses().size());
    }
} 
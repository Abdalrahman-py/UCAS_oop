import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DriverLicenseManager manager = new DriverLicenseManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNewLicense(manager, scanner);
                    break;
                case 2:
                    updateLicenseInfo(manager, scanner);
                    break;
                case 3:
                    searchForLicense(manager, scanner);
                    break;
                case 4:
                    removeLicense(manager, scanner);
                    break;
                case 5:
                    listLicenses(manager, scanner);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\nDriver License Management System");
        System.out.println("1. Add new license");
        System.out.println("2. Update license info");
        System.out.println("3. Search for a license");
        System.out.println("4. Remove a license");
        System.out.println("5. List all licenses");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addNewLicense(DriverLicenseManager manager, Scanner scanner) {
        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter experience (novice/expert): ");
        String experience = scanner.nextLine();
        System.out.print("Enter vehicle type (car/truck/motor bike): ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter vehicle brand: ");
        String vehicleBrand = scanner.nextLine();
        System.out.print("Enter manufacturing year: ");
        int manufacturingYear = 0;
        try {
            manufacturingYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Setting to 0.");
        }
        System.out.print("Enter issuing year: ");
        int issuingYear = 0;
        try {
            issuingYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Setting to 0.");
        }
        DriverLisence newLicense = new DriverLisence(name, address, experience, vehicleType, vehicleBrand, manufacturingYear, issuingYear);
        manager.addLicense(newLicense);
        System.out.println("New license added:");
        System.out.println(newLicense);
    }

    private static void updateLicenseInfo(DriverLicenseManager manager, Scanner scanner) {
        System.out.print("Enter driver ID to update: ");
        int updateID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        DriverLisence licenseToUpdate = manager.searchLicense(updateID);
        if (licenseToUpdate == null) {
            System.out.println("License not found.");
            return;
        }
        
        boolean updating = true;
        while (updating) {
            System.out.println("\nCurrent License Info:");
            System.out.println(licenseToUpdate);
            displayUpdateMenu();
            int field = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            updateLicenseField(licenseToUpdate, field, scanner);
            
            System.out.println("\nUpdated License Info:");
            System.out.println(licenseToUpdate);
            System.out.print("Do you want to change another field? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                updating = false;
            }
        }
    }

    private static void displayUpdateMenu() {
        System.out.println("Which field do you want to change?");
        System.out.println("1. Driver Name");
        System.out.println("2. Address");
        System.out.println("3. Experience");
        System.out.println("4. Vehicle Type");
        System.out.println("5. Vehicle Brand");
        System.out.println("6. Manufacturing Year");
        System.out.println("7. Issuing Year");
        System.out.print("Enter a number (1-7): ");
    }

    private static void updateLicenseField(DriverLisence license, int field, Scanner scanner) {
        switch (field) {
            case 1:
                System.out.print("Enter new driver name: ");
                license.setDriverName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter new address: ");
                license.setAddress(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter new experience (novice/expert): ");
                license.setExperience(scanner.nextLine());
                break;
            case 4:
                System.out.print("Enter new vehicle type (car/truck/motor bike): ");
                license.setVehicleType(scanner.nextLine());
                break;
            case 5:
                System.out.print("Enter new vehicle brand: ");
                license.setVehicleBrand(scanner.nextLine());
                break;
            case 6:
                System.out.print("Enter new manufacturing year: ");
                try {
                    license.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year. No change made.");
                }
                break;
            case 7:
                System.out.print("Enter new issuing year: ");
                try {
                    license.setIssuingYear(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year. No change made.");
                }
                break;
            default:
                System.out.println("Invalid field number.");
        }
    }

    private static void searchForLicense(DriverLicenseManager manager, Scanner scanner) {
        System.out.println("Search by:");
        System.out.println("1. Driver ID");
        System.out.println("2. Driver Name");
        System.out.println("3. Registration Plate Number");
        System.out.print("Choose an option: ");
        int searchOption = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        DriverLisence found = performSearch(manager, scanner, searchOption);
        
        if (found != null) {
            System.out.println("License found:");
            System.out.println(found);
        } else {
            System.out.println("no result");
        }
    }

    private static DriverLisence performSearch(DriverLicenseManager manager, Scanner scanner, int searchOption) {
        switch (searchOption) {
            case 1:
                System.out.print("Enter driver ID: ");
                int searchID = scanner.nextInt();
                scanner.nextLine();
                return manager.searchLicense(searchID);
            case 2:
                System.out.print("Enter driver name: ");
                String searchName = scanner.nextLine();
                for (DriverLisence lic : manager.getAllLicenses()) {
                    if (lic.getDriverName().equalsIgnoreCase(searchName)) {
                        return lic;
                    }
                }
                return null;
            case 3:
                System.out.print("Enter registration plate number: ");
                int regPlate = scanner.nextInt();
                scanner.nextLine();
                for (DriverLisence lic : manager.getAllLicenses()) {
                    if (lic.getRegistrationPlateNumber() == regPlate) {
                        return lic;
                    }
                }
                return null;
            default:
                System.out.println("Invalid search option.");
                return null;
        }
    }

    private static void removeLicense(DriverLicenseManager manager, Scanner scanner) {
        System.out.print("Enter license ID to remove: ");
        int removeID = scanner.nextInt();
        scanner.nextLine();
        DriverLisence licenseToRemove = manager.searchLicense(removeID);
        if (licenseToRemove == null) {
            System.out.println("License not found.");
            return;
        }
        System.out.println("License found:");
        System.out.println(licenseToRemove);
        System.out.print("Are you sure you want to remove this license? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("yes")) {
            boolean removed = manager.removeLicense(removeID);
            if (removed) {
                System.out.println("License removed successfully.");
            } else {
                System.out.println("Failed to remove license.");
            }
        } else {
            System.out.println("License not removed.");
        }
    }

    private static void listLicenses(DriverLicenseManager manager, Scanner scanner) {
        System.out.println("View:");
        System.out.println("1. All licenses");
        System.out.println("2. Specific license by ID");
        System.out.print("Choose an option: ");
        int listOption = scanner.nextInt();
        scanner.nextLine();
        
        if (listOption == 1) {
            displayAllLicenses(manager);
        } else if (listOption == 2) {
            displaySpecificLicense(manager, scanner);
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void displayAllLicenses(DriverLicenseManager manager) {
        var allLicenses = manager.getAllLicenses();
        if (allLicenses.isEmpty()) {
            System.out.println("No licenses found.");
        } else {
            System.out.println("All licenses:");
            for (DriverLisence lic : allLicenses) {
                System.out.println(lic);
                System.out.println("----------------------");
            }
        }
    }

    private static void displaySpecificLicense(DriverLicenseManager manager, Scanner scanner) {
        System.out.print("Enter license ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        DriverLisence lic = manager.searchLicense(id);
        if (lic != null) {
            System.out.println(lic);
        } else {
            System.out.println("License not found.");
        }
    }
} 
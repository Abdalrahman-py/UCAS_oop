# Driver License Manager

A Java application for managing driver licenses with basic CRUD (Create, Read, Update, Delete) operations. This project demonstrates object-oriented programming concepts including classes, inheritance, encapsulation, and unit testing.

## Features

- ✅ Add new driver licenses with automatic ID generation
- 🔍 Search for licenses by Driver ID, Name, or Registration Plate
- ✏️ Update existing license information
- 🗑️ Remove licenses with confirmation
- 📋 List all licenses or view specific ones
- 🧪 Comprehensive unit tests for all functionality

## Installation & Setup

### Prerequisites
- **Java 8 or higher** - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
- **JUnit 5** - For running tests (see installation below)

### Installing JUnit 5

#### Option 1: Download JUnit Standalone JAR
1. Go to [JUnit 5 Releases](https://github.com/junit-team/junit5/releases)
2. Download `junit-platform-console-standalone-1.10.2.jar`
3. Place the JAR file in the **parent directory** of this project (one level up from the `final` folder)

#### Option 2: Using Maven (if you have Maven installed)
```bash
mvn dependency:get -Dartifact=org.junit.platform:junit-platform-console-standalone:1.10.2
```

#### Option 3: Using Gradle (if you have Gradle installed)
```bash
gradle dependencies --configuration testRuntimeClasspath
```

### Running the Application

1. **Compile the code:**
   ```bash
   javac -cp "../junit-platform-console-standalone-1.10.2.jar" *.java
   ```

2. **Run the main application:**
   ```bash
   java -cp . Main
   ```

3. **Run the tests:**
   ```bash
   java -cp ".:../junit-platform-console-standalone-1.10.2.jar" org.junit.platform.console.ConsoleLauncher --class-path . --scan-class-path
   ```

## Code Structure & Explanation

### 📁 Project Files

#### 1. `DriverLisence.java` - The Data Model
This class represents a driver license with all its properties:

**Key Features:**
- **Automatic ID Generation**: Each license gets a unique driver ID (starting from 100000)
- **Automatic Registration Plate**: Each vehicle gets a unique plate number (starting from 60000000)
- **Experience-based Validity**: 
  - Novice drivers: 1 year validity
  - Expert drivers: 4 years validity

**Main Properties:**
```java
private String driverName;           // Driver's full name
private int driverID;               // Unique identifier (auto-generated)
private String address;             // Driver's address
private String experience;          // "novice" or "expert"
private String vehicleType;         // "car", "truck", or "motor bike"
private String vehicleBrand;        // Brand of the vehicle
private int manufacturingYear;      // Year the vehicle was made
private int registrationPlateNumber; // Unique plate number (auto-generated)
private int issuingYear;            // Year license was issued
private int validityPeriod;         // How long license is valid (1 or 4 years)
```

**Two Constructors:**
- **Simple Constructor**: Creates license with auto-generated IDs
- **Full Constructor**: Creates license with specific IDs (useful for testing)

#### 2. `DriverLicenseManager.java` - The Business Logic
This class manages all license operations:

**Core Methods:**
- `addLicense()` - Adds a new license to the system
- `updateLicense()` - Updates existing license information
- `searchLicense()` - Finds a license by driver ID
- `removeLicense()` - Removes a license from the system
- `getAllLicenses()` - Returns a copy of all licenses (prevents external modification)

**Data Storage:**
- Uses `ArrayList<DriverLisence>` to store all licenses
- Returns copies of lists to maintain encapsulation

#### 3. `Main.java` - The User Interface
This class provides a console-based menu system:

**Main Menu Options:**
1. **Add New License** - Collects all license information from user
2. **Update License** - Allows updating specific fields of existing licenses
3. **Search License** - Search by ID, name, or registration plate
4. **Remove License** - Removes licenses with confirmation
5. **List All Licenses** - Shows all licenses or specific ones
6. **Exit** - Closes the application

**User Experience Features:**
- Input validation for numeric fields
- Confirmation prompts for destructive operations
- Clear menu navigation
- Detailed error messages

#### 4. `DriverLicenseManagerTest.java` - The Test Suite
This class contains unit tests to verify all functionality works correctly:

**Test Coverage:**
- `testAddAndGetAllLicenses()` - Tests adding and retrieving licenses
- `testUpdateLicense()` - Tests updating license information
- `testSearchLicense()` - Tests searching for specific licenses
- `testRemoveLicense()` - Tests removing licenses
- `testListIsCopy()` - Tests that returned lists are copies (not references)

## How to Use the Application

### Starting the Application
1. Run `java -cp . Main`
2. You'll see a menu with 6 options

### Adding a New License
1. Choose option 1
2. Enter driver details:
   - Name: Full name of the driver
   - Address: Driver's address
   - Experience: Type "novice" or "expert"
   - Vehicle Type: Type "car", "truck", or "motor bike"
   - Vehicle Brand: Brand name (e.g., Toyota, Ford)
   - Manufacturing Year: Year the vehicle was made
   - Issuing Year: Year the license was issued

### Searching for a License
1. Choose option 3
2. Select search method:
   - Driver ID: Enter the unique ID number
   - Driver Name: Enter the driver's name
   - Registration Plate: Enter the plate number

### Updating a License
1. Choose option 2
2. Enter the driver ID of the license to update
3. Select which field to change (1-7)
4. Enter the new value
5. Choose whether to update more fields

### Removing a License
1. Choose option 4
2. Enter the driver ID
3. Confirm the removal by typing "yes"

## Testing the Application

Run the test suite to verify everything works:
```bash
java -cp ".:../junit-platform-console-standalone-1.10.2.jar" org.junit.platform.console.ConsoleLauncher --class-path . --scan-class-path
```

**Expected Output:**
- All 5 tests should pass
- You'll see green checkmarks (✔) for each test

## Troubleshooting

### Common Issues:

1. **"JUnit not found" error:**
   - Make sure the JUnit JAR is in the parent directory
   - Check the file name matches exactly: `junit-platform-console-standalone-1.10.2.jar`

2. **"Class not found" error:**
   - Make sure you compiled all files: `javac -cp "../junit-platform-console-standalone-1.10.2.jar" *.java`

3. **Tests not running:**
   - Verify you're in the correct directory (the `final` folder)
   - Check that all `.class` files were created after compilation

## Project Learning Objectives

This project demonstrates:
- **Object-Oriented Programming**: Classes, encapsulation, inheritance
- **Data Structures**: ArrayList usage and management
- **User Input Handling**: Scanner class and input validation
- **Unit Testing**: JUnit framework and test-driven development
- **File Organization**: Proper separation of concerns
- **Documentation**: Clear code comments and README

## Contributing

Feel free to fork this project and add new features like:
- Database integration
- GUI interface
- Additional search methods
- License expiration tracking
- Export functionality 
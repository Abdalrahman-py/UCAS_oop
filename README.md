# Driver License Manager

A Java application for managing driver licenses with basic CRUD operations.

## Features

- Add new driver licenses
- Search for licenses by ID
- Update existing licenses
- Remove licenses
- List all licenses

## Setup

### Prerequisites
- Java 8 or higher
- JUnit 5 (for running tests)

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

## Project Structure

- `DriverLicenseManager.java` - Main manager class
- `DriverLisence.java` - License entity class
- `Main.java` - Application entry point
- `DriverLicenseManagerTest.java` - Unit tests

## Dependencies

- JUnit 5 (junit-platform-console-standalone-1.10.2.jar) - for testing

## Note

The JUnit JAR file should be placed in the parent directory (`../junit-platform-console-standalone-1.10.2.jar`) for the tests to run properly. 
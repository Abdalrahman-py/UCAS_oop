# Driver License Manager

A Java application for managing driver licenses with basic CRUD (Create, Read, Update, Delete) operations. This project demonstrates object-oriented programming concepts including classes, inheritance, encapsulation, and unit testing.

## Features

- ✅ Add new driver licenses with automatic ID generation
- 🔍 Search for licenses by Driver ID, Name, or Registration Plate
- ✏️ Update existing license information
- 🗑️ Remove licenses with confirmation
- 📋 List all licenses or view specific ones
- 🧪 Comprehensive unit tests for all functionality

## Quick Start

### 1. Clone or Download the Repository

```sh
git clone <your-repo-url>
cd final_project
```

### 2. Build the Project

```sh
make all
```
This will compile all Java source files from `src/` into `.class` files in the `bin/` directory.

### 3. Run the Application

```sh
make run
```

### 4. (Optional) Run the Tests

```sh
make test
```

**No extra setup is required!** All dependencies (JUnit JARs) are included in the `lib/` directory.

---

## Project Structure

```
final_project/
│
├── src/      # All Java source files
├── lib/      # All external JARs (JUnit, etc.)
├── bin/      # Compiled .class files (auto-generated)
├── .vscode/  # VSCode settings
├── .gitignore
├── .classpath
├── Makefile
├── README.md
└── (other config files)
```

- **Source code:** All `.java` files are in `src/`.
- **Dependencies:** All required JARs are in `lib/` (already included).
- **Compiled files:** All `.class` files are generated in `bin/` after running `make all`.

---

## How to Use the Application

1. Run `make run` to start the app.
2. Follow the on-screen menu to add, update, search, or remove licenses.

## Testing the Application

Run all unit tests with:
```sh
make test
```

---

## Troubleshooting

- If you see errors about missing classes or JARs, make sure you are in the `final_project` directory and have run `make all` first.
- If you modify any `.java` files, re-run `make all` to recompile.

---

## Learning Objectives

This project demonstrates:
- **Object-Oriented Programming**: Classes, encapsulation, inheritance
- **Data Structures**: ArrayList usage and management
- **User Input Handling**: Scanner class and input validation
- **Unit Testing**: JUnit framework and test-driven development
- **File Organization**: Proper separation of concerns
- **Documentation**: Clear code comments and README

# Wildlife Rescue Centre Management System

A Java desktop application that helps wildlife rescue centres manage animal records, rescuer information, and animal health status using an object-oriented design.

![Java](https://img.shields.io/badge/Java-OOP-orange)
![IDE](https://img.shields.io/badge/IntelliJ_IDEA-supported-blue)
![Type](https://img.shields.io/badge/Type-Desktop_Application-green)

---

## Table of Contents

- [Overview](#overview)
- [Problem Statement](#problem-statement)
- [Key Features](#key-features)
- [System Design](#system-design)
- [Class Relationships](#class-relationships)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [OOP Concepts Demonstrated](#oop-concepts-demonstrated)
- [Project Objectives](#project-objectives)
- [Future Improvements](#future-improvements)
- [Author](#author)
- [Disclaimer](#disclaimer)

---

## Overview

Wildlife rescue centres care for animals of many species, monitor their health, and coordinate the work of rescuers. Tracking all of this by hand becomes difficult as the number of animals and rescuers grows.

This system provides an organized, object-oriented way to maintain animal records, manage rescuers, and keep animal health information up to date.

## Problem Statement

Rescue centres commonly struggle with:

- **Animal tracking:** keeping accurate records of species, ages, health conditions, and enclosures
- **Rescuer management:** knowing which rescuer is responsible for which animals
- **Health monitoring:** updating health records as conditions change
- **Record organization:** keeping animal and rescuer information structured and easy to find

## Key Features

- Animal record management
- Rescuer registration and management
- Recording of species, age, health status, and enclosure
- Assigning rescued animals to rescuers
- Releasing animals from a rescuer's responsibility
- Updating animal health information
- Organized animal and rescuer records across the centre

## System Design

The application is built around three main classes.

### 1. `Animal`

Represents an individual animal in the centre.

| Attribute | Description |
|---|---|
| Species | The animal's species |
| Age | The animal's age |
| Health status | Current health condition |
| Enclosure | Where the animal is housed |

**Responsibilities:** store animal information, retrieve and update details, update health status.

### 2. `Rescuer`

Represents a person responsible for rescuing and caring for animals.

| Attribute | Description |
|---|---|
| Rescuer name | The rescuer's name |
| Rescuer ID | Unique identifier |
| Rescued animals | List of animals under their care |

**Responsibilities:** manage rescuer information, record rescued animals, rescue and release animals, maintain the rescuer-animal relationship.

### 3. `RescueCentre`

Manages the overall records of the centre.

**Responsibilities:** hold collections of animals and rescuers, add and remove animal records, add and remove rescuer records, organize information across the centre.

## Class Relationships

```text
RescueCentre
 ├── manages many ──> Animal
 └── manages many ──> Rescuer
                        └── is responsible for many ──> Animal
```

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core application development |
| Object-Oriented Programming | Application structure and class design |
| UML | System modelling and class design |
| IntelliJ IDEA | Development environment |

## Project Structure

```text
Wildlife-Management-System/
│
├── src/                  # Java source code
├── lib/                  # Project libraries
├── out/                  # Compiled output
├── .gitignore
├── ProjectFinal.iml
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- IntelliJ IDEA (recommended), or any Java IDE

### Run with IntelliJ IDEA

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/Wildlife-Management-System.git
   ```
2. Open IntelliJ IDEA and choose **File > Open**, then select the project folder (the `ProjectFinal.iml` file will be detected).
3. Make sure a JDK is set under **File > Project Structure > Project SDK**.
4. Open the class containing the `main` method in `src/` and click **Run**.

### Run from the command line

```bash
cd Wildlife-Management-System
javac -d out src/*.java
java -cp out Main
```

> Replace `Main` with the name of your actual entry-point class, and adjust the `javac` path if your sources are in packages.

## OOP Concepts Demonstrated

- **Encapsulation:** data and the methods that operate on it are grouped within classes
- **Classes and objects:** animals, rescuers, and the rescue centre are modelled as objects
- **Methods:** operations for managing records and updating information
- **Object relationships:** rescuers are linked to the animals under their care

## Project Objectives

- Improve organization of rescue centre records
- Simplify animal and rescuer management
- Make health information easy to update
- Reduce reliance on manually kept records
- Demonstrate practical use of Java and OOP

## Future Improvements

- Database integration for persistent storage
- Graphical user interface for easier navigation
- Adoption and release tracking
- Veterinary treatment and medical history records
- Reporting and analytics on animal populations
- User authentication and role-based access control

## Author

**Commence Goredema**
BSc (Hons) Information Technology, Chinhoyi University of Technology
Contact: cgoredemah@gmail.com

## Disclaimer

This project was developed as an academic software development project. The features described reflect the project's intended functionality and design.

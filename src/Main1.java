import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    private String species;
    private int age;
    private String healthStatus;
    private String enclosure;
    int animalId;

    public Animal(String species, int age, String healthStatus, String enclosure, int animalId) {
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.enclosure = enclosure;
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                ", enclosure='" + enclosure + '\'' +
                ", animalId=" + animalId +
                '}';
    }
}

class AnimalSystem {
    List<Animal> animals;

    public AnimalSystem() {
        animals = new ArrayList<>();
    }

    public void rescueAnimal(Animal animal) {
        animals.add(animal);
    }

    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }

    public Animal getAnimalById(int id) {
        for (Animal animal : animals) {
            if (animal.animalId == id) {
                return animal;
            }
        }
        return null;
    }
}

public class Main1 {
    private static final String URL = "jdbc:mysql://localhost:3306/animalRescue1"; // Replace "your_database_name" with your actual database name
    private static final String USERNAME = "root"; // Replace with your MySQL username (if different from the default)
    private static final String PASSWORD = ""; // Replace with your MySQL password (if applicable)

    private static Scanner scanner;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static AnimalSystem animalSystem;

    public static void main(String[] args) {
        animalSystem = new AnimalSystem();
        scanner = new Scanner(System.in);

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            boolean quit = false;
            while (!quit) {
                printMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addAnimal();
                        break;
                    case 2:
                        viewRecords();
                        break;
                    case 3:
                        deleteRecord();
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Animal Rescue Center Menu ===");
        System.out.println("1. Add a new animal");
        System.out.println("2. View records");
        System.out.println("3. Delete a record");
        System.out.println("4. Quit");
    }

    private static void addAnimal() throws SQLException {
        System.out.println("\n=== Adding a New Animal ===");

        System.out.print("Enter species: ");
        String species = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter health status: ");
        String healthStatus = scanner.nextLine();

        System.out.print("Enter enclosure: ");
        String enclosure = scanner.nextLine();

        System.out.print("Enter animal ID: ");
        int animalId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String insertAnimalQuery = "INSERT INTO animals (species, age, healthStatus, enclosure, animalId) VALUES (?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(insertAnimalQuery);
        preparedStatement.setString(1, species);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, healthStatus);
        preparedStatement.setString(4, enclosure);
        preparedStatement.setInt(5, animalId);
        preparedStatement.executeUpdate();

        Animal animal = new Animal(species, age, healthStatus, enclosure, animalId);
        animalSystem.rescueAnimal(animal);

        System.out.println("Animal added successfully!");
    }

    private static void viewRecords() throws SQLException {
        System.out.println("\n=== Animal Records ===");

        String selectAnimalsQuery = "SELECT * FROM animals";
        preparedStatement = connection.prepareStatement(selectAnimalsQuery);
        resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {
                String species = resultSet.getString("species");
                int age = resultSet.getInt("age");
                String healthStatus = resultSet.getString("healthStatus");
                String enclosure = resultSet.getString("enclosure");
                int animalId = resultSet.getInt("animalId");

                Animal animal = new Animal(species, age, healthStatus, enclosure, animalId);
                animalSystem.rescueAnimal(animal);

                System.out.println(animal);
            }

        if (animalSystem.animals.isEmpty()) {
            System.out.println("No records found.");
        }
    }

    private static void deleteRecord() throws SQLException {
        System.out.println("\n=== Deleting a Record ===");

        System.out.print("Enter animal ID: ");
        int animalId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Animal animal = animalSystem.getAnimalById(animalId);
        if (animal != null) {
            String deleteAnimalQuery = "DELETE FROM animals WHERE animalId = ?";
            preparedStatement = connection.prepareStatement(deleteAnimalQuery);
            preparedStatement.setInt(1, animalId);
            preparedStatement.executeUpdate();

            animalSystem.releaseAnimal(animal);

            System.out.println("Record deleted successfully!");
        } else {
            System.out.println("No record found with the specified animal ID.");
        }
    }

    private static void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
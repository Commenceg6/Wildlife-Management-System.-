import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}

class EmployeeSystem {
    private List<Employee> employees;

    public EmployeeSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}

class Main {
    private static Scanner scanner;
    private static EmployeeSystem employeeSystem;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        employeeSystem = new EmployeeSystem();

        boolean quit = false;
        while (!quit) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Employee Management System ===");
        System.out.println("1. Add an employee");
        System.out.println("2. View all employees");
        System.out.println("3. Remove an employee");
        System.out.println("4. Quit");
    }

    private static void addEmployee() {
        System.out.println("\n=== Adding an Employee ===");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        Employee employee = new Employee(name, age, department);
        employeeSystem.addEmployee(employee);

        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        System.out.println("\n=== Employee List ===");

        List<Employee> employees = employeeSystem.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void removeEmployee() {
        System.out.println("\n=== Removing an Employee ===");

        System.out.print("Enter the index of the employee to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Employee> employees = employeeSystem.getAllEmployees();


        if (index >= 0 && index < employees.size()) {
            Employee employee = employees.get(index);
            employeeSystem.removeEmployee(employee);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }
}
package com.application.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Employee;
import com.example.utils.MySqlConnection;
import com.training.daoimpl.EmployeeDaoImpl;
import com.training.ifaces.EmployeeDao;
public class Application {
	
    public static void main(String[] args) {

        try {
        	Connection conn = MySqlConnection.getMySqlConnection();
            EmployeeDao<Employee> dao = new EmployeeDaoImpl(conn);
            
            Scanner sc = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Employee Management");
                System.out.println("1. Add Employee");
                System.out.println("2. Find by First Name");
                System.out.println("3. Get First Name and Phone Number");
                System.out.println("4. Update Email and Phone Number");
                System.out.println("5. Delete by First Name");
                System.out.println("6. Find Employees by Birthday");
                System.out.println("7. Find Employees by Anniversary");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                case 1:
                    Employee emp = new Employee();
                    System.out.print("Employee ID: ");
                    emp.setEmployeeId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("First Name: ");
                    emp.setFirstName(sc.nextLine());
                    System.out.print("Last Name: ");
                    emp.setLastName(sc.nextLine());
                    System.out.print("House Number: ");
                    emp.setHouseNumber(sc.nextLine());
                    System.out.print("Street Name: ");
                    emp.setStreetName(sc.nextLine());
                    System.out.print("Area: ");
                    emp.setArea(sc.nextLine());
                    System.out.print("City: ");
                    emp.setCity(sc.nextLine());
                    System.out.print("Pin Code: ");
                    emp.setPinCode(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Email Address: ");
                    emp.setEmailAddress(sc.nextLine());
                    System.out.print("Phone Number: ");
                    emp.setPhoneNumber(sc.nextLong());
                    sc.nextLine();
                    System.out.print("Date of Birth (yyyy-mm-dd): ");
                    emp.setDateOfBirth(LocalDate.parse(sc.nextLine()));
                    System.out.print("Wedding Date (yyyy-mm-dd): ");
                    emp.setWeddingDate(LocalDate.parse(sc.nextLine()));

                    boolean added = dao.add(emp);
                    System.out.println(added ? "Employee added successfully" : "Failed to add employee");
                    break;


                    case 2:
                        System.out.print("Enter First Name to search: ");
                        String firstName = sc.nextLine();
                        List<Employee> byName = dao.findByFirstName(firstName);
                        byName.forEach(System.out::println);
                        break;

                    case 3:
                    	Map<String, Long> list = dao.getFirstNameAndPhoneNumber();
                    	for (Map.Entry<String, Long> entry : list.entrySet()) {
                    	    System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
                    	}
                    	break;

                    case 4:
                        System.out.print("Enter Employee ID to update: ");
                        int empId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Email: ");
                        String newEmail = sc.nextLine();
                        System.out.print("New Phone: ");
                        long newPhone = sc.nextLong();
                        boolean updated = dao.updateEmailAndPhone(empId, newEmail, newPhone);
                        System.out.println(updated ? "Updated successfully" : "Update failed");
                        break;

                    case 5:
                        System.out.print("Enter First Name to delete: ");
                        String nameToDelete = sc.nextLine();
                        boolean deleted = dao.deleteByFirstName(nameToDelete);
                        System.out.println(deleted ? "Deleted successfully" : "Delete failed");
                        break;

                    case 6:
                    	System.out.print("Enter Birthday (yyyy-mm-dd): ");
                    	LocalDate dob = LocalDate.parse(sc.nextLine());
                    	Map<String, String> birthdayMap = dao.findBirthdayEmployees(dob);

                    	for (Map.Entry<String, String> entry : birthdayMap.entrySet()) {
                    	    System.out.println(entry.getKey() + " - " + entry.getValue());
                    	}
                    	break;



                    case 7:
                    	LocalDate wedddingDate = LocalDate.parse(sc.nextLine());

                    	Map<String, Long> weddingMap = dao.findAnniversaryEmployees(wedddingDate);

                    	for (Map.Entry<String, Long> entry : weddingMap.entrySet()) {
                    	    System.out.println(entry.getKey() + " - " + entry.getValue());
                    	}
                    	break;

                    case 8:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
            sc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

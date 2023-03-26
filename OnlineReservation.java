import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Reservation System");
        System.out.println("Please enter your login credentials");

        // Login Form
        String username = "";
        String password = "";
        boolean isAuthenticated = false;
        do {
            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();
            isAuthenticated = authenticate(username, password);
            if (!isAuthenticated) {
                System.out.println("Invalid credentials. Please try again.");
            }
        } while (!isAuthenticated);
        System.out.println("Login successful.");

        // Main menu
        int choice;
        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Reservation Form");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Reservation Form
                    System.out.println("\nRESERVATION FORM");
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the train number: ");
                    String trainNumber = scanner.nextLine();
                    String trainName = getTrainName(trainNumber); // Get train name from database
                    System.out.print("Enter the class type: ");
                    String classType = scanner.nextLine();
                    System.out.print("Enter the date of journey (dd-mm-yyyy): ");
                    String dateOfJourney = scanner.nextLine();
                    System.out.print("Enter the source station: ");
                    String sourceStation = scanner.nextLine();
                    System.out.print("Enter the destination station: ");
                    String destinationStation = scanner.nextLine();
                    int pnr = reserveTicket(name, age, trainNumber, trainName, classType, dateOfJourney, sourceStation, destinationStation); // Insert ticket details into database
                    System.out.println("Ticket reserved successfully. Your PNR number is " + pnr);
                    break;

                case 2:
                    // Cancellation Form
                    System.out.println("\nCANCELLATION FORM");
                    System.out.print("Enter your PNR number: ");
                    int pnrNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    String[] ticketDetails = getTicketDetails(pnrNumber); // Get ticket details from database
                    if (ticketDetails == null) {
                        System.out.println("No ticket found with PNR number " + pnrNumber);
                    } else {
                        System.out.println("Ticket details:");
                        System.out.println("PNR number: " + ticketDetails[0]);
                        System.out.println("Passenger name: " + ticketDetails[1]);
                        System.out.println("Train number: " + ticketDetails[2]);
                        System.out.println("Train name: " + ticketDetails[3]);
                        System.out.println("Class type: " + ticketDetails[4]);
                        System.out.println("Date of journey: " + ticketDetails[5]);
                        System.out.println("Source station: " + ticketDetails[6]);
                        System.out.println("Destination station: " + ticketDetails[7]);
                        System.out.print("Do you want to cancel this ticket? (Y/N): ");
                        String confirmation = scanner.nextLine();
                        if (confirmation.equalsIgnoreCase("Y")){
                        cancelTicket(pnrNumber); // Delete ticket from database
                        System.out.println("Ticket with PNR number " + pnrNumber + " has been cancelled.");
                   } else {
                        System.out.println("Ticket has not been cancelled.");
                          }
                   }
                   break;
            case 3:
                // Exit
                System.out.println("\nThank you for using the Online Reservation System.");
                break;

            default:
                System.out.println("\nInvalid choice. Please try again.");
                break;
        }
    } while (choice != 3);

    scanner.close();
}

private static boolean authenticate(String username, String password) {
    // Check if the username and password are valid
    // Return true if valid, false otherwise
    // In this example, we are hardcoding the username and password for simplicity
    return username.equals("admin") && password.equals("admin123");
}

private static String getTrainName(String trainNumber) {
    // Query the database to get the train name for the given train number
    // In this example, we are returning a hardcoded value for simplicity
    return "Shatabdi Express";
}

private static int reserveTicket(String name, int age, String trainNumber, String trainName, String classType, String dateOfJourney, String sourceStation, String destinationStation) {
    // Insert the ticket details into the database and return the PNR number
    // In this example, we are generating a random PNR number for simplicity
    int pnrNumber = (int) (Math.random() * 100000);
    // In a real application, we would insert the ticket details into the database here
    return pnrNumber;
}

private static String[] getTicketDetails(int pnrNumber) {
    // Query the database to get the ticket details for the given PNR number
    // Return the ticket details as an array of strings
    // In this example, we are returning a hardcoded value for simplicity
    if (pnrNumber == 12345) {
        String[] ticketDetails = {"12345", "John Doe", "1234", "Shatabdi Express", "AC", "01-04-2023", "Delhi", "Mumbai"};
        return ticketDetails;
    } else {
        return null;
    }
}

private static void cancelTicket(int pnrNumber) {
    // Delete the ticket from the database for the given PNR number
    // In a real application, we would delete the ticket from the database here
}


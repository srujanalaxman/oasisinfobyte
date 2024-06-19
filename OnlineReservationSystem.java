import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OnlineReservationSystem {
    private static boolean[] seats = new boolean[10];
    private Map<String, String> users; // Store username-password pairs
    private Map<String, String> reservations; // Store reservation data
    
     OnlineReservationSystem() {
        users = new HashMap<>();
        reservations = new HashMap<>();
    }
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("----- WELCOME TO ONLINE RESERVATION SYSTEM -----");
            System.out.println("------------------------------------------------");
            System.out.println("Please Select One Options..." + "\n");
            System.out.println("1.>>> Register >>>");
            System.out.println("2.>>> Login >>>");
            System.out.println("3.>>> Exit >>>");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    register(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Exiting...");
                    System.out.println("\n" + "------------------------------------------------");
                    System.out.println("\n" + "Thank You.!!! Please Visit Again...");
                    System.out.println("\n" + "------------------------------------------------");
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Invalid choice... Please Try again...");
                    break;
            }
            
            System.out.println();
        }
    }
    
    private void register(Scanner sc) {
        System.out.println("------------------------------------------------");
        System.out.println("--------------- REGISTRATION PAGE --------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("\n" + "Username already exists... Try again...");
            return;
        }
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users.put(username, password);
        System.out.println("\n" + "Registration successful... You can now log in...");
    }
    
    private void login(Scanner sc) {
        System.out.println("------------------------------------------------");
        System.out.println("------------------ LOGIN PAGE ------------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("\n" + "Login successful...");
            reservationMenu(sc, username);
        } else {
            System.out.println("\n" + "Invalid username or password...");
        }
    }
    
    private void reservationMenu(Scanner sc, String username) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("------------------- HOME PAGE ------------------");
            System.out.println("------------------------------------------------");
            System.out.println("Please Select One Options..." + "\n");
            System.out.println("1.>>> View Seat Map >>>");
            System.out.println("2.>>> Make a reservation >>>");
            System.out.println("3.>>> Cancel a reservation >>>");
            System.out.println("4.>>> Logout");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    viewSeatMap();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Logging out...");
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Invalid choice. Try again.");
                    break;
            }
            
            System.out.println();
        }
    }
    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print an "X" if the seat is reserved
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
        }
        System.out.println();
    }
     private static void makeReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = sc.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }
    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation canceled!");
        }
    }
    public static void main(String[] args) {
        OnlineReservationSystem system = new OnlineReservationSystem();
        system.run();
    }
}

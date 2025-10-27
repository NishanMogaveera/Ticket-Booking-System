import java.util.Scanner;

class Ticket {
    String passengerName;
    String destination;
    int seatNumber;
    double price;

    // Constructor Overloading
    Ticket(String name, String dest, int seat, double price) {
        this.passengerName = name;
        this.destination = dest;
        this.seatNumber = seat;
        this.price = price;
    }
}

public class TicketBookingSystem {
    private static final int MAX_TICKETS = 10;
    private static Ticket[] tickets = new Ticket[MAX_TICKETS];
    private static int ticketCount = 0;
    private static int nextSeatNumber = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Book Ticket\n2. View Tickets\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                bookTicket(sc);
            } else if (choice == 2) {
                viewTickets();
            } else if (choice == 3) {
                System.out.println("Thank you for using our system!");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        sc.close();
    }

    private static void bookTicket(Scanner sc) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Sorry, no seats available!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        System.out.print("Enter destination: ");
        String dest = sc.nextLine();
        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        tickets[ticketCount] = new Ticket(name, dest, nextSeatNumber, price);
        ticketCount++;

        System.out.println("Ticket booked successfully! Passenger: " + name +
                ", Destination: " + dest +
                ", Seat: " + nextSeatNumber +
                ", Price: ₹" + price);
        nextSeatNumber++;
    }

    private static void viewTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets booked yet.");
            return;
        }
        System.out.println("\nBooked Tickets:");
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = tickets[i];
            System.out.println("Passenger: " + ticket.passengerName + ", Destination: " + ticket.destination + ", Seat: " + ticket.seatNumber + ", Price: ₹" + ticket.price);
        }
    }
}


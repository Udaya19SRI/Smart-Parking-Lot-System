import java.util.Scanner;

public class Airport {
    public static void main(String[] args) {
        System.out.println("\u001B[44m\tAIRPORT'S PARKING SYSTEM VACANCIES:\u001B[0m\n");

        int[][] array = {
            {1, 1, 0, 0, 1, 1, 0, 1, 1, 0},
            {0, 0, 1, 1, 0, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
            {0, 1, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 1, 0, 1, 0, 0, 1, 1, 1, 0}
        };

        Scanner scanner = new Scanner(System.in);

        for (int user = 1; user <= 10; user++) {
            System.out.println("\u001B[45m\t\tOptions\t\t\u001B[0m\n\t1. Book a new slot\n\t2. Exit\n");
            System.out.print("Choose one from above: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Start booking");
                    break;
                case 2:
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Please choose a valid option.");
                    continue;
            }

            System.out.print("User " + user + ": Enter the duration of parking the car (hours): ");
            int time = scanner.nextInt();
            int cnt = 0;

            System.out.println("\u001B[44m\tAIRPORT'S PARKING SYSTEM VACANCIES (Updated):\u001B[0m\n");

            // Display available slots
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    if (array[i][j] == 0) {
                        boolean isCorner = (i == 0 || i == 4 || j == 0 || j == 9);
                        if ((time <= 2 && isCorner) || time > 2) {
                            System.out.print("\u001B[42m(" + (i + 1) + " , " + (j + 1) + ")\u001B[0m ");
                            cnt++;
                        }
                    }
                }
                System.out.println();
            }

            if (time <= 2)
                System.out.println("\nTotal Number of Corner Efficient Vacancies: " + cnt);
            else
                System.out.println("\nTotal Number of Vacancies: " + cnt);

            System.out.print("User " + user + ": Choose the Desired Available Vacancy (row col): ");
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();

            if (array[p1 - 1][p2 - 1] == 0) {
                System.out.println("User " + user + ": Slot (" + p1 + "," + p2 + ") has been successfully Booked!");
                int charges = (time <= 2) ? time * 30 : time * 20;
                System.out.println("User " + user + ": Your charges for parking: " + charges);
                array[p1 - 1][p2 - 1] = 1;
                System.out.println("Thank You!!");
            } else {
                System.out.println("User " + user + ": Invalid Parking Slot Entered.");
            }

            try {
                Thread.sleep(2000); // Pause for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}

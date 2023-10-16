import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        String again = "y";

        do {
            boolean lostInit = false;
            boolean wonInit = false;
            boolean wonPoint = false;
            boolean lostPoint = false;

            System.out.println("Rolling Dice!");
            int dice1 = rnd.nextInt(6) + 1;
            int dice2 = rnd.nextInt(6) + 1;
            int sum = dice1 + dice2;
            System.out.println("Dice One rolled: " + dice1 + ".");
            System.out.println("Dice Two rolled: " + dice2 + ".");
            System.out.println("Sum is: " + sum + ".");

            if (sum == 2 || sum == 3 || sum == 12) {
                lostInit = true;
            } else if (sum == 7 || sum == 11) {
                wonInit = true;
            } else {
                int point = sum;
                System.out.println("Point is set at " + point + ". Re rolling!");

                do {
                    dice1 = rnd.nextInt(6) + 1;
                    dice2 = rnd.nextInt(6) + 1;
                    sum = dice1 + dice2;
                    System.out.println("Dice One rolled: " + dice1 + ".");
                    System.out.println("Dice Two rolled: " + dice2 + ".");
                    System.out.println("New sum is " + sum + ".");

                    if (sum == point) {
                        wonPoint = true;
                    } else if (sum == 7) {
                        lostInit = true;
                        lostPoint = true;
                    }

                } while (sum != point && sum != 7);
            }

            if (lostInit) {
                if (lostPoint) {
                    System.out.println("Lost Point, you lose!");
                } else {
                    System.out.println("Crapped out! You lose");
                }
            }

            if (wonInit) {
                if (wonPoint) {
                    System.out.println("Won Point!");
                } else {
                    System.out.println("You won!");
                }
            }

            System.out.println("Do you want to play again? [y/n]");
            again = in.next();
        } while (again.equals("y"));

        System.out.println("Goodbye!");
    }
}

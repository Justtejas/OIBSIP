import java.util.Scanner;
import java.io.*;
public class NumberGuessing {
        public static void guessTheNumber() {
            Scanner sc = new Scanner(System.in);
            int num = 1 + (int) (100 * Math.random());
            int rounds = 5;
            int guess, i, again, score = 0;

            System.out.println("Welcome to Game");
            System.out.println("Input any number between 1 - 100 ");

            for (i = 0; i < 5; i++) {
                System.out.print("Enter your guess : ");
                guess = sc.nextInt();

                if (guess > 100 || guess < 0) {
                    System.out.println("Please enter a number between 1 and 100");
                } else if (guess == num) {
                    System.out.println("Congrats!! You've guessed the right number!");
                    score += 10;
                    System.out.println("Your score out of 10 is " + score);
                } else if (guess > num && i != rounds - 1) {
                    System.out.println("The number is less than " + guess);
                } else if (guess < num && i != rounds - 1) {
                    System.out.println("The number is greater than " + guess);
                }
            }

            if (rounds == i) {
                System.out.println("You've completed " + i + " round");
                System.out.println("The Number is " + num);
                System.out.println("Enter 1 to continue or Enter 0 to exit: ");
                again = sc.nextInt();
                if (again == 1) {
                    guessTheNumber();
                } else if(again == 0){
                    System.out.println("Thanks for playing!!");
                }
            }
            sc.close();
        }
        public static void main(String args[]) {
            guessTheNumber();
        }
}


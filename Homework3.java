import java.util.*;
public class Homework3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Enter a year to see if it is a leap year. Enter -1 to quit: ");
            int year = sc.nextInt();
            if (year >= 1582 && year % 4 == 0 ){
                if (year % 100 == 0 && year % 400 != 0){
                    System.out.println("The year " + year + " is not a leap year");
                }
                 else {System.out.println("The year " + year + " is a leap year");}
                }
            else if (year == -1){
                System.out.println("Bye");
                break;
            }
            else if (year < 1582){
                System.out.println("Enter a year greater than 1582. Try Again");
            }
            else {
                System.out.println("The year " + year + " is not a leap year");
            }
        }
        int option = 1;
        while (option == 1){
            int number = (int)(Math.random() * 100) + 1;
            int counter = 0;
            while (true){
                System.out.println("Guess a number: ");
                int guess = sc.nextInt();
                if (guess > number){
                    System.out.println("Guess is too high");
                    counter ++;
                }
                else if (guess < number){
                    System.out.println("Guess is too low");
                    counter ++;
                }
                else if (guess == number) {
                    counter ++;
                    System.out.println("You guessed correctly in " + counter + " guesses.");
                    break;
                }
            }
            System.out.println("Enter 1 to play again. Press 2 to quit");
            option = sc.nextInt();
        }

        int range = 0;
        int sum = 0;
        while (range < 1000){
            if (range % 3 == 0 || range % 5 == 0){
                sum += range;
            }
            range ++;
        }
        System.out.println("The sum of the multiples of 3 and 5 below 1000 is: " + sum);

    }
}

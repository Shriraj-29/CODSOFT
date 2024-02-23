import java.util.Scanner;
import java.util.Random;

public class Codsoft_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated.");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += attemptsLimit - attempts;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Your final score is: " + score);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

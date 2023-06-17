import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int startRange = 1;
        int endRange = 100;
        int score = 0;
        int rounds = 3;
        int maxAttempts = 5;
     System.out.println("----------------------------------");
        System.out.println("Welcome to 'GUESS THE NUMBER' Game");

        System.out.println("----------------------------------");
System.out.println("INSTRUCTIONS");
System.out.println("----------------------------------");
        System.out.println("* Select a number from " + startRange + " to " + endRange);
        System.out.println("* You have total " + rounds + " rounds to play");
        System.out.println("* Each round will have 5 attempts");
        System.out.println("----------------------------------\n");
                System.out.println("Let's start! \n");
        for (int round = 1; round<= rounds; round++) {

            int targetNumber = random.nextInt(endRange-startRange  + 1) + startRange;
                   

                System.out.println("-> Round Number: " + round+"\n");
           int attempts = 0;
        
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.println("-> Attempts : " +  (attempts + 1));

                System.out.println("\nGuess the number!");
                int guess = scanner.nextInt();
                if (guess == targetNumber) {
                    guessedCorrectly = true;
                 
                    int roundScore = maxAttempts -attempts;
                    score += roundScore;
                       System.out.println("\nCongratulations you guessed right number!");
                    System.out.println("Round Score: " + roundScore);
                    break;

                } else if (guess < targetNumber) {
                    System.out.println("\n Number is higher \n");
                } else {
                    System.out.println("\n Number is lower\n ");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Round " + round+ " over");
                System.out.println("\nYou lost with score 0");
            }

            System.out.println("----------------------------------");
        }
        System.out.println("Game Over!");
        System.out.println("Total Score is " + score);
      System.out.println("----------------------------------");
    }

}
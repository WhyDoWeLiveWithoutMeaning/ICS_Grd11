package eric.projects.RPS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BetterRockPaperScissors {
    public static Scanner in = new Scanner(System.in);
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSOR = 3;

    public static int userScore = 0;
    public static int compScore = 0;

    public static void main(String[] args) {
        System.out.print("How many round do you want to play?: ");
        ArrayList<Integer> userPlays = new ArrayList<Integer>();
        int rounds = in.nextInt();
        for (int i = 0; i < rounds; i++) {
            int userChoice, compChoice;

            userChoice = userChoice();

            userPlays.add(userChoice);

            compChoice = compChoice(userPlays);

            printResult(userChoice, compChoice);
        }

        printFinal();
    }

    public static void printResult(int userChoice, int compChoice) {
        if (userChoice == compChoice) {
            System.out.println("It's a tie.");
            System.out.printf("User Score: %d, Comp Score: %d\n\n", userScore, compScore);
            return;
        }
        if (userChoice == ROCK) {
            if (compChoice == PAPER) {
                System.out.println("Sorry, You Lost. Your opponent chose Paper");
                compScore++;
            } else {
                System.out.println("Yay, you won! Your opponent chose Scissor");
                userScore++;
            }
        } else if (userChoice == PAPER) {
            if (compChoice == SCISSOR) {
                System.out.println("Sorry, You Lost. Your opponent chose Scissor");
                compScore++;
            } else {
                System.out.println("Yay, you won! Your opponent chose Rock");
                userScore++;
            }
        } else {
            if (compChoice == ROCK) {
                System.out.println("Sorry, You Lost. Your opponent chose Rock");
                compScore++;
            } else {
                System.out.println("Yay, you won! Your opponent chose Paper");
                userScore++;
            }
        }
        System.out.printf("User Score: %d, Comp Score: %d\n\n", userScore, compScore);
    }

    public static void printFinal() {
        if (userScore == compScore) {
            System.out.println("It ended in a tie.");
        } else if (userScore > compScore) {
            System.out.printf("You beat the computer by %d points. Amazing!", userScore - compScore);
        } else {
            System.out.printf("the computer beat You by %d points. Bummer ;-;", compScore - userScore);
        }
    }

    public static int userChoice() {
        do {
            System.out.print("Enter Rock, Paper or Scissor: ");
            String choice = in.next();

            if (choice.equalsIgnoreCase("rock")) return ROCK;
            else if (choice.equalsIgnoreCase("paper")) return PAPER;
            else if (choice.equalsIgnoreCase("scissor")) return SCISSOR;

            System.out.println("Please enter a valid choice.");
        } while (true);
    }

    public static int compChoice(ArrayList<Integer> userPlays) {
        if (userPlays.size() < 3)
            return (int) (Math.random() * 3 + 1);
        switch(mode(userPlays)){
            case 1: return 2;
            case 2: return 3;
            case 3: return 1;
        }
        return 1;
    }

    public static int mode(ArrayList<Integer> n) {
        Collections.sort(n);

        int count2 = 0;
        int count1 = 0;
        int popular1 = 0;
        int popular2 = 0;


        for (int i = 0; i < n.size(); i++) {
            popular1 = n.get(i);
            count1 = 0;

            for (int j = i + 1; j < n.size(); j++) {
                if (popular1 == n.get(j)) count1++;
            }

            if (count1 > count2) {
                popular2 = popular1;
                count2 = count1;
            } else if (count1 == count2) {
                popular2 = Math.min(popular2, popular1);
            }
        }
        return popular2;
    }
}

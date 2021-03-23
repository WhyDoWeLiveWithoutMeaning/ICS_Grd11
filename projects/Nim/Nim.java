package eric.projects.Nim;
/**
 * This is the nim program assignment.
 *
 * @author Eric Beaulne
 * @since 2021-03-17
 */

import java.util.Scanner;

public class Nim {
    //Input
    static Scanner in = new Scanner(System.in);

    //Piles
    static int pileOne;
    static int pileTwo;
    static int pileThree;
    static int pileFour;

    //User Scores
    static int playerOne = 0;
    static int playerTwo = 0;

    public static void main(String[] args){

        //Whether the player will play again or not.
        boolean playAgain = false;

        //Amount of times they want to play
        do{
            printSpaces(20);

            //Assign the piles random number of sticks
            initiatePiles();

            //Keeps track of the last player who played
            int turn = 0;

            //Amount of times it takes till all piles are empty and someone loses.
            do{
                //Prompt user 1
                promptUser("Player 1");
                turn = 0;

                printSpaces(20);
                if (pilesEmpty()) break;

                //Prompt user 2
                promptUser("Player 2");
                turn = 1;

                printSpaces(20);

            } while(!pilesEmpty());

            printMatchResults(turn);

            playAgain = playAgain();

        } while (playAgain);

        printResults();
    }

    //print an inputed amount of spaces
    public static void printSpaces(int amount){
        while (amount-->0) System.out.println();
    }

    //Print the result after every round
    public static void printMatchResults(int user){
        if (user == 0){
            System.out.println("Congrats Player 2, You won :)");
            playerTwo++;
        } else if (user == 1){
            System.out.println("Congrats Player 1, You won :)");
            playerOne++;
        }
        printScores();
        printSpaces(3);
    }

    //prompts user if they want to play again.
    public static boolean playAgain(){
        System.out.print("Play again (Y/N): ");
        char input = in.next().charAt(0);
        if (input == 'Y' || input == 'y') return true;
        else if (input == 'N' || input == 'n') return false;
        System.out.println("Unknown Character, Defaulting to N");
        return false;
    }

    //Method that prints the Players Scores
    public static void printScores(){
        printSpaces(2);
        System.out.printf("Player 1: %d\n", playerOne);
        System.out.printf("Player 2: %d\n", playerTwo);
    }

    //checks if the piles are all empty
    public static boolean pilesEmpty(){
        return pileOne == 0 && pileTwo == 0 && pileThree == 0 && pileFour == 0;
    }

    //Asks the user the required information to play the game
    public static void promptUser(String userName){
        int pile = 0;

        //repeat until accepted value is entered
        do {
            printPiles();
            System.out.print(userName + " Pick a pile: ");
            pile = in.nextInt();
            if (!validPile(pile)) {
                printSpaces(2);
                System.out.println("I am sorry but you cannot chose this pile.");
                printSpaces(2);
            }
        } while (!validPile(pile));

        int amount = 0;

        //repeat until accepted value is entered
        do{
            System.out.print(userName + " Pick a number of sticks to take(1-3): ");
            amount = in.nextInt();
            if (!validAmount(pile, amount)) {
                printSpaces(2);
                System.out.println("I am sorry but you cannot take this much from the pile.");
                printSpaces(2);
            }
        } while(!validAmount(pile, amount));

        updatePile(pile, amount);
    }

    //Subtracts the amount taken from whichever pile
    public static void updatePile(int pile, int amount){
        if (pile == 1){
            pileOne -= amount;
        } else if (pile == 2){
            pileTwo -= amount;
        } else if (pile == 3){
            pileThree -= amount;
        } else if (pile == 4){
            pileFour -= amount;
        }
    }

    //Checks whether the pile chosen is a valid pile that can be chosen.
    public static boolean validPile(int pileChosen){
        if(pileChosen < 1 || pileChosen > 4){
            return false;
        }

        //returns whether the pile chosen is empty or not.
        switch(pileChosen) {
            case 1:
                return pileOne != 0 ? true : false;
            case 2:
                return pileTwo != 0 ? true : false;
            case 3:
                return pileThree != 0 ? true : false;
            case 4:
                return pileFour != 0 ? true : false;
        }

        return false;
    }

    //gets the amount in a pile from the pile number
    public static int pileFromPile(int pileNumber){
        switch(pileNumber) {
            case 1:
                return pileOne;
            case 2:
                return pileTwo;
            case 3:
                return pileThree;
            case 4:
                return pileFour;
        }
        return 0;
    }

    //Checks if the amount taken from a pile is valid and the pile has enough to be taken.
    public static boolean validAmount(int pile, int amount){
        if(amount <= 3 && amount >= 1 && amount <= pileFromPile(pile)) return true;
        return false;
    }

    //Assigns the piles with a random amount of sticks from 4-8 inclusive.
    public static void initiatePiles(){
        pileOne = (int) (Math.random() * 5 + 4);
        pileTwo = (int) (Math.random() * 5 + 4);
        pileThree = (int) (Math.random() * 5 + 4);
        pileFour = (int) (Math.random() * 5 + 4);
    }

    //Pretty Print the Piles
    public static void printPiles(){
        System.out.print("Pile 1: ");
        for (int i = 0; i < pileOne; i++) System.out.print("|");
        System.out.println();

        System.out.print("Pile 2: ");
        for (int i = 0; i < pileTwo; i++) System.out.print("|");
        System.out.println();

        System.out.print("Pile 3: ");
        for (int i = 0; i < pileThree; i++) System.out.print("|");
        System.out.println();

        System.out.print("Pile 4: ");
        for (int i = 0; i < pileFour; i++) System.out.print("|");
        System.out.println();
    }

    //Print the final result after the game is complete
    public static void printResults(){
        System.out.println();
        if (playerOne == playerTwo){
            System.out.printf("It's a tie, Both players got %d", playerOne);
        } else if (playerOne > playerTwo){
            System.out.printf("Congrat Player One on beating Player Two by %d point(s)", playerOne-playerTwo);
        } else {
            System.out.printf("Congrat Player Two on beating Player One by %d point(s)", playerTwo-playerOne);
        }
    }
}

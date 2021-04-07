package eric.projects.Bingo;
/**
 * This code returns random bingo numbers
 * must press enter to get the next ball.
 * It also shows a board with the previous Balls that were called.
 *
 * @author Eric Beaulne
 */

import java.util.Scanner;

public class BingoAssignment {

    //Define Input
    static Scanner pause = new Scanner(System.in);

    public static void main(String[] args){

        //Variable for whether they want to play again or not.
        boolean playAgain = false;

        System.out.println("BINGO!!!");
        printSpaces(3);

        //loop for new game.
        do {

            //Define Bingo numbers
            int[] bingoNumbers = bingoNumbers();

            int[][] calledNumbers = {{},{},{},{},{}};

            //Loop through all the balls.
            for (int i = 0; i < 75; i++) {

                if (i != 0)
                    printSpaces(30);

                //Get random number from list
                int number = randomFromList(bingoNumbers);

                //Remove number chosen from the list and make it the new list.
                bingoNumbers = removeNumber(bingoNumbers, number);

                //Call Previous Numbers
                printBoard(calledNumbers);

                //Add number to 2-D Array
                int calledNumberIndex = indexFromNumber(number);

                calledNumbers[calledNumberIndex] = addElement(calledNumbers[calledNumberIndex], number);

                //Output results.
                System.out.printf("Current Ball: %s%d\n", letterFromNumber(number), number);

                //Wait until enter is pressed
                pause.nextLine();
            }

            //Ask to play Again
            playAgain = playAgain();

        } while (playAgain);
    }

    //Returns the array index from the range of numbers.
    public static int indexFromNumber(int number){
        if(number >= 1 && number <= 15) return 0;
        else if (number >= 16 && number <= 30) return 1;
        else if (number >= 31 && number <= 45) return 2;
        else if (number >= 46 && number <= 60) return 3;
        else if (number >= 61 && number <= 75) return 4;
        return 0;
    }

    //Prints spaces.
    public static void printSpaces(int spaces){
        while(spaces-->0) System.out.println();
    }


    //Print the array into the board with the previous numbers called.
    public static void printBoard(int[][] arr){
        System.out.println("************** Previous Numbers **************");
        for (int i = 0; i < arr.length; i++){
            System.out.printf("%s: ", letterFromIndexNumber(i));
            for(int j = 0; j < arr[i].length; j++){
                System.out.printf("%s%d ",letterFromIndexNumber(i), arr[i][j]);
            }
            System.out.println();
        }
        printSpaces(3);
    }

    //Return the letter from BINGO from the array index.
    public static char letterFromIndexNumber(int n){
        switch(n){
            case 0: return 'B';
            case 1: return 'I';
            case 2: return 'N';
            case 3: return 'G';
            case 4: return 'O';
        }
        return ' ';
    }

    //Add an element to an array and return the new array.
    public static int[] addElement(int[] arr, int element){
        int[] newArr = new int[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[arr.length] = element;
        return newArr;
    }

    //Prompts the user asking whether they want to play another round.
    public static boolean playAgain(){
        System.out.print("Play again (Y/N): ");

        char input = pause.next().charAt(0);

        if (input == 'Y' || input == 'y') return true;
        else if (input == 'N' || input == 'n') return false;

        System.out.println("Unknown Character, Defaulting to N");

        return false;
    }

    //Creates an initial array with all bingo numbers.
    public static int[] bingoNumbers(){
        int[] bingoNumbers = new int[75];
        for(int i = 0; i < 75; i++){
            bingoNumbers[i] = i+1;
        }
        return bingoNumbers;
    }

    //Returns the letter connected with the number in Bingo
    public static char letterFromNumber(int number){
        if(number >= 1 && number <= 15) return 'B';
        else if (number >= 16 && number <= 30) return 'I';
        else if (number >= 31 && number <= 45) return 'N';
        else if (number >= 46 && number <= 60) return 'G';
        else if (number >= 61 && number <= 75) return 'O';
        return ' ';
    }

    //Returns a random number from the array given.
    public static int randomFromList(int[] arr){
        return arr[(int) (Math.random() * arr.length)];
    }

    /*
    returns an array without the number chosen to be removed
    (This method only works if the number there is at most 1 of the number wanted to be removed.)
     */
    public static int[] removeNumber(int[] arr, int num){

        int[] newArr = new int[arr.length-1];

        int i = 0;

        for(int j = 0; j < newArr.length; j++){

            if (arr[i] == num) {
                i++;
            }

            newArr[j] = arr[i];

            i++;
        }
        return newArr;
    }
}

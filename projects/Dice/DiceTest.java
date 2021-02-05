package eric.projects.Dice;

import java.util.Scanner;
import eric.projects.Dice.Dice;

import static eric.projects.Dice.Dice.roll;

public class DiceTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter \"r\" to roll: ");
            String inputedValue = in.next().toLowerCase();

            if (inputedValue.length() > 1){
                System.out.println("Please enter a character!");
                continue;
            }

            char letter = inputedValue.charAt(0);

            if (letter == 'r') {
                int usersRoll = roll(3);
                int computerRoll = roll(3);

                if (usersRoll > computerRoll) {
                    System.out.println(String.format("Congratulations you won by %d.", usersRoll - computerRoll));
                } else if (usersRoll == computerRoll) {
                    System.out.println("It's a tie.");
                } else {
                    System.out.println(String.format("I'm Sorry. You lost by %d.", computerRoll - usersRoll));
                }

                System.out.println();
            }
        }
    }
}

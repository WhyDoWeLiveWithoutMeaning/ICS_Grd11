package eric.projects.QuizAssignment;

/**
 * This quiz program is to test my ability to use all
 * the knowledge of programming I've learned so far in this class.
 *
 * @author Eric Beaulne
 * @dateCreated 2021-02-25
 * @dateRevised 2021-02-26
 */

import java.util.Scanner;

public class QuizAssignment {
    public static void main(String[] args){
        //Define Scanner
        Scanner input = new Scanner(System.in);

        //Variables
        boolean repeat = false;

        //Do While until the user doesn't want to do the quiz again.
        do{
            //Local Variable as to reset each loop
            int correctAnswers = 0;

            //Question 1
            System.out.print("When did the Three Kingdoms War start? [Integer Required]: ");
            int kingdomsWarInput = input.nextInt();

            /**Answer received from Wikipedia
             * https://en.wikipedia.org/wiki/Wars_of_the_Three_Kingdoms
             */
            if (kingdomsWarInput == 1639){
                correctAnswers++;
                System.out.println("You got it right it was 1639");
            } else {
                System.out.println("Sorry, The correct answer was 1639");
            }
            System.out.println();

            //Question 2
            System.out.print("What animal can survive almost anything and stop its metabolism? [1 Word Required]: ");
            String tardigradeInput = input.next();

            /**Answer received from
             * https://en.wikipedia.org/wiki/Tardigrade
             */
            if (tardigradeInput.equalsIgnoreCase("tardigrade")){
                correctAnswers++;
                System.out.println("You got it right it was Tardigrade");
            } else {
                System.out.println("Sorry, The correct answer was Tardigrade");
            }
            System.out.println();

            //Question 3
            System.out.print("What are the first 7 digits of pi? [Double Required]: ");
            double pi = input.nextDouble();

            /**Answer received from
             * https://www.piday.org/million/
             */

            if (pi == 3.141592){
                correctAnswers++;
                System.out.println("You got it right, It was 3.141592");
            } else {
                System.out.println("Sorry, The correct answer was 3.141592");
            }
            System.out.println();

            //Question 4
            System.out.print("true or false? The Perseverance Rover will be testing new oxygen generation methods? [Boolean Required]: ");
            boolean oxygenInput = input.nextBoolean();

            /**Answer received from
             * https://newatlas.com/space/perseverance-rover-oxygen-mars-atmosphere/
             */
            if(oxygenInput){
                correctAnswers++;
                System.out.println("You got it right its true");
            } else {
                System.out.println("Sorry, The correct answer is true");
            }
            System.out.println();

            //Question 5
            System.out.print("How many bones are in the Adult Human Body? [Integer Required]: ");
            int bonesInput = input.nextInt();

            /**Answer received from
             * https://sciencing.com/many-bones-body-5438174.html
             */

            if (bonesInput == 206){
                correctAnswers++;
                System.out.println("You got it right its 206");
            } else {
                System.out.println("Sorry, The correct answer is 206");
            }

            System.out.println(String.format("You got %d/5 answers correct. That is a %d", correctAnswers, (int) ((correctAnswers/5.0)*100)) + "%");
            System.out.print("Do you want to take the test again? [Boolean Required]: ");
            repeat = input.nextBoolean();
            System.out.println();

        } while(repeat);
    }
}

package eric.projects.ProblemSet;

import java.util.Scanner;

public class SetThree {
    public static void main(String[] args){
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();
        q7();
    }

    public static void q1(){
        Scanner in = new Scanner(System.in);

        int n;
        do{
            System.out.print("Enter a Number: ");
            n = in.nextInt();
        } while(n != 0);

        System.out.println("You finally entered 0");
    }

    public static void q2(){
        Scanner in = new Scanner(System.in);

        int guessedNumber = 0,  guesses = 0, randomNumber = (int) (Math.random() * 10 + 1);

        do {
            System.out.print("Guess a Number between 1 and 10: ");
            guessedNumber = in.nextInt();
            if(guessedNumber > randomNumber)
                System.out.println("Too High");
            else if (guessedNumber < randomNumber)
                System.out.println("Too Low");
            guesses++;
        } while(guessedNumber != randomNumber);

        System.out.println(String.format("You guessed correctly! :) | The Number was: %d | It took you %d Guess(es)", randomNumber, guesses));
    }

    public static void q3(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();

        for(int i=0;i<=n;i++){
            System.out.print(i + " ");
        }
    }

    public static void q4(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int t=0, n = in.nextInt();

        for(int i=0;i<=n;i++){
            t += i;
        }
        System.out.println(t);
    }

    public static void q5(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int t=0, n = in.nextInt();

        while(n != 0) {
            t += n % 10;
            n /= 10;
        }

        System.out.println(t);
    }

    public static void q6(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a race length: ");
        int x = in.nextInt();

        int tort = 0, hare = 0, time = 0;
        boolean tortAhead = false;

        do{
            System.out.println(String.format("Time: %d, Tort: %d, Hare: %d", time, tort, hare));
            int randTort = (int) (Math.random() * 10 + 1);
            int randHare = (int) (Math.random() * 10 + 1);

            if (randTort <= 5){
                tort += 3;
            } else if (randTort <= 7){
                tort -= 6;
            } else {
                tort += 1;
            }

            if (randHare <= 2){
                hare += 9;
            } else if (randHare <= 3){
                hare -= 12;
            } else if (randHare <=6){
                tort += 1;
            } else if (randHare <=8){
                tort -= 2;
            }

            if (tort > hare && !tortAhead){
                System.out.println(String.format("At TC %d The Tortoise Has Passed the Hare.", time));
                tortAhead = !tortAhead;
            } else if (hare > tort && tortAhead){
                System.out.println(String.format("At TC %d The Hare Has Passed the Tortoise.", time));
                tortAhead = !tortAhead;
            }

            time++;
        } while (tort < x && hare < x);

        if (tort > hare){
            System.out.println(String.format("The Tortoise has won the race in %d TC", time));
        } else if (tort < hare){
            System.out.println(String.format("The Hare has won the race in %d TC", time));
        } else {
            System.out.println(String.format("The race was a tie in %d TC", time));
        }

    }

    public static void q7(){
        Scanner in = new Scanner(System.in);
        int t, s, h;

        System.out.print("Enter the Trident Tine Height: ");
        t = in.nextInt();

        System.out.print("Enter the Trident Tine Spaces: ");
        s = in.nextInt();

        System.out.print("Enter the Trident Handle Height: ");
        h = in.nextInt();

        for(int i = 0; i < t; i++){
            System.out.print("*");
            for(int j = 0; j < s; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0; j < s; j++){
                System.out.print(" ");
            }
            System.out.println("*");
            System.out.println();
        }
        for(int i = 0; i < s*2+3; i++)
            System.out.print("*");
        System.out.println();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < s+1; j++){
                System.out.print(" ");
            }
            System.out.println("*");
            System.out.println();
        }
    }
}

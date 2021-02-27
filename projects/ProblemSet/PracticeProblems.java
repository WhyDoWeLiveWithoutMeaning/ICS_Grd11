package eric.projects.ProblemSet;

import java.util.Scanner;

public class PracticeProblem1 {
    public static void main(String[] args){
        q1();
        q2();
        q3();
        q4();
        q5();
    }

    public static void q1(){
        int i = 10;
        while(i <= 100){
            System.out.println(i);
            i+=10;
        }
    }

    public static void q2(){
        for(int i = 10; i <= 100; i += 10){
            System.out.println(i);
        }
    }

    public static void q3(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char input = in.next().toLowerCase().charAt(0);

        if(input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u'){
            System.out.println("Vowel");
        } else
            System.out.println("Consonant");
    }

    public static void q4(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of terms: ");
        int input = in.nextInt();

        for(int i = 1 ; i <= input; i++){
            System.out.println(String.format("Number is: %d and the cube of %d is: %d", i, i, (int) Math.pow(i, 3)));
        }
    }

    public static void q5(){
        Scanner in = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("Enter command: ");
            input = in.next();
        } while (!input.equalsIgnoreCase("quit"));
        System.out.println("Program exited");
    }
}

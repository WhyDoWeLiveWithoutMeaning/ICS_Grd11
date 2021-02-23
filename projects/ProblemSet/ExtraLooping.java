package eric.projects.ProblemSet;

import java.util.Scanner;

public class ExtraLooping {
    public static void main(String[] args){
        q2();
    }

    public static void q1(){
        System.out.println("x\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
        for(int i = 1; i < 11; i++){
            System.out.print(i+"\t");
            for (int j = 1; j < 11; j++){
                System.out.print(i*j + "\t");
            }
            System.out.println();
        }
    }

    public static void q2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int even =0, odd=0, zer=0;

        while (n != 0){
            int temp = n % 10;
            if (temp == 0) zer++;
            else if (temp % 2 == 0) even++;
            else odd++;
            n /= 10;
        }
        System.out.println(String.format("Number of 0's: %d",zer));
        System.out.println(String.format("Number of evens: %d", even));
        System.out.println(String.format("Number of odds: %d", odd));
    }

    public static void q3(){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int factors = 0;

        for (int i = 1; i < (int) number/2; i++){
            if (number % i == 0){
                factors++;
            }
        }
        if (factors == 1){
            System.out.println("It is a Prime Number");
        } else {
            System.out.println("It is not Prime");
        }
    }
}

package eric.projects.ProblemSet;

import java.text.NumberFormat;
import java.util.Scanner;

public class SetOne {

    public static void main(String[] args){
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();
    }

    public static void q1(){
        Scanner in = new Scanner(System.in);

        double total = 0;

        for (int i = 0; i < 3; i++){
            System.out.print(String.format("Enter the %d Number: ", i+1));
            total += in.nextDouble();
        }

        System.out.println(String.format("The Average of all the number is %f", total/3));
    }

    public static void q2(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Miles: ");
        double miles = in.nextDouble();

        System.out.println(String.format("%.2f from Miles to Kilometers is %.2f", miles, miles*1.60935));
    }

    public static void q3(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a Number of Hours: ");
        double userHours = in.nextDouble();

        int days = (int) Math.floor(userHours / 24);
        double hours = userHours % 24;

        System.out.println(String.format("%.2f Hours is equal to %d Days and %.2f Hours", userHours, days, hours));
    }

    public static void q4(){
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.print("Enter the number of cookies baked: ");
        int numberOfCookies = in.nextInt();

        int boxes = (int) Math.ceil(numberOfCookies / 12);

        int cartons = (int) Math.ceil(boxes / 24);

        int leftOverBoxes = boxes - (cartons * 24);

        System.out.println(((boxes - leftOverBoxes) * 12));

        int leftOverCookies = numberOfCookies - (boxes * 12);

        double profit = ((boxes - leftOverBoxes) * 1.14) + (leftOverBoxes * 0.57);

        System.out.println(String.format("If %d Cookies were baked you would end up with:", numberOfCookies));
        System.out.println();
        System.out.println(String.format("Cartons: %d", cartons));
        System.out.println(String.format("leftover boxes: %d", leftOverBoxes));
        System.out.println(String.format("leftover cookies: %d", leftOverCookies));
        System.out.println(String.format("profit: %s", currency.format(profit)));

    }

    public static void q5(){

        String finalCombination = "";

        for (int i = 0; i < 3; i++){
            finalCombination = finalCombination + (int) (( Math.random() * 61) - 1) + " ";
        }

        System.out.println(String.format("Your lock combination is %s", finalCombination));

    }

    public static void q6() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first Points X Coordinate: ");
        double x1 = in.nextDouble();

        System.out.print("Enter the first Points Y Coordinate: ");
        double y1 = in.nextDouble();

        System.out.print("Enter the second Points X Coordinate: ");
        double x2 = in.nextDouble();

        System.out.print("Enter the second Points Y Coordinate: ");
        double y2 = in.nextDouble();

        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        System.out.println(String.format("The distance between (%.2f, %.2f) and (%.2f, %.2f) is %.8f", x1, y1, x2, y2, distance));
    }
}

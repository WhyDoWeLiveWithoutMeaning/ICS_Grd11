/**
 * This is the Second Problem Set.
 *
 * @Author Eric
 * 2021/02/11
 */

package eric.projects.ProblemSet;

import java.text.NumberFormat;
import java.util.Scanner;

public class SetTwo {

    public static void main(String[] args){
        q6();
    }

    public static void q1(){
        Scanner in = new Scanner(System.in);

        int randomNumber = (int) (Math.random() * 10 + 1);

        System.out.print("Guess a Number between 1 and 10: ");
        int guessedNumber = in.nextInt();

        if (randomNumber == guessedNumber){
            System.out.println(String.format("You guessed correctly! :) | The Number was: %d", randomNumber));
        } else if (randomNumber < guessedNumber){
            System.out.println(String.format("You guessed wrong. ;-; Your guess was too high | The Number was: %d", randomNumber));
        } else {
            System.out.println(String.format("You guessed wrong. ;-; Your guess was too low | The Number was: %d", randomNumber));
        }

    }

    public static void q2(){
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        double ppd;
        double ppe;

        System.out.print("Enter Number of Eggs: ");
        int eggs = in.nextInt();

        int dozens = eggs / 12;
        int leftOverEggs = eggs % 12;

        if (dozens < 4){
            ppd = 0.5;
        } else if (dozens >= 4 && dozens < 6){
            ppd = 0.45;
        } else if (dozens >= 6 && dozens < 11){
            ppd = 0.4;
        } else {
            ppd = 0.35;
        }

        ppe = ppd / 12.0;

        double price = (dozens * ppd) + (leftOverEggs * ppe);

        System.out.println(String.format("To buy %d eggs it will cost %s", eggs, currency.format(price)));
    }

    public static void q3(){
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        double overtime = 0;
        double pay;

        System.out.print("How many hours did you work?: ");
        double hours = in.nextDouble();

        System.out.print("What is your hourly rate?: ");
        double rate = in.nextDouble();

        if (hours > 40){
            overtime = hours - 40;
        }

        pay = (hours * rate) + (overtime * (rate * 1.5));

        System.out.println(String.format("You will be paid %s", currency.format(pay)));
    }

    public static void q4(){
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        double discount = 1;

        System.out.print("Enter Fuel in Litres: ");
        double fuelInLitres = in.nextDouble();

        System.out.print("Enter Price per Litre: ");
        double pricePerLitres = in.nextDouble();

        if(fuelInLitres >= 70.0)
            discount = 0.92;
        else if (fuelInLitres >= 40)
            discount = 0.95;

        double finalCost = (fuelInLitres * pricePerLitres) * discount;

        System.out.println(String.format("Your total is %s", currency.format(finalCost)));
    }

    public static void q5(){
        //Object Declaration
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double pRaise;

        //Prompt and Input
        System.out.print("Enter your current salary: ");
        double salary = in.nextDouble();

        System.out.print("Enter your performance rating: ");
        int pRating = in.nextInt();

        if(pRating == 1)
            pRaise = 0.06;
        else if (pRating == 2)
            pRaise = 0.04;
        else if (pRating == 3)
            pRaise = 0.015;
        else
            pRaise = 0.0;

        double raise = salary * pRaise;

        double nSalary = salary + raise;

        System.out.println(String.format("Your raise will be: %s", currency.format(raise)));
        System.out.println(String.format("Your new salaray will be: %s", currency.format(nSalary)));

    }

    public static void q6(){
        Scanner in = new Scanner(System.in);

        boolean leapYear = false;

        System.out.print("Enter a year: ");
        int year = in.nextInt();

        if (year >= 1582) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        leapYear = true;
                    } else {
                        leapYear = false;
                    }
                } else {
                    leapYear = true;
                }
            } else {
                leapYear = false;
            }
        } else {
            System.out.println("Huh never heard of this year before.");
            return;
        }

        if (leapYear){
            System.out.println(String.format("The year %d is a leap Year.", year));
        } else {
            System.out.println(String.format("The year %d is not a leap Year.", year));
        }

    }
}

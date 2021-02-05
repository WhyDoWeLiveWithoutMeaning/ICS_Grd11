package eric.projects.VariablesAssignment;

import java.util.Scanner;

public class VariablesInput {

    public static void main(String[] args) {
        Scanner textIn = new Scanner(System.in);

        System.out.print("Enter an Integer: ");
        int integerVariable = textIn.nextInt();

        System.out.print("Enter a Double: ");
        double doubleVariable = textIn.nextDouble();

        System.out.print("Enter a Char: ");
        char charVariable = textIn.next().charAt(0);

        System.out.print("Enter a Boolean: ");
        boolean booleanVariable = textIn.nextBoolean();

        System.out.print("Enter a String: ");
        String stringVariable = textIn.next();

        System.out.println("Integer Variable: " + integerVariable);
        System.out.println("Double Variable: " + doubleVariable);
        System.out.println("Character Variable: " + charVariable);
        System.out.println("Boolean Variable: " + booleanVariable);
        System.out.println("String Variable: " + stringVariable);
    }
}

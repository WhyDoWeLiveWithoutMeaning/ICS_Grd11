package eric.projects.JavaInputOutput;

import java.util.Scanner;

public class InputOutputAssignment {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("How many bones are in the Adult Human Body?: ");
        int bones = in.nextInt();

        System.out.print("true or false. The war of 1812 end in 1816?: ");
        boolean war = in.nextBoolean();

        System.out.print("What is the distance between two points, (1,1) and (2,3): ");
        double distance = in.nextDouble();

        System.out.print("What month was the Treaty of Versailles Signed?: ");
        String peaceTreaty = in.next();

        System.out.print("What is the first letter of your great grandfathers last name.");
        char invasionYear = in.next().charAt(0);

        System.out.println(String.format("You said there are %d bones in an Adult Human Body.", bones));
        System.out.println(String.format("You said it was %b that the war of 1812 ended in 1816.", war));
        System.out.println(String.format("You said the distance between the two points is %f.", distance));
        System.out.println(String.format("You said the month the Treaty of Versailles was signed was %s", peaceTreaty));
        System.out.println(String.format("You said the French invasion of Russian began in %s", invasionYear));
    }
}

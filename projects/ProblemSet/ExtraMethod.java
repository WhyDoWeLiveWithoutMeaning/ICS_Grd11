package eric.projects.ProblemSet;

public class ExtraMethod {

    public static void main(String[] args){
        System.out.printf("Largest Common Divisor of 100 and 98 is %d", gcd(100, 98));
    }

    public static void flip(){
        if(Math.random() >= 0.5) System.out.println("heads");
        else System.out.println("tails");
    }

    public static String grade(int grade){
        if (grade < 0 || grade > 100) return "Invalid Grade";
        else if (grade < 50) return "F";
        else if (grade < 60) return "D";
        else if (grade < 70) return "C";
        else if (grade < 80) return "B";
        else if (grade <= 100) return "A";
        return "Invalid Grade";
    }

    public static double celsiusToFahrenheit(double celsius){
        return (celsius * (9.0 / 5.0)) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) / (9.0 / 5.0);
    }

    public static int gcd(int n1, int n2){
        for(int i = Math.min(n1, n2); i > 0; i++){
            if(n1 % i == 0 && n2 % i == 0){
                return i;
            }
        }
        return 1;
    }

    public static void wordTriangle(String word){
        for(int i = 1; i < word.length()+1; i++){
            System.out.println(word.substring(0, i));
        }
    }

    public static boolean isPrime(int number){
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        }

        for (int i = 2; i < Math.sqrt(number) + 1; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void drawTrident(int t, int s, int h){

        //Pattern 1
        for(int i = 0; i < t; i++){
            for(int j = 0; j < 2; j++) {
                System.out.print("*");
                for (int k = 0; k < s; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println("*");
        }

        //Pattern 2
        for(int i = 0; i < s*2+3; i++)
            System.out.print("*");
        System.out.println();

        //Pattern 3
        for(int i = 0; i < h; i++){
            for(int j = 0; j < s+1; j++){
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}

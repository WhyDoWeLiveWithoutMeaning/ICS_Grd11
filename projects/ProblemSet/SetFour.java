public class SetFour {

    public static void main(String[] args){

    }

    public static void address(){
        System.out.println("3954 Davisson Street");
    }

    public static void lol(){
        String laughOutLoud =
                  "*      ****  *\n"
                + "*      *  *  *\n"
                + "*      *  *  *\n"
                + "*      *  *  *\n"
                + "*****  ****  *****\n";
        System.out.println(laughOutLoud);
    }

    public static void greetings(String name){
        System.out.printf("Greetings %s!, It is a pleasure to meet you!\n", name);
    }

    public static void repeat(String word, int times){
        while(times-->0){
            System.out.println(word);
        }
    }

    public static boolean trueOrFalse(){
        if (Math.random() >= 0.5) return true;
        return false;
    }

    public static double areaOfCircle(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public static int randomNum(){
        return (int) (Math.random() * 6 + 1);
    }

    public static int randomNum(int max){
        return (int) (Math.random() * max + 1);
    }

    public static int sumRandomNum(int times){
        int answer = 0;
        while(times-->0){
            answer += randomNum();
        }
        return answer;
    }

    public static int sumRandomNum(int times, int max){
        int answer = 0;
        while(times-->0){
            answer += randomNum(max);
        }
        return answer;
    }
}

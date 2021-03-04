import java.util.Scanner;

public class CannonBallStacker {

    public static void main(String[] args){
        q1();
        q2();
    }

    public static void q1(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Pyramid Level: ");
        int n = in.nextInt();
        int cannonBalls = 0;
        for(int i = 1; i <= n; i++){
            cannonBalls += Math.pow(i, 2);
        }
        System.out.printf("A %d level pyramid will require %d cannon balls.\n", n, cannonBalls);
    }

    public static void q2(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number of Cannon Balls: ");
        int cannonBalls=0,levels=1,balls = in.nextInt();

        while(cannonBalls <= balls){
            cannonBalls += Math.pow(levels, 2);
            levels++;
        }
        levels--;
        cannonBalls -= Math.pow(levels--, 2);


        System.out.printf("%d cannon balls can be stacked into %d levels.\n", balls, levels);
        System.out.printf("This will result in %d balls in the stack, and %d balls left over.\n", cannonBalls, Math.abs(cannonBalls-balls));
    }
}

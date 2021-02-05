package eric.projects.RotatingCube;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Eric3DRotatingCube extends JPanel{
    private static final long serialVersionUID = 1L;


    public static double angle = -0.1;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public static final int MiddleX = WIDTH/2;
    public static final int MiddleY = HEIGHT/2;

    double[][] projection = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    };

    public static Point3D[] points = new Point3D[8];

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.white);
        for(Point3D p : points) {
            g.fillOval((int)p.x, (int)p.y, 10, 10);
        }
        for(int i = 0; i < 4; i++) {
            connect(i, (i + 1) % 4, points, g);
            connect(i + 4, ((i + 1) % 4) + 4, points, g);
            connect(i, i + 4, points, g);
        }
    }

    public void update() {
        double[][] rotationZ = {
                {Math.cos(angle), Math.sin(angle) * -1, 0},
                {Math.sin(angle), Math.cos(angle), 0},
                {0, 0, 1}
        };
        double[][] rotationX = {
                {1, 0, 0},
                {0, Math.cos(angle*2), Math.sin(angle*2) * -1},
                {0, Math.sin(angle*2), Math.cos(angle*2)}
        };
        double[][] rotationY = {
                {Math.cos(angle*3), 0, Math.sin(angle*3)},
                {0, 1, 0},
                {Math.sin(angle*3) * -1, 0 , Math.cos(angle*3)}
        };

        int i = 0;
        for(Point3D p : points) {
            //System.out.println(Arrays.deepToString(EricsToolbox.matrixMultiply(projection, EricsToolbox.pointToDouble(p))));
            Point3D newP = new Point3D(p.x - MiddleX, p.y - MiddleY, p.z);

            Point3D c = EricsToolbox.matrixMultiply(projection, EricsToolbox.matrixMultiply(rotationZ, EricsToolbox.matrixMultiply(rotationX, EricsToolbox.matrixMultiply(rotationY, newP))));
            points[i] = new Point3D(c.x + MiddleX, c.y + MiddleY, c.z);
            i++;
        }
    }

    public static void connect(int i, int j, Point3D[] p, Graphics g) {
        Point3D a = p[i];
        Point3D b = p[j];
        g.drawLine((int)a.x + 5, (int)a.y + 5, (int)b.x + 5, (int)b.y + 5);
    }

    public static void main(String[]args) {
        JFrame frame = new JFrame("Projection Project");
        frame.setSize(WIDTH, HEIGHT);
        frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
        Container pane = frame.getContentPane();
        Eric3DRotatingCube main = new Eric3DRotatingCube();
        pane.add(main);
        frame.setResizable(false);
        frame.setVisible(true);

        points[0] = new Point3D(-50 + MiddleX, -50 + MiddleY, -50);
        points[1] = new Point3D(50 + MiddleX, -50 + MiddleY, -50);
        points[2] = new Point3D(50 + MiddleX, 50 + MiddleY, -50);
        points[3] = new Point3D(-50 + MiddleX, 50 + MiddleY, -50);
        points[4] = new Point3D(-50 + MiddleX, -50 + MiddleY, 50);
        points[5] = new Point3D(50 + MiddleX, -50 + MiddleY, 50);
        points[6] = new Point3D(50 + MiddleX, 50 + MiddleY, 50);
        points[7] = new Point3D(-50 + MiddleX, 50 + MiddleY, 50);


        while(true) {
            main.update();
            main.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}

class EricsToolbox{
    /*
     * The following method is for matrix multiplication from a 3d point to a 2d point
     */

    public static double[][] matrixMultiply(double[][] a, double[][] b){
        int columsA = a[0].length;
        int rowsA = a.length;
        int columsB = b[0].length;
        int rowsB = b.length;

        if(columsA != rowsB) {
            System.out.println("Colums of A must match rows of B");
            return null;
        }

        double[][] result = new double[rowsA][columsB];

        for(int i = 0; i < rowsA; i++) {
            for(int j = 0; j < columsB; j++) {
                double sum = 0;
                for(int k = 0; k < columsA; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static Point3D matrixMultiply(double[][] a, Point3D b){
        double[][] m = pointToDouble(b);
        return doubleToPoint(matrixMultiply(a, m));
    }

    /*
     * The following code is to be used in correlation with the Point3D class provided in this zip/folder
     * or where ever you got this code from.
     */

    public static double[][] pointToDouble(Point3D a){
        double[][] m = new double [3][1];
        m[0][0] = a.x;
        m[1][0] = a.y;
        m[2][0] = a.z;
        return m;
    }

    public static Point3D doubleToPoint(double[][] a) {
        Point3D m = new Point3D(a[0][0], a[1][0], a[2][0]);

        return m;
    }

}
class Point3D {
    public double x, y, z;
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public String toString() {
        double[] p = {x, y, z};
        return Arrays.toString(p);
    }
}

package eric.projects.EricBoidProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EricsBoids extends JPanel {
    // ScreenSize
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static final int WIDTH = (int) screenSize.getWidth();
    static final int HEIGHT = (int) screenSize.getHeight();

    // Object Preset settings
    static int radius = 5;// Triangle Size
    static int view = 100;// View Distance
    static boolean rotate = true;// If set to true triangles will spin.

    // Boid settings
    static double avoidFactor = 0.05;
    static double centeringFactor = 0.005;
    static double matchingFactor = 0.05;
    static int speedLimit = 10;
    static boolean keepIn = true;

    static int time = 10;// Thread sleep time

    static int num = 0;

    private final static int numberOfClones = 100;// Number of Clones
    public static Clone[] clones = new Clone[numberOfClones];// Clone array declaration
    public static int[] cloneX = new int[numberOfClones];
    public static int[] cloneY = new int[numberOfClones];

    // Paints to screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);// Clears the screen
        g.setColor(Color.gray);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Paints each object to the screen
        for (int x = 0; x < num; x++) {
            // g.setColor(Color.BLUE);
            // g.fillOval((cloneX[clones[x].cloneID] - radius/2) - 75,
            // (cloneY[clones[x].cloneID] - radius/2) - 75, radius, radius);
            g.setColor(Color.yellow);
            g.fillPolygon(clones[x].object());
        }
    }

    public void update() {
        // updates the value of each clone
        for (int x = 0; x < num; x++) {
            clones[x].toCenter();
            clones[x].awayOthers();
            clones[x].matchSpeed();
            clones[x].keepIn();
            clones[x].limitSpeed();
            clones[x].update();
        }
    }

    public static void main(String[] args) {
        // Frame init / settings
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Random Birds Flying");
        gameFrame.setSize(WIDTH, HEIGHT);
        gameFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = gameFrame.getContentPane();
        EricsBoids main = new EricsBoids();
        contentPane.add(main);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);

        // Clone Initialization
        for (int x = 0; x < numberOfClones; x++) {
            clones[x] = new Clone(HEIGHT, WIDTH, radius, x, centeringFactor, avoidFactor, matchingFactor, speedLimit);
        }

        // game loop
        while (true) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            main.update();
            main.repaint();
            if (num < numberOfClones)
                num++;
        }
    }

    public static void toCenter(Clone c) {

    }
}

//Clone class
class Clone {
    // Clone setting variables
    int HEIGHT;
    int WIDTH;
    double centerX;
    double centerY;
    double changeX;
    double changeY;
    double centeringFactor;
    int distAway;
    double avoidFactor;
    double matchingFactor;
    int speedLimit;
    int radius;
    double angle;
    int cloneID;

    // triangle point coordinates
    int[] xPoints = { 0, 0, 0 };
    int[] yPoints = { 0, 0, 0 };

    // Clone Constructor
    Clone(int height, int width, int Radius, int ClondeID, double centeringFactor, double avoidFactor,
          double matchingFactor, int speedLimit) {
        HEIGHT = height;
        WIDTH = width;
        centerX = (int) (Math.random() * width + 1);
        centerY = (int) (Math.random() * height + 1);
        changeX = (Math.random() * 11 - 5);
        changeY = (Math.random() * 11 - 5);
        radius = Radius;
        angle = Math.random() * 360 - 180;
        cloneID = ClondeID;
        if (centeringFactor != 0)
            this.centeringFactor = centeringFactor;
        else
            this.centeringFactor = 0.005;
        if (avoidFactor != 0)
            this.avoidFactor = avoidFactor;
        else
            this.avoidFactor = 0.05;
        if (matchingFactor != 0)
            this.matchingFactor = matchingFactor;
        else
            this.matchingFactor = 0.05;
        if (speedLimit != 0)
            this.speedLimit = speedLimit;
        else
            this.speedLimit = 10;
        distAway = Radius + 7;

    }

    // This method creates a shape and gives each vertex of the shape its
    // coordinates. returning the shape
    public Polygon object() {
        Polygon p = new Polygon();
        for (int x = 0; x < 3; x++) {
            p.addPoint(xPoints[x], yPoints[x]);
        }
        return p;
    }

    // updates the clones values
    public void update() {
        if (changeX > 0) {
            angle = EricMethod.findAngle(0, 5, 0 + changeX, 0 + changeY) * -1;
        } else {
            angle = EricMethod.findAngle(0, 5, 0 + changeX, 0 + changeY);
        }
        centerX += changeX;
        centerY += changeY;
        // updates the triangles points
        xPoints[0] = (int) EricMethod.rotatePoint(centerX - radius, centerY - radius, angle, centerX, centerY)[0];
        xPoints[1] = (int) EricMethod.rotatePoint(centerX + radius, centerY - radius, angle, centerX, centerY)[0];
        xPoints[2] = (int) EricMethod.rotatePoint(centerX, centerY + radius, angle, centerX, centerY)[0];
        yPoints[0] = (int) EricMethod.rotatePoint(centerX - radius, centerY - radius, angle, centerX, centerY)[1];
        yPoints[1] = (int) EricMethod.rotatePoint(centerX + radius, centerY - radius, angle, centerX, centerY)[1];
        yPoints[2] = (int) EricMethod.rotatePoint(centerX, centerY + radius, angle, centerX, centerY)[1];
        EricsBoids.cloneX[cloneID] = EricMethod.findTriangleIncenter(xPoints, yPoints)[0];
        EricsBoids.cloneY[cloneID] = EricMethod.findTriangleIncenter(xPoints, yPoints)[1];
    }

    public void toCenter() {
        int centX = 0;
        int centY = 0;
        int numberOfBoids = 0;

        for (Clone c : EricsBoids.clones) {
            if (EricMethod.dist(centerX, centerY, c.centerX, c.centerY) < EricsBoids.view) {
                centX += c.centerX;
                centY += c.centerY;
                numberOfBoids += 1;
            }
        }
        if (numberOfBoids > 2) {
            centX = centX / numberOfBoids;
            centY = centY / numberOfBoids;

            changeX += (centX - centerX) * centeringFactor;
            changeY += (centY - centerY) * centeringFactor;
        }
    }

    public void awayOthers() {
        double moveX = 0;
        double moveY = 0;

        for (Clone c : EricsBoids.clones) {
            if (c.cloneID != cloneID) {
                if (EricMethod.dist(centerX, centerY, c.centerX, c.centerY) < distAway) {
                    moveX += centerX - c.centerX;
                    moveY += centerY - c.centerY;
                }
            }
        }

        changeX += moveX * avoidFactor;
        changeY += moveY * avoidFactor;

    }

    public void matchSpeed() {
        double avgX = 0;
        double avgY = 0;
        int numberOfClones = 0;

        for (Clone c : EricsBoids.clones) {
            if (EricMethod.dist(centerX, centerY, c.centerX, c.centerY) < EricsBoids.view) {
                avgX += c.changeX;
                avgY += c.changeY;
                numberOfClones += 1;
            }
        }
        if (numberOfClones > 2) {
            avgX = avgX / numberOfClones;
            avgY = avgY / numberOfClones;

            changeX += (avgX - changeX) * matchingFactor;
            changeY += (avgY - changeY) * matchingFactor;
        }

    }

    public void limitSpeed() {
        double speed = Math.sqrt(changeX * changeX + changeY * changeY);
        if (speed > speedLimit) {
            changeX = (changeX / speed) * speedLimit;
            changeY = (changeY / speed) * speedLimit;
        }
    }

    public void keepIn() {

        int margin = 100;
        int turnfactor = 1;

        if (EricsBoids.keepIn) {
            if (centerX < margin) {
                changeX += turnfactor;
            }
            if (centerX > WIDTH - margin) {
                changeX -= turnfactor;
            }
            if (centerY < margin) {
                changeY += turnfactor;
            }
            if (centerY > HEIGHT - margin) {
                changeY -= turnfactor;
            }
        } else {
            if (centerX < 0) {
                centerX = WIDTH;
            }
            if (centerX > WIDTH) {
                centerX = 0;
            }
            if (centerY < 0) {
                centerY = HEIGHT;
            }
            if (centerY > HEIGHT) {
                centerY = 0;
            }
        }
    }

    // to pull which clone it is
    public int getCloneID() {
        return cloneID;
    }
}

//My little toolbox
class EricMethod {
    // Finds the incenter of a triangle.
    public static int[] findTriangleIncenter(int[] xP, int[] yP) {

        int[] ans = new int[2];

        double sideLengthA;
        double sideLengthB;
        double sideLengthC;
        double inmidX;
        double inmidY;

        sideLengthC = Math.sqrt(Math.pow((xP[1] - xP[0]), 2) + Math.pow((yP[1] - yP[0]), 2));
        sideLengthA = Math.sqrt(Math.pow((xP[2] - xP[1]), 2) + Math.pow((yP[2] - yP[1]), 2));
        sideLengthB = Math.sqrt(Math.pow((xP[0] - xP[2]), 2) + Math.pow((yP[0] - yP[2]), 2));

        inmidX = ((sideLengthA * xP[0]) + (sideLengthB * xP[1]) + (sideLengthC * xP[2]))
                / (sideLengthA + sideLengthB + sideLengthC);
        inmidY = ((sideLengthA * yP[0]) + (sideLengthB * yP[1]) + (sideLengthC * yP[2]))
                / (sideLengthA + sideLengthB + sideLengthC);

        ans[0] = (int) inmidX;
        ans[1] = (int) inmidY;
        return ans;
    }

    /*
     * Rotates the coordinates relative to an origin point by an angle. It does not
     * add the value so if angle is set to 10 it will not keep rotating 10 degrees
     * each time. Instead it will set the shape to its position of 10 degrees.
     */
    public static double[] rotatePoint(double xP, double yP, double angle, double cx, double cy) {
        double[] ans = new double[2];

        angle = angle * (Math.PI / 180);

        double newX = Math.cos(angle) * (xP - cx) - Math.sin(angle) * (yP - cy) + cx;
        double newY = Math.sin(angle) * (xP - cx) + Math.cos(angle) * (yP - cy) + cy;

        ans[0] = newX;
        ans[1] = newY;

        return ans;
    }

    /*
     * These methods return the distance between 2 points
     */
    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }

    /*
     * These methods will return the angle between two points
     */

    public static double findAngle(int x1, int y1, int x2, int y2) {
        double ans;

        double u = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double v = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        double uv = (x1 * x2) + (y1 * y2);

        ans = Math.toDegrees(Math.acos(uv / (u * v)));

        return ans;
    }

    public static double findAngle(double x1, double y1, double x2, double y2) {
        double ans;

        double u = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double v = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        double uv = (x1 * x2) + (y1 * y2);
        ans = Math.toDegrees(Math.acos(uv / (u * v)));

        return ans;
    }

    public static double findAngle(Point p1, Point p2) {
        double ans;

        double u = Math.sqrt(Math.pow(p1.x, 2) + Math.pow(p1.y, 2));
        double v = Math.sqrt(Math.pow(p2.x, 2) + Math.pow(p2.y, 2));

        double uv = (p1.x * p2.x) + (p1.y * p2.y);

        ans = Math.toDegrees(Math.acos(uv / (u * v)));

        return ans;
    }
}
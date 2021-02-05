package eric.toolbox;

import java.awt.Point;

public class EricsToolbox
{
    public static double[] findTriangleIncenter(final double[] xP, final double[] yP) {
        final double[] ans = new double[2];
        final double sideLengthC = Math.sqrt(Math.pow(xP[1] - xP[0], 2.0) + Math.pow(yP[1] - yP[0], 2.0));
        final double sideLengthA = Math.sqrt(Math.pow(xP[2] - xP[1], 2.0) + Math.pow(yP[2] - yP[1], 2.0));
        final double sideLengthB = Math.sqrt(Math.pow(xP[0] - xP[2], 2.0) + Math.pow(yP[0] - yP[2], 2.0));
        final double inmidX = (sideLengthA * xP[0] + sideLengthB * xP[1] + sideLengthC * xP[2]) / (sideLengthA + sideLengthB + sideLengthC);
        final double inmidY = (sideLengthA * yP[0] + sideLengthB * yP[1] + sideLengthC * yP[2]) / (sideLengthA + sideLengthB + sideLengthC);
        ans[0] = inmidX;
        ans[1] = inmidY;
        return ans;
    }

    public static double[] findTriangleIncenter(final double x1, final double y1, final double x2, final double y2, final double x3, final double y3) {
        final double[] ans = new double[2];
        final double sideLengthC = Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
        final double sideLengthA = Math.sqrt(Math.pow(x3 - x2, 2.0) + Math.pow(y3 - y2, 2.0));
        final double sideLengthB = Math.sqrt(Math.pow(x1 - x3, 2.0) + Math.pow(y1 - y3, 2.0));
        final double inmidX = (sideLengthA * x1 + sideLengthB * x2 + sideLengthC * x3) / (sideLengthA + sideLengthB + sideLengthC);
        final double inmidY = (sideLengthA * y1 + sideLengthB * y2 + sideLengthC * y3) / (sideLengthA + sideLengthB + sideLengthC);
        ans[0] = inmidX;
        ans[1] = inmidY;
        return ans;
    }

    public static double[] rotatePoint2D(final double xP, final double yP, double angle, final double cx, final double cy) {
        final double[] ans = new double[2];
        angle *= 0.017453292519943295;
        final double newX = Math.cos(angle) * (xP - cx) - Math.sin(angle) * (yP - cy) + cx;
        final double newY = Math.sin(angle) * (xP - cx) + Math.cos(angle) * (yP - cy) + cy;
        ans[0] = newX;
        ans[1] = newY;
        return ans;
    }

    public static double[] rotatePoint2D(final Point p1, double angle, final Point p2) {
        final double[] ans = new double[2];
        angle *= 0.017453292519943295;
        final double newX = Math.cos(angle) * (p1.x - p2.x) - Math.sin(angle) * (p1.y - p2.y) + p2.x;
        final double newY = Math.sin(angle) * (p1.x - p2.x) + Math.cos(angle) * (p1.y - p2.y) + p2.y;
        ans[0] = newX;
        ans[1] = newY;
        return ans;
    }

    public static double[] rotateAroundX3D(final double yP, final double zP, double angle, final double cy, final double cz) {
        final double[] ans = new double[2];
        angle *= 0.017453292519943295;
        final double cosAngle = Math.cos(angle);
        final double sinAngle = Math.sin(angle);
        final double newY = (yP - cy) * cosAngle - (zP - cz) * sinAngle;
        final double newZ = (yP - cy) * sinAngle + (zP - cz) * cosAngle;
        ans[0] = newY + cy;
        ans[1] = newZ + cz;
        return ans;
    }

    public static double[] rotateAroundY3D(final double xP, final double zP, double angle, final double cx, final double cz) {
        final double[] ans = new double[2];
        angle *= 0.017453292519943295;
        final double cosAngle = Math.cos(angle);
        final double sinAngle = Math.sin(angle);
        final double newX = (zP - cz) * sinAngle + (xP - cx) * cosAngle;
        final double newZ = (zP - cz) * cosAngle - (xP - cx) * sinAngle;
        ans[0] = newX + cx;
        ans[1] = newZ + cz;
        return ans;
    }

    public static double[] rotateAroundZ3D(final double xP, final double yP, double angle, final double cx, final double cy) {
        final double[] ans = new double[2];
        angle *= 0.017453292519943295;
        final double cosAngle = Math.cos(angle);
        final double sinAngle = Math.sin(angle);
        final double newX = (xP - cx) * cosAngle - (yP - cy) * sinAngle;
        final double newY = (xP - cx) * sinAngle + (yP - cy) * cosAngle;
        ans[0] = newX + cx;
        ans[1] = newY + cy;
        return ans;
    }

    public static double[] translate3D(final double x, final double y, final double z, final double Tx, final double Ty, final double Tz) {
        final double[] ans = { x + Tx, y + Ty, z + Tz };
        return ans;
    }

    public static double[] scale3D(final double x, final double y, final double z, final double Sx, final double Sy, final double Sz) {
        final double[] ans = { x * Sx, y * Sy, z * Sz };
        return ans;
    }

    public static double reflect(final double n) {
        return n * -1.0;
    }

    public static double[][] matrixMultiply(final double[][] a, final double[][] b) {
        final int columsA = a[0].length;
        final int rowsA = a.length;
        final int columsB = b[0].length;
        final int rowsB = b.length;
        if (columsA != rowsB) {
            System.out.println("Colums of A must match rows of B");
            return null;
        }
        final double[][] result = new double[rowsA][columsB];
        for (int i = 0; i < rowsA; ++i) {
            for (int j = 0; j < columsB; ++j) {
                double sum = 0.0;
                for (int k = 0; k < columsA; ++k) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static Point3D matrixMultiply(final double[][] a, final Point3D b) {
        final double[][] m = pointToDouble(b);
        return doubleToPoint(matrixMultiply(a, m));
    }

    public static void logMatrix(final double[][] m) {
        final int cols = m[0].length;
        final int rows = m.length;
        System.out.println(String.valueOf(rows) + "x" + cols);
        System.out.println("----------------");
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.print(String.valueOf(m[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[] shearX3D(final double x, final double y, final double z, final double Sy, final double Sz) {
        final double[] ans = { y + Sy * x, z + Sz * x };
        return ans;
    }

    public static double[] shearY3D(final double x, final double y, final double z, final double Sx, final double Sz) {
        final double[] ans = { x + Sx * y, z + Sz * y };
        return ans;
    }

    public static double[] shearZ3D(final double x, final double y, final double z, final double Sx, final double Sy) {
        final double[] ans = { x + Sx * z, y + Sy * z };
        return ans;
    }

    public static double dist(final int x1, final int y1, final int x2, final int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }

    public static double dist(final double x1, final double y1, final double x2, final double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }

    public static double dist(final Point p1, final Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2.0) + Math.pow(p2.y - p1.y, 2.0));
    }

    public static double dist3d(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0) + Math.pow(z2 - z1, 2.0));
    }

    public static double dist3d(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0) + Math.pow(z2 - z1, 2.0));
    }

    public static double findAngle2D(final int x1, final int y1, final int x2, final int y2) {
        final double u = Math.sqrt(Math.pow(x1, 2.0) + Math.pow(y1, 2.0));
        final double v = Math.sqrt(Math.pow(x2, 2.0) + Math.pow(y2, 2.0));
        final double uv = x1 * x2 + y1 * y2;
        final double ans = Math.toDegrees(Math.acos(uv / (u * v)));
        return ans;
    }

    public static double findAngle2D(final double x1, final double y1, final double x2, final double y2) {
        final double u = Math.sqrt(Math.pow(x1, 2.0) + Math.pow(y1, 2.0));
        final double v = Math.sqrt(Math.pow(x2, 2.0) + Math.pow(y2, 2.0));
        final double uv = x1 * x2 + y1 * y2;
        final double ans = Math.toDegrees(Math.acos(uv / (u * v)));
        return ans;
    }

    public static double findAngle2D(final Point p1, final Point p2) {
        final double u = Math.sqrt(Math.pow(p1.x, 2.0) + Math.pow(p1.y, 2.0));
        final double v = Math.sqrt(Math.pow(p2.x, 2.0) + Math.pow(p2.y, 2.0));
        final double uv = p1.x * p2.x + p1.y * p2.y;
        final double ans = Math.toDegrees(Math.acos(uv / (u * v)));
        return ans;
    }

    public static double findAngle3D(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        final double u = Math.sqrt(Math.pow(x1, 2.0) + Math.pow(y1, 2.0) + Math.pow(z1, 2.0));
        final double v = Math.sqrt(Math.pow(x2, 2.0) + Math.pow(y2, 2.0) + Math.pow(z2, 2.0));
        final double uv = x1 * x2 + y1 * y2 + z1 * z2;
        final double ans = Math.toDegrees(Math.acos(uv / (u * v)));
        return ans;
    }

    public static double findAngle3D(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        final double u = Math.sqrt(Math.pow(x1, 2.0) + Math.pow(y1, 2.0) + Math.pow(z1, 2.0));
        final double v = Math.sqrt(Math.pow(x2, 2.0) + Math.pow(y2, 2.0) + Math.pow(z2, 2.0));
        final double uv = x1 * x2 + y1 * y2 + z1 * z2;
        final double ans = Math.toDegrees(Math.acos(uv / (u * v)));
        return ans;
    }

    public static double[][] pointToDouble(final Point3D a) {
        final double[][] m = new double[3][1];
        m[0][0] = a.x;
        m[1][0] = a.y;
        m[2][0] = a.z;
        return m;
    }

    public static Point3D doubleToPoint(final double[][] a) {
        final Point3D m = new Point3D(a[0][0], a[1][0], a[2][0]);
        return m;
    }
}

package eric.toolbox;

import java.util.Arrays;

public class Point3D {
    double x;
    double y;
    double z;

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        final double[] retString = {this.x, this.y, this.z};
        return Arrays.toString(retString);
    }

    public Double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    public Double getZ() {
        return this.z;
    }
}

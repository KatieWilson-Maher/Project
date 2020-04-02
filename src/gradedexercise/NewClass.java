package gradedexercise;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author katie
 */
class Matrix {

    private final double[][] elements;

    public Matrix() {
        this.elements = new double[4][4];
        this.identity();
    }

    public double get(int row, int column) {
        return this.elements[row][column];
    }

    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    }

    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } else {
                    this.set(i, j, 0.0);
                }
            }
        }
    }

    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < 3; i++) {
            result.append(this.get(row, i));
            result.append(", ");
        }
        result.append(this.get(row, 3));
        result.append(" ]");
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(rowToString(i));
            result.append("\n");
        } 
        return result.toString();
    }

    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.elements[row][k]
                            * otherMatrix.elements[k][column];
                }
                product.set(row, column, sum);
            }
        }
        return product;
    }

    public Matrix matrixRotationXAxis() {
        return null;
    }

    public Matrix matrixRotationYAxis() {
        return null;
    }

    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, -Math.sin(angle));
        this.set(1, 0, Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    }

    public Matrix matrixScaling() {
        return null;
    }

    public Matrix matrixRotation() {
        return null;
    }

}

class Vector {
    private double x,y,z,h;
    
    // A constructor will have no parameters. It will produce a Vector whose elements all have a values equal to zero.
    public Vector() {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;
    }
    
    // A constructor will have 3 floating point values. It will produce a Vector
    // whose x, y, and z elements have values equal those given by the parameter.
    // The fourth (homogeneous) coordinate will have a value equal to one.
    public Vector(double one, double two, double three){
        x = one;
        y = two;
        z = three;
        h = 1;
    }
    
    //The dot() method will have one Vector parameter. Its return type is double. It will compute the dot product of this vector and the parameter.
    public double dot(Vector v){
        return this.x*v.get(0) + this.y*v.get(1) + this.z*v.get(2) + this.h*v.get(3);
    }
            
    //The magnitude() method will have no parameters. Its return type is double. It will compute the magnitude of this vector.
    public double magnitude(){
        return Math.abs(Math.sqrt(x*x + y*y + z*z + h*h));
    }
    
    //The normalize() method will have no parameters. Its return type is Vector.
    // It will produce a vector that has the same direction as this vector but a
    // magnitude (length) equal to one.
    //direction = inverse tan of y/x
//    public Vector normalize(){
//        double dir = Math.atan(y/x);
//        double mag = 1;
//        
//        
//    }
    
    // The cross() method will have one Vector parameter. It return type is Vector.
    // It will compute the cross product of the x, y, and z components of this vector
    // and the x, y, and z components of the parameter.
    
    
//    cx = aybz − azby
//    cy = azbx − axbz
//    cz = axby − aybx
    //x = 0, y = 1, z = 2
    
    public Vector cross(Vector v){
        double cx = y*v.get(2) - z*v.get(1);
        double cy = z*v.get(0) - x*v.get(2);
        double cz = x*v.get(1) - y*v.get(0);
        Vector c = new Vector(cx,cy,cz);
        return c;
    }
    
    //The get() method will have one integer parameter. It return type is double.
    // It will return the x component of the vector if the parameter's value equals 0,
    // the y component if the parameter's value equals 1, the z component if the parameter's
    // value equals 2, and the homogeneous component if the parameter's value equals 3.        
    public double get(int index) {
        double returnValue = 0;
        if (index == 0){
            returnValue = x;
        }
        if (index == 1){
            returnValue = y;
        }
        if (index == 2){
            returnValue = z;
        }
        if (index == 3){
            returnValue = h;
        }
        return returnValue;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + h + ")";
    }
}

class both {
    // The multiply() method has a Vector parameter. Its return type is Vector.
    // The method computes the product of this matrix and the parameter.
    public Vector multiply(Vector v) {
        return null;
    }
}

public class NewClass {

    public static void main(String[] args) {
        Vector u = new Vector(2,3,4);
        Vector v = new Vector(5,6,7);
        //System.out.println(u.cross(v));

        Matrix m = new Matrix();
        m.set(0, 0, 5);
        //System.out.println(m);
        Matrix n = new Matrix();
        //System.out.println(m.multiply(n));
        //System.out.println(m.identityMatrix());
       // System.out.println(m.toString());

    }
}

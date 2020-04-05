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

    //DONE
    public Matrix() {
        this.elements = new double[4][4];
        this.identity();
    }

    //DONE
    public double get(int row, int column) {
        return this.elements[row][column];
    }

    //DONE
    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    }

    //DONE
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

    //DONE
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

    //DONE
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(rowToString(i));
            result.append("\n");
        }
        return result.toString();
    }

    //DONE
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

    // The rotateX() method has a single floating point parameter. Its return
    // type is void. That parameter represents an angle. The method sets the 
    // values of the elements of the matrix to create a matrix that models a
    // rotation about the x-axis.
    //DONE/TO TEST
    public void rotateX(double angle) {
        this.identity();
        this.set(1, 1, Math.cos(angle));
        this.set(1, 2, -Math.sin(angle));
        this.set(2, 1, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    }

    //The rotateY() method has a single floating point parameter. Its return
    // type is void. That parameter represents an angle. The method sets the
    // values of the elements of the matrix to create a matrix that models a
    // rotation about the y-axis.
    //DONE/TO TEST
    public void rotateY(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 2, Math.sin(angle));
        this.set(2, 0, -Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    }

    //The rotateZ() method has a single floating point parameter. Its return type
    // is void. That parameter represents an angle. The method sets the values of
    // the elements of the matrix to create a matrix that models a rotation about
    // the z-axis
    //DONE
    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, -Math.sin(angle));
        this.set(1, 0, Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    }

    //The scale() method has 3 floating point parameters. Its return type is
    // void. The parameters specify the factor by which a geometric figure is to
    // be enlarged (or shrunk) along the x, y, and z axes. The method sets the
    // values of the elements of the matrix to create a matrix that models a scaling.
    //DONE/TO TEST
    public void scale(double xChange, double yChange, double zChange) {
        this.identity();
        System.out.println(this.get(0, 0));
        this.set(0,0,xChange);
        this.set(1,1,yChange);
        this.set(2,2,zChange);
    }

    //The translate() method has 3 floating point parameters. Its return type is
    // void. The parameters specify the distance by which a geometric figure is
    // to be translated (moved) along the x, y, and z axes. The method sets the
    // values of the elements of the matrix to create a matrix that models a
    // translation.
    //DONE/TO TEST
    public void translate(float xChange, float yChange, float zChange) {
        this.identity();
        this.set(3,0,xChange);
        this.set(3,1,yChange);
        this.set(3,2,zChange);
    }

    //The multiply() method has a Vector parameter. Its return type is Vector.
    // The method computes the product of this matrix and the parameter.
    //DONE
    public Vector multiply(Vector v) {
        Vector newV = new Vector();
        double row1 = 0;
        int vec = 0;
        for (int row = 0; row < 4; row++) {
            vec += 1;
            row1 = 0;
            for (int column = 0; column < 4; column++) {
                double currentM = this.get(row, column);
                double currentV = v.get(vec - 1);
                double newVal = currentM * currentV;
                if (vec < 5) {
                    row1 += newVal;
                    newV.set(vec - 1, row1);
                }
            }
        }
        return newV;
    }
}

class Vector {

    private double x, y, z, h;

    // A constructor will have no parameters. It will produce a Vector whose
    // elements all have a values equal to zero.
    //DONE
    public Vector() {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;
    }

    // A constructor will have 3 floating point values. It will produce a Vector
    // whose x, y, and z elements have values equal those given by the parameter.
    // The fourth (homogeneous) coordinate will have a value equal to one.
    //DONE
    public Vector(double one, double two, double three) {
        x = one;
        y = two;
        z = three;
        h = 1;
    }

    //The dot() method will have one Vector parameter. Its return type is double.
    // It will compute the dot product of this vector and the parameter.
    //DONE
    public double dot(Vector v) {
        return this.x * v.get(0) + this.y * v.get(1) + this.z * v.get(2) + this.h * v.get(3);
    }

    //The magnitude() method will have no parameters. Its return type is double.
    // It will compute the magnitude of this vector.
    //DONE
    public double magnitude() {
        return Math.abs(Math.sqrt(x * x + y * y + z * z + h * h));
    }

    //The normalize() method will have no parameters. Its return type is Vector.
    // It will produce a vector that has the same direction as this vector but a
    // magnitude (length) equal to one.
    //direction = inverse tan of y/x
    //DONE/TO TEST
    public Vector normalize(){
        Vector newV = new Vector();
        double mag = this.magnitude();
        newV.set(0,this.x/mag);
        newV.set(1,this.y/mag);
        newV.set(2,this.z/mag);
        newV.set(3,this.h/mag);
//      double dir = Math.atan(y/x);
        return newV;
    }
    
    
    // The cross() method will have one Vector parameter. It return type is Vector.
    // It will compute the cross product of the x, y, and z components of this vector
    // and the x, y, and z components of the parameter.
//    cx = aybz − azby
//    cy = azbx − axbz
//    cz = axby − aybx
    //x = 0, y = 1, z = 2
    //DONE
    public Vector cross(Vector v) {
        double cx = y * v.get(2) - z * v.get(1);
        double cy = z * v.get(0) - x * v.get(2);
        double cz = x * v.get(1) - y * v.get(0);
        Vector c = new Vector(cx, cy, cz);
        return c;
    }

    //The get() method will have one integer parameter. It return type is double.
    // It will return the x component of the vector if the parameter's value equals 0,
    // the y component if the parameter's value equals 1, the z component if the parameter's
    // value equals 2, and the homogeneous component if the parameter's value equals 3.  
    //DONE/COULD FIX
    public double get(int index) {
        double returnValue = 0;
        if (index == 0) {
            returnValue = x;
        }
        if (index == 1) {
            returnValue = y;
        }
        if (index == 2) {
            returnValue = z;
        }
        if (index == 3) {
            returnValue = h;
        }
        return returnValue;
    }

    //DONE/COULD FIX
    public void set(int index, double val) {
        if (index == 0) {
            this.x = val;
        }
        if (index == 1) {
            this.y = val;
        }
        if (index == 2) {
            this.z = val;
        }
        if (index == 3) {
            this.h = val;
        }
    }

    //DONE
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + h + ")";
    }

}

public class NewClass {

    public static void main(String[] args) {
        //Vector u = new Vector(2, 3, 4);
        Vector v = new Vector(1, 2, 3);
        System.out.println(v.normalize());
        //System.out.println(v.toString());
        

        Matrix m = new Matrix();

        int i = 0;
//        for (int row = 0; row < 4; row++) {
//            for (int column = 0; column < 4; column++) {
//                //System.out.println("row: "+row+" column: "+column);
//                m.set(row, column, i);
//                i += 1;
//            }
//        }

        //System.out.println(m);
        Matrix n = new Matrix();
        n.translate(2, 4, 6);
        //System.out.println(n.toString());
        //System.out.println(m.multiply(n));
        //System.out.println(m.identityMatrix());
        //System.out.println(m.toString());
        //System.out.println(m.multiply(v));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradedexercise;

/**
 *
 * @author katie
 */
public class Vector{
    private double x;
    private double y;
    
    
    public Vector(double x,double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
  
    
    public static void main(String[] args){
        Vector u = new Vector(1,2);
        System.out.println(u.getX());
    }
        
    
}

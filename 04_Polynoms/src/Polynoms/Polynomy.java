/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polynoms;

/**
 * Library knihovni trida
 * @author kajal
 */
public class Polynomy {

    private Polynomy(){
        
    }
    //static protoze se nejedna o objekty
    public static Polynom sum(Polynom a, Polynom b){ //neni treba defenzivni kopie, protoze Polynom je nemenny
        //5x3 + 2x2     + 3
        //      4x2 + x + 2
        //5x3   6x2 + x  + 5
        Polynom max = a.getDegree() > b.getDegree()? a : b;
        Polynom min = a.getDegree() <= b.getDegree()? a : b;
        
        double[] sum = new double[max.getDegree()+1];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sum[i] = sum[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sum);
    }
    
    /*
    public static Polynom multiply(Polynom a, Polynom b){
        
    }
    */
    
    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(3, 0, 2, 5);
        Polynom p2 = Polynom.getInstance(2, 1, 4);
        System.out.println(sum(p1,p2));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polynoms;
import java.util.Arrays;
/**
 *
 * @author kajal
 */
public class Polynom {
    
    //indexy jako exponenty
    //
    //data
    private double[] coef;    
    
    //defenzivni kopie
    private Polynom(double[] coef) { 
        double[] coefTemp = new double [coef.length];
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }
    
    //tovarni/factory metoda
    public static Polynom getInstance(double...coef){   
        return new Polynom(coef);
    }
    
    public static Polynom getInstanceReverted(double[] coef) {
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coef.length-1-i] = coef[i];
        }
        return new Polynom(coefTemp);
    }
    
    //metody
    public int getDegree(){
        return coef.length-1;
    }
    public double getCoefAt(int exponent){
        return coef[exponent];
    }
    //getter
    public double[] getCoef(){
        return Arrays.copyOf(coef, coef.length);
    }
    
    public Polynom derivate(){
        double[] derivation = new double[coef.length-1];
        for (int i = 0; i < derivation.length; i++) {
            derivation[i] = coef[i+1]*(i+1);
        }
        return new Polynom(derivation);
    }
    
    
    //TODO
    //5x3 + 3x2 + 6 pre x = 1; y = 5 + 3 + 6 = 14
    //podle Hornerova schema
    public double computeValue(double x){
    	int n = getDegree();
    	double y = 0;
    	for (int i = 0; i < n; i++) {
			y = x*(coef[n-i] + y);
		}
    	y += coef[0];
        return y;
    }
    
    /*
    //TODO bonus
    //zjistit integral
    public double integrate(double a, double b){
        return y;
    }
    */

    @Override
  //TODO vypsat matematicky spravne (0x^2)
    public String toString() {
    	 int n = coef.length;
    	 String output="";
    	 for (int i = n-1; i >= 0; i--) {
			if (coef[i] == 0) {
				continue;
			} else {
				if (i == 1)	output += coef[i] + "x";
				else if (i == 0)	output += coef[i];
				else output += coef[i] + "x^" + (i);
			}
			if (i > 0)	output += " + ";
		}
    	 return output;
    }
    
    public static void main(String[] args) {
        double[] coef = {3, 5, 2, 0, 7};
        
        Polynom p = Polynom.getInstance(coef);
        //System.out.println(p);
        System.out.println(p.derivate());
        System.out.println(p.computeValue(3));
        System.out.println(p.toString());

    }
    
}

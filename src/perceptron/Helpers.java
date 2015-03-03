/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.ArrayList;

/**
 *
 * @author raf
 */
public class Helpers {
    
    // overi, ci vektory maju rovnake velkosti
    private static void checkVectorSizesForEquality(ArrayList<Double> v1, ArrayList<Double> v2){
        if (v1.size() != v2.size()){
            System.err.println("vector sizes do not match!!!");
            System.exit(-1);
        }
    }
    
    static double crossProduct(ArrayList<Double> v1, ArrayList<Double> v2){
        checkVectorSizesForEquality(v1, v2);
        
        Double ret = 0.0;
        for (int i = 0; i < v1.size(); i++){
            ret += v1.get(i) * v2.get(i);
        }
        
        return ret;
    }
    
    static ArrayList<Double> sumVectors(ArrayList<Double> v1, ArrayList<Double> v2){
        checkVectorSizesForEquality(v1, v2);
        
        ArrayList<Double> ret = new ArrayList<>();
        for(int i = 0; i < v1.size(); i++){
            ret.add(v1.get(i) + v2.get(i));
        }
        
        return ret;
    }
    
    static ArrayList<Double> scalarProduct(ArrayList<Double> vector, double scalar){
        ArrayList<Double> ret = new ArrayList<>();
        for (Double x : vector) {
            ret.add(x * scalar);
        }
        
        return ret;
    }
    
    static double average(ArrayList<Double> numbers){
        double sum = 0;
        for (double x : numbers){
            sum += x;
        }
        return sum / numbers.size();
    }
}

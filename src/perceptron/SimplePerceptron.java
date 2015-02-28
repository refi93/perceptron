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
public class SimplePerceptron {
    double alpha; // rychlost ucenia;
    int inputSize, dataCount;
    ArrayList<ArrayList<Double> > data;
    ArrayList<Double> weights; // posledny prvok weights je nas threshold
    
    public SimplePerceptron(ArrayList<ArrayList<Double> > data, double alpha){
        // nastavime si pocet dat a velkost vstupu
        this.dataCount = data.size();
        if (dataCount == 0){
            System.err.println("empty data set");
            return;
        }
        this.data = data;
        this.inputSize = data.get(0).size();
        this.alpha = alpha;
        
        // nastavime vahy
        weights = new ArrayList<>();
        for(int i = 0; i < inputSize; i++){
            weights.add(Math.random());
        }
    }
    
    private double iteration(){
        java.util.Collections.shuffle(data);
        double absoluteError = 0.0; // celkova chyba pocas vypoctu
        for(int i = 0; i < dataCount; i++){
            ArrayList<Double> x = data.get(i);
            Double expectedResult = x.get(x.size() - 1);
            x.set(x.size() - 1, -1.0); // lebo na poslednej pozicii si pamatame threshold, potom ho treba obnovit
            
            x.set(x.size() - 1, -1.0); // vyuzijeme posledne policko x, aby sme pracovali s thresholdom
            
            Double result = (Helpers.crossProduct(x, weights) > 0) ? 1.0 : 0.0; // prezenieme thresholdom
            double err = 0.5 * Math.pow(expectedResult - result, 2); // updatujeme chybu
            absoluteError += err;
            
            if (err > 0){
                weights = Helpers.sumVectors(weights, Helpers.scalarProduct(x, alpha * (expectedResult - result)));
            }
            
            x.set(x.size() - 1, expectedResult); // obnovenie x na povodnu hodnotu
        }
        return absoluteError;
    }
    
    public void learn(){
        int it = 0;
        while(iteration() > 0){
            System.out.println("iteration " + it++);
        };
    }
}

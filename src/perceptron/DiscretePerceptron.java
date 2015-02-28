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
public class DiscretePerceptron implements Perceptron{
    double alpha; // rychlost ucenia;
    int inputSize, dataCount;
    ArrayList<ArrayList<Double> > data;
    ArrayList<Double> weights; // posledny prvok weights je nas threshold
    
    public DiscretePerceptron(ArrayList<ArrayList<Double> > data, double alpha){
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
    
    /**
     *
     * @param y
     * @return
     */
    @Override
    public double activationFunction(double y){
        return (y > 0) ? 1.0 : 0.0;
    }
    
    /**
     *
     * @return
     */
    public double iteration(){
        java.util.Collections.shuffle(data);
        double absoluteError = 0.0; // celkova chyba pocas vypoctu
        for(int i = 0; i < dataCount; i++){
            ArrayList<Double> x = data.get(i);
            double expectedResult = x.get(x.size() - 1);
            x.set(x.size() - 1, -1.0); // lebo na poslednej pozicii si pamatame threshold, potom ho treba obnovit
            
            double result = activationFunction(Helpers.crossProduct(x, weights)); // prezenieme thresholdom            
            double err = 0.5 * Math.pow(expectedResult - result, 2); // updatujeme chybu
            absoluteError += err;
            
            if (err > 0){
                weights = Helpers.sumVectors(weights, Helpers.scalarProduct(x, alpha * (expectedResult - result)));
            }
            
            x.set(x.size() - 1, expectedResult); // obnovenie x na povodnu hodnotu
        }
        return absoluteError;
    }
    
    public void learn(double tollerance){
        int it = 0;
        while(iteration() > tollerance){
            System.out.println("iteration " + it++);
        };
    }
}

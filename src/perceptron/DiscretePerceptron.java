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
    int iter = 0;
    
    public DiscretePerceptron(ArrayList<ArrayList<Double> > data, double alpha){
        // nastavime si pocet dat a velkost vstupu
        iter = 0;
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
    
    public ArrayList<Double> updateWeights(ArrayList<Double> weights, ArrayList<Double> x, double expectedResult, double result){
        return Helpers.sumVectors(weights, Helpers.scalarProduct(x, alpha * (expectedResult - result)));
    }
    
    /**
     *
     * @return
     */
    public double iteration(boolean verbose){
        java.util.Collections.shuffle(data);
        double absoluteError = 0.0; // celkova chyba pocas vypoctu
        for(int i = 0; i < dataCount; i++){
            StringBuilder output = new StringBuilder(iter + ",");
            ArrayList<Double> x = data.get(i);
            
            for (Double it : data.get(i)){
                output.append(it.intValue() + ",");
            }
            
            for (Double it : weights){
                output.append(it + ",");
            }
            
            
            double expectedResult = x.get(x.size() - 1);
            
            
            x.set(x.size() - 1, -1.0); // lebo na poslednej pozicii si pamatame threshold, potom ho treba obnovit
            
            double result = activationFunction(Helpers.crossProduct(x, weights)); // prezenieme thresholdom            
            double err = 0.5 * Math.pow(expectedResult - result, 2); // updatujeme chybu
            absoluteError += err;
            
            output.append(result + "," + Helpers.crossProduct(x, weights) + "," + err);
            
            if (err > 0){
                weights = updateWeights(weights, x, expectedResult, result);
            }
            
            x.set(x.size() - 1, expectedResult); // obnovenie x na povodnu hodnotu
            if (verbose) System.out.println(output);
        }
        return absoluteError;
    }
    
    @Override
    public int learn(double tollerance){
        int it = 0;
        while(iteration(false) > tollerance){
            System.out.println("iteration " + it++);
        }
        return it;
    }
}

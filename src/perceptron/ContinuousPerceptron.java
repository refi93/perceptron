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
public class ContinuousPerceptron extends DiscretePerceptron{
    
    public ContinuousPerceptron(ArrayList<ArrayList<Double>> data, double alpha) {
        super(data, alpha);
    }
    
    @Override
    public double activationFunction(double y){
        return Helpers.sigmoid(y);
    }

    @Override
    public ArrayList<Double> updateWeights(ArrayList<Double> weights, ArrayList<Double> x, double expectedResult, double result){
        return Helpers.sumVectors(weights, Helpers.scalarProduct(x , alpha * (expectedResult - result) * result * (1 - result)));
    }

    /**
     *
     * @param tollerance
     * @return 
     */
    @Override
    public int learn(double tollerance){
        int it = 0;
        double err;
        do{
            err = iteration(false);
            it++;
        }while(err > tollerance);
        return it;
    }
    
    public int learnExplicit(double tollerance){
        int it = 0;
        double err;
        do{
            err = iteration(true);
            it++;
            iter++;
        }while(err > tollerance);
        return it;
    }
}

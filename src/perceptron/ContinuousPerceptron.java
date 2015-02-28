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
        return 1.0/(1.0 + Math.pow(Math.E, -y)); // sigmoid function
    }

    /**
     *
     * @param tollerance
     */
    @Override
    public void learn(double tollerance){
        int it = 0;
        double err;
        do{
            err = iteration();
            System.out.println("iteration " + it++ + ", error: " + err);
        }while(err > tollerance);
    }
}

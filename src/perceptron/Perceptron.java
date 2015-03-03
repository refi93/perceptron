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
public interface Perceptron {    
    double activationFunction(double y);
    int learn(double tollerance);
}

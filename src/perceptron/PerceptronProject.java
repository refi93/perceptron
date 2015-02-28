/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author raf
 */
public class PerceptronProject {

    /**
     * @param csvFile
     * @return 
     * @throws java.io.FileNotFoundException
     */
    
    public static ArrayList<ArrayList<Double> > loadCsvData(String csvFile) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        ArrayList<ArrayList<Double> > ret = new ArrayList<>();
        
        while ((line = br.readLine()) != null) {
            ArrayList<Double> pom = new ArrayList<>();
            String[] inputs = line.split(",");
            for(String s : inputs){
                pom.add(Double.parseDouble(s)); 
            }
            ret.add(pom);
        }
        
        return ret;
    }
    
    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Double> > data = loadCsvData("or.csv");
        //DiscretePerceptron myPerceptron = new DiscretePerceptron(data, 0.5);
        //myPerceptron.learn();
        
        ContinuousPerceptron myContPerceptron = new ContinuousPerceptron(data, 0.8);
        myContPerceptron.learn(0.1);
    }
    
}

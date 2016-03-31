package com.gorkemgok.ec;

/**
 * Created by gorkemgok on 28.03.2016.
 */
public interface FitnessFunction<C extends Chromosome> {

    double calculateFitness(C individual);

}

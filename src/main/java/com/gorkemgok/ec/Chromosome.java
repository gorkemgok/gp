package com.gorkemgok.ec;

/**
 * Created by gorkemg on 28.03.2016.
 */
public interface Chromosome<T> {

    double getFitnessValue();

    void setFitnessValue(double fitnessValue);

    T getIndividual();

    void mutate(MutationMethod<T> mutationMethod, double probability);
}

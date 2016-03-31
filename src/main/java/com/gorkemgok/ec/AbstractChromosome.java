package com.gorkemgok.ec;

/**
 * Created by gorkemgok on 29/03/16.
 */
public abstract class AbstractChromosome<T> implements Chromosome<T>{

    private double fitnessValue;

    private T individual;

    public AbstractChromosome (T individual) {
        this.individual = individual;
    }

    public double getFitnessValue () {
        return fitnessValue;
    }

    public void setFitnessValue (double fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public T getIndividual () {
        return individual;
    }

    public void mutate (MutationMethod<T> mutationMethod, double probability) {
        individual = mutationMethod.apply (this, probability);
    }
}

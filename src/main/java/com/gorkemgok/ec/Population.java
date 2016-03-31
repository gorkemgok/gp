package com.gorkemgok.ec;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by gorkemgok on 28.03.2016.
 */
public class Population<C extends Chromosome> implements Iterable<C>{

    private C fittestChromosome;

    private int generationCount;

    private List<C> individuals;

    public Population(List<C> individuals) {
        this.individuals = individuals;
    }

    public void replacePopulation(List<C> newIndividuals){
        individuals = newIndividuals;
        generationCount++;
    }

    public int getGenerationCount() {
        return generationCount;
    }

    public Iterator<C> iterator() {
        return individuals.iterator ();
    }

    public int getPopulationSize() {
        return individuals.size();
    }

    public C getChromosome(int index){
        return individuals.get (index);
    }

    public C getFittest(){
        return fittestChromosome;
    }

    public boolean compareWithFittest(C chromosome){
        if (fittestChromosome == null || chromosome.getFitnessValue () > fittestChromosome.getFitnessValue ()){
            fittestChromosome = chromosome;
            return true;
        }
        return false;
    }
}

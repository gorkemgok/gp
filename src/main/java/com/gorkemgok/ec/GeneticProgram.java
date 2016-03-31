package com.gorkemgok.ec;

import com.gorkemgok.ec.listener.NewFittestListener;
import com.gorkemgok.ec.listener.NewGenerationListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorkemgok on 28.03.2016.
 */
public class GeneticProgram {

    private final Population<Chromosome> population;

    private final SelectionMethod selectionMethod;

    private final CrossoverMethod<Chromosome> crossoverMethod;

    private final MutationMethod mutationMethod;

    private final FitnessFunction<Chromosome> fitnessFunction;

    private final StopCondition stopCondition;

    private final GPConfiguration configuration;

    public GeneticProgram(Population population, SelectionMethod selectionMethod, CrossoverMethod crossoverMethod, MutationMethod mutationMethod, FitnessFunction<Chromosome> fitnessFunction, StopCondition stopCondition, GPConfiguration configuration) {
        this.population = population;
        this.selectionMethod = selectionMethod;
        this.crossoverMethod = crossoverMethod;
        this.mutationMethod = mutationMethod;
        this.fitnessFunction = fitnessFunction;
        this.stopCondition = stopCondition;
        this.configuration = configuration;
    }

    public void evolve(){
        long start = System.currentTimeMillis ();
        NewFittestListener newFittestListener = configuration.getNewFittestListener ();
        NewGenerationListener newGenerationListener = configuration.getNewGenerationListener ();
        double mutationProbability = configuration.getMutationProbability ();
        while (!stopCondition.satisfy(population)){
            //Calculate fitness
            for (Chromosome chromosome : population){
                fitnessFunction.calculateFitness(chromosome);
                //System.out.println(chromosome.getIndividual ()+ " ("+chromosome.getFitnessValue ()+ ")");
                if (population.compareWithFittest (chromosome)){
                    if (newFittestListener != null) {
                        newFittestListener.onNewFittest (population);
                    }
                }
            }
            //Select Individual pairs for sex
            List<ChromosomePair<Chromosome>> chromosomePairList = selectionMethod.select(population);

            //Apply crossover to Individual pairs
            List<Chromosome> offsetChromosomesList = new ArrayList<Chromosome>(population.getPopulationSize());
            for (ChromosomePair<Chromosome> chromosomePair : chromosomePairList){
                List<Chromosome> newBornChromosomes = crossoverMethod.apply(chromosomePair);
                newBornChromosomes.get (0).mutate (mutationMethod, mutationProbability );
                offsetChromosomesList.add(newBornChromosomes.get (0));
            }

            //Make way for the young
            population.replacePopulation(offsetChromosomesList);
            if (newGenerationListener != null){
                newGenerationListener.onNewGeneration (population);
            }
        }
        long end = System.currentTimeMillis ();
        System.out.println ("Stop condition reached at "+population.getGenerationCount ()+". generation in "+(end-start)+" ms");
    }
}

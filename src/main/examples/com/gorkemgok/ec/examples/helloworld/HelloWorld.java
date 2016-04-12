package com.gorkemgok.ec.examples.helloworld;

import com.gorkemgok.ec.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gorkemgok on 29/03/16.
 */
public class HelloWorld {

    public static void main(String [] args){

        int populationSize = 100;

        int chromosomesInTheRing = 10;

        int stopGenerationCount = 1000;

        double mutationProbability = 1;

        String targetString = "HELLO WORLD";

        Population<StringChromosome> initialPopulation = initiateRandomPopulation (populationSize, targetString.length ());

        SelectionMethod selectionMethod = new TournamentSelection (chromosomesInTheRing);

        CrossoverMethod crossoverMethod = new StringCrossover ();

        MutationMethod mutationMethod = new StringMutation ();

        FitnessFunction fitnessFunction = new StringFitnessFunction (targetString);

        StopCondition stopCondition = new HWStopCondition (12, stopGenerationCount);

        GPConfiguration configuration = new GPConfiguration ();

        configuration.setMutationProbability (mutationProbability);

        configuration.setNewFittestListener (new NewFittestStringListener ());

        //configuration.setNewGenerationListener (new NewStringGenerationListener ());

        GeneticProgram gp = new GeneticProgram (
                initialPopulation,
                selectionMethod,
                crossoverMethod,
                mutationMethod,
                fitnessFunction,
                stopCondition,
                configuration
        );

        gp.evolve ();
    }

    private static Population<StringChromosome> initiateRandomPopulation(int individualCount, int stringLen){
        List<StringChromosome> chromosomeList = new ArrayList<StringChromosome> (individualCount);
        for ( int i = 0; i < individualCount; i++ ) {
            String randomString = "";
            for ( int j = 0; j < stringLen; j++ ) {
                randomString += Util.randomChar ();
            }
            StringChromosome chromosome = new StringChromosome(randomString);
            chromosomeList.add (chromosome);
        }
        return new Population<StringChromosome> (chromosomeList);
    }

}

package com.gorkemgok.ec.examples.helloworld;

import com.gorkemgok.ec.Population;
import com.gorkemgok.ec.listener.NewGenerationListener;

/**
 * Created by gorkemgok on 29/03/16.
 */
public class NewStringGenerationListener implements NewGenerationListener<StringChromosome>{

    public void onNewGeneration (Population<StringChromosome> population) {
        System.out.println(population.getGenerationCount ()
                                   +". Generation with "+population.getPopulationSize ()+" ind. fittest: "
                                   +population.getFittest ().getIndividual ()
                                   +" ("+population.getFittest ().getFitnessValue ()+" )"
        );
    }
}

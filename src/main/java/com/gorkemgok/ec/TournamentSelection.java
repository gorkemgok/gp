package com.gorkemgok.ec;

import java.util.*;

/**
 * Created by gorkemgok on 29/03/16.
 */
public class TournamentSelection implements SelectionMethod{

    private int tournamentChromosomeCount;

    public TournamentSelection (int tournamentChromosomeCount) {
        this.tournamentChromosomeCount = tournamentChromosomeCount;
    }

    public List<ChromosomePair<Chromosome>> select (Population population) {
        int populationSize = population.getPopulationSize ();
        List<ChromosomePair<Chromosome>> selectedChromosomes = new ArrayList<ChromosomePair<Chromosome>> ();
        List<Chromosome> chromosomesToFight = new ArrayList<Chromosome> ();
        for ( int i = 0; i < populationSize; i++ ) {
            chromosomesToFight.clear ();
            for ( int j = 0; j < tournamentChromosomeCount; j++ ) {
                chromosomesToFight.add (population.getChromosome (Util.randomInt (populationSize - 1)));
            }
            selectedChromosomes.add (fight (chromosomesToFight));
        }
        return selectedChromosomes;
    }

    public ChromosomePair<Chromosome> fight(List<Chromosome> chromosomeList){
        Collections.sort (chromosomeList, new Comparator<Chromosome> () {
            public int compare (Chromosome o1, Chromosome o2) {
                return o1.getFitnessValue () > o2.getFitnessValue () ? -1 : o1.getFitnessValue () < o2.getFitnessValue () ? 1 : 0;
            }
        });

        return new ChromosomePair<Chromosome> (chromosomeList.get (0), chromosomeList.get (1));
    }
}

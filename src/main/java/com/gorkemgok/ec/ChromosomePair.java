package com.gorkemgok.ec;

/**
 * Created by gorkemg on 28.03.2016.
 */
public class ChromosomePair<C extends Chromosome> {

    private C individual1;

    private C individual2;

    public ChromosomePair(C individual1, C individual2) {
        this.individual1 = individual1;
        this.individual2 = individual2;
    }

    public C getIndividual1() {
        return individual1;
    }

    public C getIndividual2() {
        return individual2;
    }
}

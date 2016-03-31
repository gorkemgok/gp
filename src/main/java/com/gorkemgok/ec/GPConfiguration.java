package com.gorkemgok.ec;

import com.gorkemgok.ec.listener.NewFittestListener;
import com.gorkemgok.ec.listener.NewGenerationListener;

/**
 * Created by gorkemg on 28.03.2016.
 */
public class GPConfiguration {

    private double mutationProbability;

    private NewFittestListener newFittestListener;

    private NewGenerationListener newGenerationListener;

    public void setMutationProbability(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public double getMutationProbability() {
        return mutationProbability;
    }

    public NewFittestListener getNewFittestListener () {
        return newFittestListener;
    }

    public void setNewFittestListener (NewFittestListener newFittestListener) {
        this.newFittestListener = newFittestListener;
    }

    public NewGenerationListener getNewGenerationListener () {
        return newGenerationListener;
    }

    public void setNewGenerationListener (NewGenerationListener newGenerationListener) {
        this.newGenerationListener = newGenerationListener;
    }
}

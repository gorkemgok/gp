package com.gorkemgok.ec.listener;

import com.gorkemgok.ec.Chromosome;
import com.gorkemgok.ec.Population;

/**
 * Created by gorkemgok on 29/03/16.
 */
public interface NewGenerationListener<C extends Chromosome> {

    void onNewGeneration(Population<C> population);
}

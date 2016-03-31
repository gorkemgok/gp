package com.gorkemgok.ec.listener;

import com.gorkemgok.ec.Chromosome;
import com.gorkemgok.ec.Population;

/**
 * Created by gorkemgok on 29/03/16.
 */
public interface NewFittestListener<C extends Chromosome> {

    void onNewFittest(Population<C> population);

}

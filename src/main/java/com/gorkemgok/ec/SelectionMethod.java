package com.gorkemgok.ec;

import java.util.List;

/**
 * Created by gorkemg on 28.03.2016.
 */
public interface SelectionMethod {

    <C extends Chromosome> List<ChromosomePair<C>> select(Population<C> population);
}

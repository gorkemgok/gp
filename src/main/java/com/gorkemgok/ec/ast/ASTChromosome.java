package com.gorkemgok.ec.ast;

import com.gorkemgok.ec.AbstractChromosome;
import com.gorkemgok.ec.Chromosome;
import com.gorkemgok.ec.MutationMethod;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class ASTChromosome extends AbstractChromosome<RootNode> {

    public ASTChromosome (RootNode individual) {
        super (individual);
    }

    @Override
    public String toString () {
        return getIndividual ().toString ();
    }
}

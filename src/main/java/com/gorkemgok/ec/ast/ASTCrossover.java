package com.gorkemgok.ec.ast;

import com.gorkemgok.ec.ChromosomePair;
import com.gorkemgok.ec.CrossoverMethod;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class ASTCrossover implements CrossoverMethod<ASTChromosome>{

    public List<ASTChromosome> apply (ChromosomePair<ASTChromosome> pair) {
        RootNode individual1 = pair.getIndividual1 ().getIndividual ();
        RootNode individual2 = pair.getIndividual2 ().getIndividual ();

        Node node1 = individual1.getRandomNode ();
        Node node2 = individual2.getRandomNode (node1.getType ());

        individual1.setChildNode (node2, individual1.getChildNodeIndex (node1));
        individual2.setChildNode (node1, individual1.getChildNodeIndex (node2));

        return Arrays.asList (new ASTChromosome (individual1), new ASTChromosome (individual2));
    }
}

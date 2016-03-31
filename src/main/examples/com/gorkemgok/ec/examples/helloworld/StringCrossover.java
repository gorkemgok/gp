package com.gorkemgok.ec.examples.helloworld;

import com.gorkemgok.ec.ChromosomePair;
import com.gorkemgok.ec.CrossoverMethod;
import com.gorkemgok.ec.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorkemgok on 29/03/16.
 */
public class StringCrossover implements CrossoverMethod<StringChromosome> {

    public List<StringChromosome> apply (ChromosomePair<StringChromosome> pair) {
        List<StringChromosome> offsets = new ArrayList<StringChromosome> ();
        String s1 = pair.getIndividual1 ().getIndividual ();
        String s2 = pair.getIndividual2 ().getIndividual ();
        int minLen = Math.min (s1.length (), s2.length ()
        );
        int crossOverPoint = Util.randomInt (minLen - 2);
        StringBuilder offset1 = new StringBuilder ();
        offset1.append (s1.substring (0, crossOverPoint))
               .append (s2.substring (crossOverPoint));

        StringBuilder offset2 = new StringBuilder ();
        offset2.append (s2.substring (0, crossOverPoint))
               .append (s1.substring (crossOverPoint));

        offsets.add (new StringChromosome (offset1.toString ()));
        offsets.add (new StringChromosome (offset2.toString ()));
        pair.getIndividual1 ().setParents (null, null);
        pair.getIndividual2 ().setParents (null, null);
        offsets.get (0).setParents (pair.getIndividual1 (), pair.getIndividual2 ());
        offsets.get (1).setParents (pair.getIndividual1 (), pair.getIndividual2 ());

        //System.out.println (s1 + " X " +s2+" = "+offsets.get (0));

        return offsets;
    }
}

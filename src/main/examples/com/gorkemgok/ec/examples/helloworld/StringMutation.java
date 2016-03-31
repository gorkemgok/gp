package com.gorkemgok.ec.examples.helloworld;

import com.gorkemgok.ec.Chromosome;
import com.gorkemgok.ec.MutationMethod;
import com.gorkemgok.ec.Util;

/**
 * Created by gorkemgok on 29/03/16.
 */
public class StringMutation implements MutationMethod<String> {


    public String apply (Chromosome<String> chromosome, double probability) {
        String individual = chromosome.getIndividual ();
        if (probability > Util.randomDouble ()){
            char[] chars = individual.toCharArray ();
            chars[Util.randomInt (chars.length - 1)] = Util.randomChar ();
            String newString = new String (chars);
            //System.out.println ("!Mutation:"+individual+" > "+newString);
            return newString;
        }
        //System.out.println ("No mutation!");
        return individual;
    }
}

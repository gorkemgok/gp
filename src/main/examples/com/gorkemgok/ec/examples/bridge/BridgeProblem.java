package com.gorkemgok.ec.examples.bridge;

import com.gorkemgok.ec.ast.RootNode;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class BridgeProblem {

    public static void main(String[] args){


    }

    public static void runWithoutGP(){

        Person A = new Person ("A", 1);
        Person B = new Person ("B", 2);
        Person C = new Person ("C", 5);
        Person D = new Person ("D", 8);
        Person NONE = new Person ("NONE");
        Person SLOWEST = new Person ("SLOWEST");
        Person FASTEST = new Person ("FASTEST");

        RootNode rootNode = new RootNode ();

        SelectPerson selectPerson = new SelectPerson (A);
        Move move = new Move (Move.Type.CROSS);
        move.setPersonSelector (selectPerson);

    }
}

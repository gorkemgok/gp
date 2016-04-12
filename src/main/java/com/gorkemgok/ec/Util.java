package com.gorkemgok.ec;

import com.gorkemgok.ec.ast.FunctionNode;
import com.gorkemgok.ec.ast.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gorkemgok on 29/03/16.
 */
public class Util {

    public static final byte[] UPPER_CASE_ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','R','S','T','U','V','Y','Z','W','Q','X',' '};

    public static final char[] UPPER_CASE_CHARS = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','R','S','T','U','V','Y','Z','W','Q','X',' '};

    public static Random random = new Random ();

    public static int randomInt(int n){
        return random.nextInt (n);
    }

    public static double randomDouble(){
        return random.nextDouble ();
    }

    public static char randomChar(){
        return UPPER_CASE_CHARS[randomInt (UPPER_CASE_CHARS.length)];
    }

    public static <T> T randomFromList(List<T> list){
        if (!list.isEmpty ()) {
            return list.get (randomInt (list.size () - 1));
        }
        return null;
    }

    public static List<Node> getAllNestedNodes(List<? extends Node> nodes){
        List<Node> allNodes = new ArrayList<Node> ();
        for ( Node node :
                nodes ) {
            if (node != null) {
                allNodes.add (node);
                if ( node instanceof FunctionNode ) {
                    allNodes.addAll (((FunctionNode) node).getNestedNodes ());
                }
            }
        }
        return allNodes;
    }
}

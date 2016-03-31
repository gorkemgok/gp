package com.gorkemgok.ec.examples.bridge;

import com.gorkemgok.ec.ast.Node;
import com.gorkemgok.ec.ast.NodeType;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class Person implements Node {

    private String identifier;

    private int moveTime;

    public Person (String identifier) {
        this.identifier = identifier;
    }

    public Person (String identifier, int moveTime) {
        this.identifier = identifier;
        this.moveTime = moveTime;
    }

    public NodeType getType () {
        return BPNodeTypes.TRM_PERSON_WITH;
    }

    public int getMoveTime () {
        return moveTime;
    }
}

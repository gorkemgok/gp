package com.gorkemgok.ec.examples.bridge;

import com.gorkemgok.ec.ast.FunctionNode;
import com.gorkemgok.ec.ast.Node;
import com.gorkemgok.ec.ast.NodeType;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class Move implements FunctionNode{

    public enum Type{
        STOP,
        CROSS;
    }

    private Type type;

    private SelectPerson personSelector;

    private Move nextCross;

    public Move (Type type) {
        this.type = type;
    }

    public Move getNextMove () {
        return nextCross;
    }

    public void setNextMove (Move nextCross) {
        this.nextCross = nextCross;
    }

    public SelectPerson getPersonSelector () {
        return personSelector;
    }

    public void setPersonSelector (SelectPerson personSelector) {
        this.personSelector = personSelector;
    }

    public NodeType getType () {
        return BPNodeTypes.FN_CROSS;
    }

    public int totalChildNodeCount () {
        return 1;
    }

    public Node getChildNode (int index) {
        if (index == 0){
            return personSelector.selectPerson ();
        }
        throw new NoSuchElementException ("No Node for index "+index);
    }

    public void setChildNode (Node newNode, int index) {
        if (index == 0){
            personSelector = (SelectPerson) newNode;
        }
        throw new NoSuchElementException ("No Node to set for index "+index);
    }

    public int getChildNodeIndex (Node node) {
        if (node == personSelector) {
            return 0;
        }
        throw new NoSuchElementException ("No Node found");
    }


    public List<Node> getAllNodes () {
        return null;
    }

    public List<Node> getNodes (NodeType type) {
        return null;
    }

    public Node getRandomNode (NodeType type) {
        return null;
    }

    public Node getRandomNode () {
        return null;
    }
}

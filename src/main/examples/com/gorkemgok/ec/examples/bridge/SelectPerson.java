package com.gorkemgok.ec.examples.bridge;

import com.gorkemgok.ec.ast.FunctionNode;
import com.gorkemgok.ec.ast.Node;
import com.gorkemgok.ec.ast.NodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class SelectPerson implements FunctionNode{

    private Person person;

    public SelectPerson (Person person) {
        this.person = person;
    }

    public Person selectPerson () {
        return person;
    }

    public NodeType getType () {
        return null;
    }

    public int totalChildNodeCount () {
        return 1;
    }

    public Node getChildNode (int index) {
        if (index == 0){
            return person;
        }
        throw new NoSuchElementException ("No Node for index "+index);
    }

    public void setChildNode (Node newNode, int index) {
        if (index == 0){
            person = (Person) newNode;
        }
        throw new NoSuchElementException ("No Node to set for index "+index);
    }

    public int getChildNodeIndex (Node node) {
        if (node == person ) {
            return 0;
        }
        throw new NoSuchElementException ("No Node found");
    }


    public List<? extends Node> getAllNodes () {
        return Arrays.asList (person);
    }

    public List<? extends Node> getNodes (NodeType type) {
        if (type.equals (person.getType ())){
            return Arrays.asList (person);
        }
        return new ArrayList<Node> ();
    }

    public Node getRandomNode (NodeType type) {
        if (type.equals (person.getType ())){
            return person;
        }
        return null;
    }

    public Node getRandomNode () {
        return person;
    }
}

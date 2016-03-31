package com.gorkemgok.ec.ast;

/**
 * Created by gorkemgok on 30/03/16.
 */
public interface FunctionNode extends Node, NodePool {

    int totalChildNodeCount ();

    Node getChildNode (int index);

    void setChildNode (Node newNode, int index);

    int getChildNodeIndex (Node node);

}

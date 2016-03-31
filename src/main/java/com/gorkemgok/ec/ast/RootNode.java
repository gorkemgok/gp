package com.gorkemgok.ec.ast;

import java.util.List;

/**
 * Created by gorkemgok on 30/03/16.
 */
public class RootNode implements FunctionNode{

    private List<FunctionNode> functionNode;

    public int totalChildNodeCount () {
        return 0;
    }

    public Node getChildNode (int index) {
        return null;
    }

    public void setChildNode (Node newNode, int index) {

    }

    public int getChildNodeIndex (Node node) {
        return 0;
    }

    public NodeType getType () {
        return null;
    }

    public List<? extends Node> getAllNodes () {
        return null;
    }

    public List<? extends Node> getNodes (NodeType type) {
        return null;
    }

    public Node getRandomNode (NodeType type) {
        return null;
    }

    public Node getRandomNode () {
        return null;
    }
}

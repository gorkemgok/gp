package com.gorkemgok.ec.ast;

import java.util.List;

/**
 * Created by gorkemg on 28.03.2016.
 */
public interface NodePool {

    List<? extends Node> getAllNodes();

    List<? extends Node> getNodes(NodeType type);

    Node getRandomNode(NodeType type);

    Node getRandomNode();
}


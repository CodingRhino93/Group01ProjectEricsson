package com.example.demo;

import java.util.Collection;

public interface NodeRepository
{
    Collection<Node> getNodes();

    Node getNode(int id);

    int addNewNode(Node node);

    boolean updateNode(int id, String name);

    boolean deleteNode(int id);

}

package com.example.demo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class NodeRepositoryImpl implements NodeRepository
{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Collection<Node> getNodes() {
        String jpql = "select n from Node n";
        TypedQuery<Node> query = entityManager.createQuery(jpql, Node.class);
        return query.getResultList();
    }

    @Override
    public Node getNode(int id) {
        return entityManager.find(Node.class, id);
    }

    @Override
    @Transactional
    public int addNewNode(Node node) {
        entityManager.persist(node);
        entityManager.flush();
        return node.getNodeID();
    }

    @Override
    @Transactional
    public boolean updateNode(int id, String name) {
        Node node = entityManager.find(Node.class, id);
        if (node == null) {
            return false;
        }
        else {
            node.setName(name);
            return true;
        }
    }
    @Override
    public void deleteNode() {
        
    }
}

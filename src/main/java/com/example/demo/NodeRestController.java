package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@Controller
@CrossOrigin
public class NodeRestController
{
    @Autowired
    private NodeRepository repository;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Collection<Node>> getAllNodes() {
        Collection<Node> result = repository.getNodes();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<Node> insertNode(@RequestBody Node node) {
        int id = repository.addNewNode(node);
        node.setNodeID(id);
        URI uri = URI.create("/" + id);
        return ResponseEntity.created(uri).body(node);
    }

    @GetMapping(value="/{id}", produces={"application/json","application/xml"})
    public ResponseEntity<Node> getNode(@PathVariable int id) {
        Node result = repository.getNode(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(result);
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity modifyName(@PathVariable int id, @RequestParam String name) {
        if (!repository.updateNode(id, name)) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().build();
        }
    }

}

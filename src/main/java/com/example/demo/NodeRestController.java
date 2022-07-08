package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Map;

@RestController
@CrossOrigin
public class NodeRestController
{
    @Autowired
    private NodeRepository repository;

    @Autowired
    private Map<Integer, Node> catalog;

    @GetMapping(value="/nodes", produces={"application/json","application/xml"})
    public ResponseEntity<Collection<Node>> getAllNodes() {
        Collection<Node> result = repository.getNodes();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value="/nodes", consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<Node> insertNode(@RequestBody Node node) {
        int id = repository.addNewNode(node);
        node.setNodeID(id);
        URI uri = URI.create("/" + id);
        return ResponseEntity.created(uri).body(node);
    }

    @GetMapping(value="/nodes/{id}", produces={"application/json","application/xml"})
    public ResponseEntity<Node> getNode(@PathVariable int id) {
        Node result = repository.getNode(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(result);
        }
    }

    @PutMapping(value="/nodes/{id}")
    public ResponseEntity modifyName(@PathVariable int id, @RequestParam String name) {
        if (!repository.updateNode(id, name)) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping(value="/nodes/{id}")
    public ResponseEntity deleteOneNode(@PathVariable int id) {
        repository.deleteNode(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/addNode")
    public String showCart(Model model) {
//        model.addAttribute("cart", service.getAllItemsInCart());
//        model.addAttribute("cartCost", String.format("£%.2f", service.calculateCartCost()));
//        model.addAttribute("salesTax", String.format("£%.2f", service.calculateSalesTax()));
//        model.addAttribute("deliveryCharge", String.format("£%.2f", service.calculateDeliveryCharge()));
        return "newNode";
    }

}

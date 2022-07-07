package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//node class entity
@Entity
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nodeID;

    private String name;
    private String location;
    private double latitude;
    private double longitude;


    public Node() {
    }

    public Node(int nodeId, String name, String location, double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.location = location;
        this.nodeID = nodeId;
    }

    public int getNodeID()
    {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName()
    {
        return name;
    }

    //name setter lol
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("[%d], %s, Location: %s, long: %f, lat: %f", nodeID, name, location, longitude, latitude);
    }
}

package com.clarence.examples.hibernateonetomanymappingarray;

import java.util.*;

public class Group {
    
    private int id;
    private String name;
    
    // Group object has an array of Story objects
    private Story[] stories;
    
    public void setStories(Story[] l) {
        stories = l;
    }
    
    public Story[] getStories() {
        return stories;
    }
    
    public Group(){
    }
    
    public Group(String name) {
        this.name = name;
    }
    
    public void setId(int i) {
        id = i;
    }
    
    public int getId() {
        return id;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
    
}
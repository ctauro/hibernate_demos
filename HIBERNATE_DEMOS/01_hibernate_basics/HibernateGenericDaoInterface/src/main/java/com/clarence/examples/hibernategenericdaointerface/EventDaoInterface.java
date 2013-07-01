/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clarence.examples.hibernategenericdaointerface;

import java.util.List;

public interface EventDaoInterface {
    public void create(Event event) throws DataAccessLayerException; 
    public void delete(Event event) throws DataAccessLayerException; 
    public Event find(Long id) throws DataAccessLayerException; 
    public void update(Event event) throws DataAccessLayerException;
    public List findAll() throws DataAccessLayerException;
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clarence.examples.hibernatesimpledao;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * The Data Access Object for managing the persistent Events.
 *
 */
public class SimpleEventDao {
    Log log = LogFactory.getLog(SimpleEventDao.class);
    private Session session;
    private Transaction tx;

    public SimpleEventDao() {
        HibernateFactory.buildIfNeeded();
    }

    /**
     * Insert a new Event into the database.
     * @param event
     */
    public void create(Event event) throws DataAccessLayerException {
        log.info("create() method is called");
        try {
            startOperation();
            session.save(event);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }


    /**
     * Delete a detached Event from the database.
     * @param event
     */
    public void delete(Event event) throws DataAccessLayerException {
        log.info("delete() method is called");
        try {
            startOperation();
            session.delete(event);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }
    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Event find(Long id) throws DataAccessLayerException {
        log.info("find() method is called");
        Event event = null;
        try {
            startOperation();
            event = (Event) session.load(Event.class, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            //HibernateFactory.close(session);
        }
        return event;
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Event event) throws DataAccessLayerException {
        log.info("update() method is called");
        try {
            startOperation();
            session.update(event);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        log.info("findAll() method is called");
        List events = null;
        try {
            startOperation();
            Query query = session.createQuery("from Event");
            events =  query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return events;
    }

    private void handleException(HibernateException e) throws DataAccessLayerException {
        log.debug("Exception has occurred");
        HibernateFactory.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    private void startOperation() throws HibernateException {
        session = HibernateFactory.openSession();
        tx = session.beginTransaction();
    }

}

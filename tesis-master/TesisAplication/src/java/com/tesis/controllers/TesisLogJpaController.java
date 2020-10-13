/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisLog;
import com.tesis.utils.JpaUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * @author luis.chavez
 */
public class TesisLogJpaController implements Serializable {

    public TesisLogJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisLog tesisLog) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tesisLog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisLog tesisLog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tesisLog = em.merge(tesisLog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisLog.getCodTesisLog();
                if (findTesisLog(id) == null) {
                    throw new NonexistentEntityException("The tesisLog with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisLog tesisLog;
            try {
                tesisLog = em.getReference(TesisLog.class, id);
                tesisLog.getCodTesisLog();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisLog with id " + id + " no longer exists.", enfe);
            }
            em.remove(tesisLog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisLog> findTesisLogEntities() {
        return findTesisLogEntities(true, -1, -1);
    }

    public List<TesisLog> findTesisLogEntities(int maxResults, int firstResult) {
        return findTesisLogEntities(false, maxResults, firstResult);
    }

    private List<TesisLog> findTesisLogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisLog.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TesisLog findTesisLog(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisLog.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisLogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisLog> rt = cq.from(TesisLog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<TesisLog> findAllLog() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisLog> query = em.createQuery("SELECT log FROM TesisLog log ORDER BY log.createdDate DESC", TesisLog.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
      public List<TesisLog> findAllLogByCriteria(Date from, Date to) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisLog> query = em.createQuery("SELECT log FROM TesisLog log WHERE log.createdDate BETWEEN :from AND :to ORDER BY log.createdDate DESC", TesisLog.class);
            TypedQuery<TesisLog> resul = query.setParameter("from", from, TemporalType.DATE).setParameter("to", to, TemporalType.DATE);
            return resul.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisLog> findAllLogByCriteriaUser(Date from, Date to, String user) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisLog> query = em.createQuery("SELECT log FROM TesisLog log WHERE LOWER(log.createdBy) LIKE LOWER(:user) AND log.createdDate BETWEEN :from AND :to ORDER BY log.createdDate DESC", TesisLog.class);
            TypedQuery<TesisLog> resul = query.setParameter("user", "%" + user + "%").setParameter("from", from, TemporalType.DATE).setParameter("to", to, TemporalType.DATE);
            return resul.getResultList();
        } finally {
            em.close();
        }
    }

}

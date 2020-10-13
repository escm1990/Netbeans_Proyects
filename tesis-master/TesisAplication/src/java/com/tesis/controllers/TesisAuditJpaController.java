/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisAudit;
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
public class TesisAuditJpaController implements Serializable {

    public TesisAuditJpaController() {
       this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisAudit tesisAudit) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tesisAudit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisAudit tesisAudit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tesisAudit = em.merge(tesisAudit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisAudit.getCodTesisAudit();
                if (findTesisAudit(id) == null) {
                    throw new NonexistentEntityException("The tesisAudit with id " + id + " no longer exists.");
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
            TesisAudit tesisAudit;
            try {
                tesisAudit = em.getReference(TesisAudit.class, id);
                tesisAudit.getCodTesisAudit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisAudit with id " + id + " no longer exists.", enfe);
            }
            em.remove(tesisAudit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisAudit> findTesisAuditEntities() {
        return findTesisAuditEntities(true, -1, -1);
    }

    public List<TesisAudit> findTesisAuditEntities(int maxResults, int firstResult) {
        return findTesisAuditEntities(false, maxResults, firstResult);
    }

    private List<TesisAudit> findTesisAuditEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisAudit.class));
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

    public TesisAudit findTesisAudit(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisAudit.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisAuditCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisAudit> rt = cq.from(TesisAudit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisAudit> findAllAuditByCriteria(Date from, Date to, String module, String description) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisAudit> query = em.createQuery("SELECT audit FROM TesisAudit audit WHERE audit.module =:module AND audit.description =:description AND audit.visitDate BETWEEN :from AND :to ORDER BY audit.visitDate DESC", TesisAudit.class);
            TypedQuery<TesisAudit> resul = query.setParameter("description", description).setParameter("module", module).setParameter("from", from, TemporalType.DATE).setParameter("to", to, TemporalType.DATE);
            return resul.getResultList();
        } finally {
            em.close();
        }
    }


}

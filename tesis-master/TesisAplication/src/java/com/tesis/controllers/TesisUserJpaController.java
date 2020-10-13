/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisUser;
import com.tesis.model.entity.TesisUserCampus;
import com.tesis.utils.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * @author luis.chavez
 */
public class TesisUserJpaController implements Serializable {

    public TesisUserJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisUser tesisUser) {
        if (tesisUser.getTesisUserCampusCollection() == null) {
            tesisUser.setTesisUserCampusCollection(new ArrayList<TesisUserCampus>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TesisUserCampus> attachedTesisUserCampusCollection = new ArrayList<TesisUserCampus>();
            for (TesisUserCampus tesisUserCampusCollectionTesisUserCampusToAttach : tesisUser.getTesisUserCampusCollection()) {
                tesisUserCampusCollectionTesisUserCampusToAttach = em.getReference(tesisUserCampusCollectionTesisUserCampusToAttach.getClass(), tesisUserCampusCollectionTesisUserCampusToAttach.getCodTesisUserCampus());
                attachedTesisUserCampusCollection.add(tesisUserCampusCollectionTesisUserCampusToAttach);
            }
            tesisUser.setTesisUserCampusCollection(attachedTesisUserCampusCollection);
            em.persist(tesisUser);
            for (TesisUserCampus tesisUserCampusCollectionTesisUserCampus : tesisUser.getTesisUserCampusCollection()) {
                TesisUser oldFkTesisUserOfTesisUserCampusCollectionTesisUserCampus = tesisUserCampusCollectionTesisUserCampus.getFkTesisUser();
                tesisUserCampusCollectionTesisUserCampus.setFkTesisUser(tesisUser);
                tesisUserCampusCollectionTesisUserCampus = em.merge(tesisUserCampusCollectionTesisUserCampus);
                if (oldFkTesisUserOfTesisUserCampusCollectionTesisUserCampus != null) {
                    oldFkTesisUserOfTesisUserCampusCollectionTesisUserCampus.getTesisUserCampusCollection().remove(tesisUserCampusCollectionTesisUserCampus);
                    oldFkTesisUserOfTesisUserCampusCollectionTesisUserCampus = em.merge(oldFkTesisUserOfTesisUserCampusCollectionTesisUserCampus);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisUser tesisUser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisUser persistentTesisUser = em.find(TesisUser.class, tesisUser.getCodTesisUser());
            Collection<TesisUserCampus> tesisUserCampusCollectionOld = persistentTesisUser.getTesisUserCampusCollection();
            Collection<TesisUserCampus> tesisUserCampusCollectionNew = tesisUser.getTesisUserCampusCollection();
            Collection<TesisUserCampus> attachedTesisUserCampusCollectionNew = new ArrayList<TesisUserCampus>();
            for (TesisUserCampus tesisUserCampusCollectionNewTesisUserCampusToAttach : tesisUserCampusCollectionNew) {
                tesisUserCampusCollectionNewTesisUserCampusToAttach = em.getReference(tesisUserCampusCollectionNewTesisUserCampusToAttach.getClass(), tesisUserCampusCollectionNewTesisUserCampusToAttach.getCodTesisUserCampus());
                attachedTesisUserCampusCollectionNew.add(tesisUserCampusCollectionNewTesisUserCampusToAttach);
            }
            tesisUserCampusCollectionNew = attachedTesisUserCampusCollectionNew;
            tesisUser.setTesisUserCampusCollection(tesisUserCampusCollectionNew);
            tesisUser = em.merge(tesisUser);
            for (TesisUserCampus tesisUserCampusCollectionOldTesisUserCampus : tesisUserCampusCollectionOld) {
                if (!tesisUserCampusCollectionNew.contains(tesisUserCampusCollectionOldTesisUserCampus)) {
                    tesisUserCampusCollectionOldTesisUserCampus.setFkTesisUser(null);
                    tesisUserCampusCollectionOldTesisUserCampus = em.merge(tesisUserCampusCollectionOldTesisUserCampus);
                }
            }
            for (TesisUserCampus tesisUserCampusCollectionNewTesisUserCampus : tesisUserCampusCollectionNew) {
                if (!tesisUserCampusCollectionOld.contains(tesisUserCampusCollectionNewTesisUserCampus)) {
                    TesisUser oldFkTesisUserOfTesisUserCampusCollectionNewTesisUserCampus = tesisUserCampusCollectionNewTesisUserCampus.getFkTesisUser();
                    tesisUserCampusCollectionNewTesisUserCampus.setFkTesisUser(tesisUser);
                    tesisUserCampusCollectionNewTesisUserCampus = em.merge(tesisUserCampusCollectionNewTesisUserCampus);
                    if (oldFkTesisUserOfTesisUserCampusCollectionNewTesisUserCampus != null && !oldFkTesisUserOfTesisUserCampusCollectionNewTesisUserCampus.equals(tesisUser)) {
                        oldFkTesisUserOfTesisUserCampusCollectionNewTesisUserCampus.getTesisUserCampusCollection().remove(tesisUserCampusCollectionNewTesisUserCampus);
                        oldFkTesisUserOfTesisUserCampusCollectionNewTesisUserCampus = em.merge(oldFkTesisUserOfTesisUserCampusCollectionNewTesisUserCampus);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisUser.getCodTesisUser();
                if (findTesisUser(id) == null) {
                    throw new NonexistentEntityException("The tesisUser with id " + id + " no longer exists.");
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
            TesisUser tesisUser;
            try {
                tesisUser = em.getReference(TesisUser.class, id);
                tesisUser.getCodTesisUser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisUser with id " + id + " no longer exists.", enfe);
            }
            Collection<TesisUserCampus> tesisUserCampusCollection = tesisUser.getTesisUserCampusCollection();
            for (TesisUserCampus tesisUserCampusCollectionTesisUserCampus : tesisUserCampusCollection) {
                tesisUserCampusCollectionTesisUserCampus.setFkTesisUser(null);
                tesisUserCampusCollectionTesisUserCampus = em.merge(tesisUserCampusCollectionTesisUserCampus);
            }
            em.remove(tesisUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisUser> findTesisUserEntities() {
        return findTesisUserEntities(true, -1, -1);
    }

    public List<TesisUser> findTesisUserEntities(int maxResults, int firstResult) {
        return findTesisUserEntities(false, maxResults, firstResult);
    }

    private List<TesisUser> findTesisUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisUser.class));
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

    public TesisUser findTesisUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisUser.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisUser> rt = cq.from(TesisUser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public TesisUser findTesisUserByUserName(String name) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisUser> query = em.createQuery("SELECT user FROM TesisUser user WHERE user.userName =:name", TesisUser.class);
            return query.setParameter("name", name).getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<TesisUser> findAllUsers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisUser> query = em.createQuery("SELECT users FROM TesisUser users ORDER BY users.updateDate DESC", TesisUser.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}

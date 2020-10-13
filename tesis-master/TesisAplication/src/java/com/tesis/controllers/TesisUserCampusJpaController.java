/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisUser;
import com.tesis.model.entity.TesisUserCampus;
import com.tesis.utils.JpaUtil;
import java.io.Serializable;
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
public class TesisUserCampusJpaController implements Serializable {

    public TesisUserCampusJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisUserCampus tesisUserCampus) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisUser fkTesisUser = tesisUserCampus.getFkTesisUser();
            if (fkTesisUser != null) {
                fkTesisUser = em.getReference(fkTesisUser.getClass(), fkTesisUser.getCodTesisUser());
                tesisUserCampus.setFkTesisUser(fkTesisUser);
            }
            TesisCampus fkTesisCampus = tesisUserCampus.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus = em.getReference(fkTesisCampus.getClass(), fkTesisCampus.getCodTesisCampus());
                tesisUserCampus.setFkTesisCampus(fkTesisCampus);
            }
            em.persist(tesisUserCampus);
            if (fkTesisUser != null) {
                fkTesisUser.getTesisUserCampusCollection().add(tesisUserCampus);
                fkTesisUser = em.merge(fkTesisUser);
            }
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisUserCampusCollection().add(tesisUserCampus);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisUserCampus tesisUserCampus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisUserCampus persistentTesisUserCampus = em.find(TesisUserCampus.class, tesisUserCampus.getCodTesisUserCampus());
            TesisUser fkTesisUserOld = persistentTesisUserCampus.getFkTesisUser();
            TesisUser fkTesisUserNew = tesisUserCampus.getFkTesisUser();
            TesisCampus fkTesisCampusOld = persistentTesisUserCampus.getFkTesisCampus();
            TesisCampus fkTesisCampusNew = tesisUserCampus.getFkTesisCampus();
            if (fkTesisUserNew != null) {
                fkTesisUserNew = em.getReference(fkTesisUserNew.getClass(), fkTesisUserNew.getCodTesisUser());
                tesisUserCampus.setFkTesisUser(fkTesisUserNew);
            }
            if (fkTesisCampusNew != null) {
                fkTesisCampusNew = em.getReference(fkTesisCampusNew.getClass(), fkTesisCampusNew.getCodTesisCampus());
                tesisUserCampus.setFkTesisCampus(fkTesisCampusNew);
            }
            tesisUserCampus = em.merge(tesisUserCampus);
            if (fkTesisUserOld != null && !fkTesisUserOld.equals(fkTesisUserNew)) {
                fkTesisUserOld.getTesisUserCampusCollection().remove(tesisUserCampus);
                fkTesisUserOld = em.merge(fkTesisUserOld);
            }
            if (fkTesisUserNew != null && !fkTesisUserNew.equals(fkTesisUserOld)) {
                fkTesisUserNew.getTesisUserCampusCollection().add(tesisUserCampus);
                fkTesisUserNew = em.merge(fkTesisUserNew);
            }
            if (fkTesisCampusOld != null && !fkTesisCampusOld.equals(fkTesisCampusNew)) {
                fkTesisCampusOld.getTesisUserCampusCollection().remove(tesisUserCampus);
                fkTesisCampusOld = em.merge(fkTesisCampusOld);
            }
            if (fkTesisCampusNew != null && !fkTesisCampusNew.equals(fkTesisCampusOld)) {
                fkTesisCampusNew.getTesisUserCampusCollection().add(tesisUserCampus);
                fkTesisCampusNew = em.merge(fkTesisCampusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisUserCampus.getCodTesisUserCampus();
                if (findTesisUserCampus(id) == null) {
                    throw new NonexistentEntityException("The tesisUserCampus with id " + id + " no longer exists.");
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
            TesisUserCampus tesisUserCampus;
            try {
                tesisUserCampus = em.getReference(TesisUserCampus.class, id);
                tesisUserCampus.getCodTesisUserCampus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisUserCampus with id " + id + " no longer exists.", enfe);
            }
            TesisUser fkTesisUser = tesisUserCampus.getFkTesisUser();
            if (fkTesisUser != null) {
                fkTesisUser.getTesisUserCampusCollection().remove(tesisUserCampus);
                fkTesisUser = em.merge(fkTesisUser);
            }
            TesisCampus fkTesisCampus = tesisUserCampus.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisUserCampusCollection().remove(tesisUserCampus);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.remove(tesisUserCampus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisUserCampus> findTesisUserCampusEntities() {
        return findTesisUserCampusEntities(true, -1, -1);
    }

    public List<TesisUserCampus> findTesisUserCampusEntities(int maxResults, int firstResult) {
        return findTesisUserCampusEntities(false, maxResults, firstResult);
    }

    private List<TesisUserCampus> findTesisUserCampusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisUserCampus.class));
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

    public TesisUserCampus findTesisUserCampus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisUserCampus.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisUserCampusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisUserCampus> rt = cq.from(TesisUserCampus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisUserCampus> findAllUsersCampus() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisUserCampus> query = em.createQuery("SELECT usercampus FROM TesisUserCampus usercampus ORDER BY usercampus.createdBy DESC", TesisUserCampus.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}

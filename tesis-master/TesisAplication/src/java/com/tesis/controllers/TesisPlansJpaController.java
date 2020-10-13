/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisPlans;
import com.tesis.model.entity.TesisSystemDocument;
import com.tesis.model.entity.TesisSystemImage;
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
public class TesisPlansJpaController implements Serializable {

    public TesisPlansJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisPlans tesisPlans) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemImage fkTesisSystemImages = tesisPlans.getFkTesisSystemImages();
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages = em.getReference(fkTesisSystemImages.getClass(), fkTesisSystemImages.getCodTesisSystemImages());
                tesisPlans.setFkTesisSystemImages(fkTesisSystemImages);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisPlans.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument = em.getReference(fkTesisSystemDocument.getClass(), fkTesisSystemDocument.getCodTesisSystemDocument());
                tesisPlans.setFkTesisSystemDocument(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisPlans.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus = em.getReference(fkTesisCampus.getClass(), fkTesisCampus.getCodTesisCampus());
                tesisPlans.setFkTesisCampus(fkTesisCampus);
            }
            em.persist(tesisPlans);
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages.getTesisPlansCollection().add(tesisPlans);
                fkTesisSystemImages = em.merge(fkTesisSystemImages);
            }
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisPlansCollection().add(tesisPlans);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisPlansCollection().add(tesisPlans);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisPlans tesisPlans) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisPlans persistentTesisPlans = em.find(TesisPlans.class, tesisPlans.getCodTesisPlans());
            TesisSystemImage fkTesisSystemImagesOld = persistentTesisPlans.getFkTesisSystemImages();
            TesisSystemImage fkTesisSystemImagesNew = tesisPlans.getFkTesisSystemImages();
            TesisSystemDocument fkTesisSystemDocumentOld = persistentTesisPlans.getFkTesisSystemDocument();
            TesisSystemDocument fkTesisSystemDocumentNew = tesisPlans.getFkTesisSystemDocument();
            TesisCampus fkTesisCampusOld = persistentTesisPlans.getFkTesisCampus();
            TesisCampus fkTesisCampusNew = tesisPlans.getFkTesisCampus();
            if (fkTesisSystemImagesNew != null) {
                fkTesisSystemImagesNew = em.getReference(fkTesisSystemImagesNew.getClass(), fkTesisSystemImagesNew.getCodTesisSystemImages());
                tesisPlans.setFkTesisSystemImages(fkTesisSystemImagesNew);
            }
            if (fkTesisSystemDocumentNew != null) {
                fkTesisSystemDocumentNew = em.getReference(fkTesisSystemDocumentNew.getClass(), fkTesisSystemDocumentNew.getCodTesisSystemDocument());
                tesisPlans.setFkTesisSystemDocument(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusNew != null) {
                fkTesisCampusNew = em.getReference(fkTesisCampusNew.getClass(), fkTesisCampusNew.getCodTesisCampus());
                tesisPlans.setFkTesisCampus(fkTesisCampusNew);
            }
            tesisPlans = em.merge(tesisPlans);
            if (fkTesisSystemImagesOld != null && !fkTesisSystemImagesOld.equals(fkTesisSystemImagesNew)) {
                fkTesisSystemImagesOld.getTesisPlansCollection().remove(tesisPlans);
                fkTesisSystemImagesOld = em.merge(fkTesisSystemImagesOld);
            }
            if (fkTesisSystemImagesNew != null && !fkTesisSystemImagesNew.equals(fkTesisSystemImagesOld)) {
                fkTesisSystemImagesNew.getTesisPlansCollection().add(tesisPlans);
                fkTesisSystemImagesNew = em.merge(fkTesisSystemImagesNew);
            }
            if (fkTesisSystemDocumentOld != null && !fkTesisSystemDocumentOld.equals(fkTesisSystemDocumentNew)) {
                fkTesisSystemDocumentOld.getTesisPlansCollection().remove(tesisPlans);
                fkTesisSystemDocumentOld = em.merge(fkTesisSystemDocumentOld);
            }
            if (fkTesisSystemDocumentNew != null && !fkTesisSystemDocumentNew.equals(fkTesisSystemDocumentOld)) {
                fkTesisSystemDocumentNew.getTesisPlansCollection().add(tesisPlans);
                fkTesisSystemDocumentNew = em.merge(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusOld != null && !fkTesisCampusOld.equals(fkTesisCampusNew)) {
                fkTesisCampusOld.getTesisPlansCollection().remove(tesisPlans);
                fkTesisCampusOld = em.merge(fkTesisCampusOld);
            }
            if (fkTesisCampusNew != null && !fkTesisCampusNew.equals(fkTesisCampusOld)) {
                fkTesisCampusNew.getTesisPlansCollection().add(tesisPlans);
                fkTesisCampusNew = em.merge(fkTesisCampusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisPlans.getCodTesisPlans();
                if (findTesisPlans(id) == null) {
                    throw new NonexistentEntityException("The tesisPlans with id " + id + " no longer exists.");
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
            TesisPlans tesisPlans;
            try {
                tesisPlans = em.getReference(TesisPlans.class, id);
                tesisPlans.getCodTesisPlans();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisPlans with id " + id + " no longer exists.", enfe);
            }
            TesisSystemImage fkTesisSystemImages = tesisPlans.getFkTesisSystemImages();
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages.getTesisPlansCollection().remove(tesisPlans);
                fkTesisSystemImages = em.merge(fkTesisSystemImages);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisPlans.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisPlansCollection().remove(tesisPlans);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisPlans.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisPlansCollection().remove(tesisPlans);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.remove(tesisPlans);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisPlans> findTesisPlansEntities() {
        return findTesisPlansEntities(true, -1, -1);
    }

    public List<TesisPlans> findTesisPlansEntities(int maxResults, int firstResult) {
        return findTesisPlansEntities(false, maxResults, firstResult);
    }

    private List<TesisPlans> findTesisPlansEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisPlans.class));
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

    public TesisPlans findTesisPlans(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisPlans.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisPlansCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisPlans> rt = cq.from(TesisPlans.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisPlans> findAllPlans() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisPlans> query = em.createQuery("SELECT plan FROM TesisPlans plan ORDER BY plan.updateDate DESC", TesisPlans.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisPlans> findAllPlansOrder() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisPlans> query = em.createQuery("SELECT plan FROM TesisPlans plan ORDER BY plan.planName ASC", TesisPlans.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisPlans> findAllPlanByCriteria(String value) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisPlans> query = em.createQuery("SELECT plan FROM TesisPlans plan WHERE LOWER(plan.planName) LIKE LOWER(:param) ORDER BY plan.planName ASC", TesisPlans.class);
            return query.setParameter("param", "%" + value + "%").getResultList();
        } finally {
            em.close();
        }
    }

}

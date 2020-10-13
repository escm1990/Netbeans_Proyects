/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisCulture;
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
public class TesisCultureJpaController implements Serializable {

    public TesisCultureJpaController() {
       this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisCulture tesisCulture) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemImage fkSystemImages = tesisCulture.getFkSystemImages();
            if (fkSystemImages != null) {
                fkSystemImages = em.getReference(fkSystemImages.getClass(), fkSystemImages.getCodTesisSystemImages());
                tesisCulture.setFkSystemImages(fkSystemImages);
            }
            TesisSystemDocument fkSystemDocument = tesisCulture.getFkSystemDocument();
            if (fkSystemDocument != null) {
                fkSystemDocument = em.getReference(fkSystemDocument.getClass(), fkSystemDocument.getCodTesisSystemDocument());
                tesisCulture.setFkSystemDocument(fkSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisCulture.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus = em.getReference(fkTesisCampus.getClass(), fkTesisCampus.getCodTesisCampus());
                tesisCulture.setFkTesisCampus(fkTesisCampus);
            }
            em.persist(tesisCulture);
            if (fkSystemImages != null) {
                fkSystemImages.getTesisCultureCollection().add(tesisCulture);
                fkSystemImages = em.merge(fkSystemImages);
            }
            if (fkSystemDocument != null) {
                fkSystemDocument.getTesisCultureCollection().add(tesisCulture);
                fkSystemDocument = em.merge(fkSystemDocument);
            }
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisCultureCollection().add(tesisCulture);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisCulture tesisCulture) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisCulture persistentTesisCulture = em.find(TesisCulture.class, tesisCulture.getCodTesisCulture());
            TesisSystemImage fkSystemImagesOld = persistentTesisCulture.getFkSystemImages();
            TesisSystemImage fkSystemImagesNew = tesisCulture.getFkSystemImages();
            TesisSystemDocument fkSystemDocumentOld = persistentTesisCulture.getFkSystemDocument();
            TesisSystemDocument fkSystemDocumentNew = tesisCulture.getFkSystemDocument();
            TesisCampus fkTesisCampusOld = persistentTesisCulture.getFkTesisCampus();
            TesisCampus fkTesisCampusNew = tesisCulture.getFkTesisCampus();
            if (fkSystemImagesNew != null) {
                fkSystemImagesNew = em.getReference(fkSystemImagesNew.getClass(), fkSystemImagesNew.getCodTesisSystemImages());
                tesisCulture.setFkSystemImages(fkSystemImagesNew);
            }
            if (fkSystemDocumentNew != null) {
                fkSystemDocumentNew = em.getReference(fkSystemDocumentNew.getClass(), fkSystemDocumentNew.getCodTesisSystemDocument());
                tesisCulture.setFkSystemDocument(fkSystemDocumentNew);
            }
            if (fkTesisCampusNew != null) {
                fkTesisCampusNew = em.getReference(fkTesisCampusNew.getClass(), fkTesisCampusNew.getCodTesisCampus());
                tesisCulture.setFkTesisCampus(fkTesisCampusNew);
            }
            tesisCulture = em.merge(tesisCulture);
            if (fkSystemImagesOld != null && !fkSystemImagesOld.equals(fkSystemImagesNew)) {
                fkSystemImagesOld.getTesisCultureCollection().remove(tesisCulture);
                fkSystemImagesOld = em.merge(fkSystemImagesOld);
            }
            if (fkSystemImagesNew != null && !fkSystemImagesNew.equals(fkSystemImagesOld)) {
                fkSystemImagesNew.getTesisCultureCollection().add(tesisCulture);
                fkSystemImagesNew = em.merge(fkSystemImagesNew);
            }
            if (fkSystemDocumentOld != null && !fkSystemDocumentOld.equals(fkSystemDocumentNew)) {
                fkSystemDocumentOld.getTesisCultureCollection().remove(tesisCulture);
                fkSystemDocumentOld = em.merge(fkSystemDocumentOld);
            }
            if (fkSystemDocumentNew != null && !fkSystemDocumentNew.equals(fkSystemDocumentOld)) {
                fkSystemDocumentNew.getTesisCultureCollection().add(tesisCulture);
                fkSystemDocumentNew = em.merge(fkSystemDocumentNew);
            }
            if (fkTesisCampusOld != null && !fkTesisCampusOld.equals(fkTesisCampusNew)) {
                fkTesisCampusOld.getTesisCultureCollection().remove(tesisCulture);
                fkTesisCampusOld = em.merge(fkTesisCampusOld);
            }
            if (fkTesisCampusNew != null && !fkTesisCampusNew.equals(fkTesisCampusOld)) {
                fkTesisCampusNew.getTesisCultureCollection().add(tesisCulture);
                fkTesisCampusNew = em.merge(fkTesisCampusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisCulture.getCodTesisCulture();
                if (findTesisCulture(id) == null) {
                    throw new NonexistentEntityException("The tesisCulture with id " + id + " no longer exists.");
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
            TesisCulture tesisCulture;
            try {
                tesisCulture = em.getReference(TesisCulture.class, id);
                tesisCulture.getCodTesisCulture();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisCulture with id " + id + " no longer exists.", enfe);
            }
            TesisSystemImage fkSystemImages = tesisCulture.getFkSystemImages();
            if (fkSystemImages != null) {
                fkSystemImages.getTesisCultureCollection().remove(tesisCulture);
                fkSystemImages = em.merge(fkSystemImages);
            }
            TesisSystemDocument fkSystemDocument = tesisCulture.getFkSystemDocument();
            if (fkSystemDocument != null) {
                fkSystemDocument.getTesisCultureCollection().remove(tesisCulture);
                fkSystemDocument = em.merge(fkSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisCulture.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisCultureCollection().remove(tesisCulture);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.remove(tesisCulture);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisCulture> findTesisCultureEntities() {
        return findTesisCultureEntities(true, -1, -1);
    }

    public List<TesisCulture> findTesisCultureEntities(int maxResults, int firstResult) {
        return findTesisCultureEntities(false, maxResults, firstResult);
    }

    private List<TesisCulture> findTesisCultureEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisCulture.class));
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

    public TesisCulture findTesisCulture(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisCulture.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisCultureCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisCulture> rt = cq.from(TesisCulture.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisCulture> findAllCulture() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisCulture> query = em.createQuery("SELECT cul FROM TesisCulture cul ORDER BY cul.updateDate DESC", TesisCulture.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisCulture> findAllCultureOrder() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisCulture> query = em.createQuery("SELECT cul FROM TesisCulture cul ORDER BY cul.cultureName ASC", TesisCulture.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisCulture> findAllPlanByCriteria(String value) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisCulture> query = em.createQuery("SELECT cul FROM TesisCulture cul WHERE LOWER(cul.cultureName) LIKE LOWER(:param) ORDER BY cul.cultureName ASC", TesisCulture.class);
            return query.setParameter("param", "%" + value + "%").getResultList();
        } finally {
            em.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisMasters;
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
public class TesisMastersJpaController implements Serializable {

    public TesisMastersJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisMasters tesisMasters) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemImage fkTesisSystemImages = tesisMasters.getFkTesisSystemImages();
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages = em.getReference(fkTesisSystemImages.getClass(), fkTesisSystemImages.getCodTesisSystemImages());
                tesisMasters.setFkTesisSystemImages(fkTesisSystemImages);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisMasters.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument = em.getReference(fkTesisSystemDocument.getClass(), fkTesisSystemDocument.getCodTesisSystemDocument());
                tesisMasters.setFkTesisSystemDocument(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisMasters.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus = em.getReference(fkTesisCampus.getClass(), fkTesisCampus.getCodTesisCampus());
                tesisMasters.setFkTesisCampus(fkTesisCampus);
            }
            em.persist(tesisMasters);
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages.getTesisMastersCollection().add(tesisMasters);
                fkTesisSystemImages = em.merge(fkTesisSystemImages);
            }
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisMastersCollection().add(tesisMasters);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisMastersCollection().add(tesisMasters);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisMasters tesisMasters) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisMasters persistentTesisMasters = em.find(TesisMasters.class, tesisMasters.getCodTesisMasters());
            TesisSystemImage fkTesisSystemImagesOld = persistentTesisMasters.getFkTesisSystemImages();
            TesisSystemImage fkTesisSystemImagesNew = tesisMasters.getFkTesisSystemImages();
            TesisSystemDocument fkTesisSystemDocumentOld = persistentTesisMasters.getFkTesisSystemDocument();
            TesisSystemDocument fkTesisSystemDocumentNew = tesisMasters.getFkTesisSystemDocument();
            TesisCampus fkTesisCampusOld = persistentTesisMasters.getFkTesisCampus();
            TesisCampus fkTesisCampusNew = tesisMasters.getFkTesisCampus();
            if (fkTesisSystemImagesNew != null) {
                fkTesisSystemImagesNew = em.getReference(fkTesisSystemImagesNew.getClass(), fkTesisSystemImagesNew.getCodTesisSystemImages());
                tesisMasters.setFkTesisSystemImages(fkTesisSystemImagesNew);
            }
            if (fkTesisSystemDocumentNew != null) {
                fkTesisSystemDocumentNew = em.getReference(fkTesisSystemDocumentNew.getClass(), fkTesisSystemDocumentNew.getCodTesisSystemDocument());
                tesisMasters.setFkTesisSystemDocument(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusNew != null) {
                fkTesisCampusNew = em.getReference(fkTesisCampusNew.getClass(), fkTesisCampusNew.getCodTesisCampus());
                tesisMasters.setFkTesisCampus(fkTesisCampusNew);
            }
            tesisMasters = em.merge(tesisMasters);
            if (fkTesisSystemImagesOld != null && !fkTesisSystemImagesOld.equals(fkTesisSystemImagesNew)) {
                fkTesisSystemImagesOld.getTesisMastersCollection().remove(tesisMasters);
                fkTesisSystemImagesOld = em.merge(fkTesisSystemImagesOld);
            }
            if (fkTesisSystemImagesNew != null && !fkTesisSystemImagesNew.equals(fkTesisSystemImagesOld)) {
                fkTesisSystemImagesNew.getTesisMastersCollection().add(tesisMasters);
                fkTesisSystemImagesNew = em.merge(fkTesisSystemImagesNew);
            }
            if (fkTesisSystemDocumentOld != null && !fkTesisSystemDocumentOld.equals(fkTesisSystemDocumentNew)) {
                fkTesisSystemDocumentOld.getTesisMastersCollection().remove(tesisMasters);
                fkTesisSystemDocumentOld = em.merge(fkTesisSystemDocumentOld);
            }
            if (fkTesisSystemDocumentNew != null && !fkTesisSystemDocumentNew.equals(fkTesisSystemDocumentOld)) {
                fkTesisSystemDocumentNew.getTesisMastersCollection().add(tesisMasters);
                fkTesisSystemDocumentNew = em.merge(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusOld != null && !fkTesisCampusOld.equals(fkTesisCampusNew)) {
                fkTesisCampusOld.getTesisMastersCollection().remove(tesisMasters);
                fkTesisCampusOld = em.merge(fkTesisCampusOld);
            }
            if (fkTesisCampusNew != null && !fkTesisCampusNew.equals(fkTesisCampusOld)) {
                fkTesisCampusNew.getTesisMastersCollection().add(tesisMasters);
                fkTesisCampusNew = em.merge(fkTesisCampusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisMasters.getCodTesisMasters();
                if (findTesisMasters(id) == null) {
                    throw new NonexistentEntityException("The tesisMasters with id " + id + " no longer exists.");
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
            TesisMasters tesisMasters;
            try {
                tesisMasters = em.getReference(TesisMasters.class, id);
                tesisMasters.getCodTesisMasters();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisMasters with id " + id + " no longer exists.", enfe);
            }
            TesisSystemImage fkTesisSystemImages = tesisMasters.getFkTesisSystemImages();
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages.getTesisMastersCollection().remove(tesisMasters);
                fkTesisSystemImages = em.merge(fkTesisSystemImages);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisMasters.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisMastersCollection().remove(tesisMasters);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisMasters.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisMastersCollection().remove(tesisMasters);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.remove(tesisMasters);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisMasters> findTesisMastersEntities() {
        return findTesisMastersEntities(true, -1, -1);
    }

    public List<TesisMasters> findTesisMastersEntities(int maxResults, int firstResult) {
        return findTesisMastersEntities(false, maxResults, firstResult);
    }

    private List<TesisMasters> findTesisMastersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisMasters.class));
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

    public TesisMasters findTesisMasters(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisMasters.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisMastersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisMasters> rt = cq.from(TesisMasters.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisMasters> findAllMaster() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisMasters> query = em.createQuery("SELECT ma FROM TesisMasters ma ORDER BY ma.updateDate DESC", TesisMasters.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisMasters> findAllMasterOrder() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisMasters> query = em.createQuery("SELECT ma FROM TesisMasters ma ORDER BY ma.maestriaName ASC", TesisMasters.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisMasters> findAllMasterByCriteria(String value) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisMasters> query = em.createQuery("SELECT ma FROM TesisMasters ma WHERE LOWER(ma.maestriaName) LIKE LOWER(:param) ORDER BY ma.maestriaName ASC", TesisMasters.class);
            return query.setParameter("param", "%" + value + "%").getResultList();
        } finally {
            em.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisInfrastructure;
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
public class TesisInfrastructureJpaController implements Serializable {

    public TesisInfrastructureJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisInfrastructure tesisInfrastructure) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemImage fkTesisSystemImages = tesisInfrastructure.getFkTesisSystemImages();
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages = em.getReference(fkTesisSystemImages.getClass(), fkTesisSystemImages.getCodTesisSystemImages());
                tesisInfrastructure.setFkTesisSystemImages(fkTesisSystemImages);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisInfrastructure.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument = em.getReference(fkTesisSystemDocument.getClass(), fkTesisSystemDocument.getCodTesisSystemDocument());
                tesisInfrastructure.setFkTesisSystemDocument(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisInfrastructure.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus = em.getReference(fkTesisCampus.getClass(), fkTesisCampus.getCodTesisCampus());
                tesisInfrastructure.setFkTesisCampus(fkTesisCampus);
            }
            em.persist(tesisInfrastructure);
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages.getTesisInfrastructureCollection().add(tesisInfrastructure);
                fkTesisSystemImages = em.merge(fkTesisSystemImages);
            }
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisInfrastructureCollection().add(tesisInfrastructure);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisInfrastructureCollection().add(tesisInfrastructure);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisInfrastructure tesisInfrastructure) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisInfrastructure persistentTesisInfrastructure = em.find(TesisInfrastructure.class, tesisInfrastructure.getCodTesisInfrastructure());
            TesisSystemImage fkTesisSystemImagesOld = persistentTesisInfrastructure.getFkTesisSystemImages();
            TesisSystemImage fkTesisSystemImagesNew = tesisInfrastructure.getFkTesisSystemImages();
            TesisSystemDocument fkTesisSystemDocumentOld = persistentTesisInfrastructure.getFkTesisSystemDocument();
            TesisSystemDocument fkTesisSystemDocumentNew = tesisInfrastructure.getFkTesisSystemDocument();
            TesisCampus fkTesisCampusOld = persistentTesisInfrastructure.getFkTesisCampus();
            TesisCampus fkTesisCampusNew = tesisInfrastructure.getFkTesisCampus();
            if (fkTesisSystemImagesNew != null) {
                fkTesisSystemImagesNew = em.getReference(fkTesisSystemImagesNew.getClass(), fkTesisSystemImagesNew.getCodTesisSystemImages());
                tesisInfrastructure.setFkTesisSystemImages(fkTesisSystemImagesNew);
            }
            if (fkTesisSystemDocumentNew != null) {
                fkTesisSystemDocumentNew = em.getReference(fkTesisSystemDocumentNew.getClass(), fkTesisSystemDocumentNew.getCodTesisSystemDocument());
                tesisInfrastructure.setFkTesisSystemDocument(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusNew != null) {
                fkTesisCampusNew = em.getReference(fkTesisCampusNew.getClass(), fkTesisCampusNew.getCodTesisCampus());
                tesisInfrastructure.setFkTesisCampus(fkTesisCampusNew);
            }
            tesisInfrastructure = em.merge(tesisInfrastructure);
            if (fkTesisSystemImagesOld != null && !fkTesisSystemImagesOld.equals(fkTesisSystemImagesNew)) {
                fkTesisSystemImagesOld.getTesisInfrastructureCollection().remove(tesisInfrastructure);
                fkTesisSystemImagesOld = em.merge(fkTesisSystemImagesOld);
            }
            if (fkTesisSystemImagesNew != null && !fkTesisSystemImagesNew.equals(fkTesisSystemImagesOld)) {
                fkTesisSystemImagesNew.getTesisInfrastructureCollection().add(tesisInfrastructure);
                fkTesisSystemImagesNew = em.merge(fkTesisSystemImagesNew);
            }
            if (fkTesisSystemDocumentOld != null && !fkTesisSystemDocumentOld.equals(fkTesisSystemDocumentNew)) {
                fkTesisSystemDocumentOld.getTesisInfrastructureCollection().remove(tesisInfrastructure);
                fkTesisSystemDocumentOld = em.merge(fkTesisSystemDocumentOld);
            }
            if (fkTesisSystemDocumentNew != null && !fkTesisSystemDocumentNew.equals(fkTesisSystemDocumentOld)) {
                fkTesisSystemDocumentNew.getTesisInfrastructureCollection().add(tesisInfrastructure);
                fkTesisSystemDocumentNew = em.merge(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusOld != null && !fkTesisCampusOld.equals(fkTesisCampusNew)) {
                fkTesisCampusOld.getTesisInfrastructureCollection().remove(tesisInfrastructure);
                fkTesisCampusOld = em.merge(fkTesisCampusOld);
            }
            if (fkTesisCampusNew != null && !fkTesisCampusNew.equals(fkTesisCampusOld)) {
                fkTesisCampusNew.getTesisInfrastructureCollection().add(tesisInfrastructure);
                fkTesisCampusNew = em.merge(fkTesisCampusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisInfrastructure.getCodTesisInfrastructure();
                if (findTesisInfrastructure(id) == null) {
                    throw new NonexistentEntityException("The tesisInfrastructure with id " + id + " no longer exists.");
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
            TesisInfrastructure tesisInfrastructure;
            try {
                tesisInfrastructure = em.getReference(TesisInfrastructure.class, id);
                tesisInfrastructure.getCodTesisInfrastructure();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisInfrastructure with id " + id + " no longer exists.", enfe);
            }
            TesisSystemImage fkTesisSystemImages = tesisInfrastructure.getFkTesisSystemImages();
            if (fkTesisSystemImages != null) {
                fkTesisSystemImages.getTesisInfrastructureCollection().remove(tesisInfrastructure);
                fkTesisSystemImages = em.merge(fkTesisSystemImages);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisInfrastructure.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisInfrastructureCollection().remove(tesisInfrastructure);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisInfrastructure.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisInfrastructureCollection().remove(tesisInfrastructure);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.remove(tesisInfrastructure);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisInfrastructure> findTesisInfrastructureEntities() {
        return findTesisInfrastructureEntities(true, -1, -1);
    }

    public List<TesisInfrastructure> findTesisInfrastructureEntities(int maxResults, int firstResult) {
        return findTesisInfrastructureEntities(false, maxResults, firstResult);
    }

    private List<TesisInfrastructure> findTesisInfrastructureEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisInfrastructure.class));
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

    public TesisInfrastructure findTesisInfrastructure(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisInfrastructure.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisInfrastructureCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisInfrastructure> rt = cq.from(TesisInfrastructure.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisInfrastructure> findAllInfra() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisInfrastructure> query = em.createQuery("SELECT infra FROM TesisInfrastructure infra ORDER BY infra.updateDate DESC", TesisInfrastructure.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisInfrastructure> findAllInfraOrder() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisInfrastructure> query = em.createQuery("SELECT infra FROM TesisInfrastructure infra ORDER BY infra.infraestructuraName ASC", TesisInfrastructure.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisInfrastructure> findAllInfraByCriteria(String value) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisInfrastructure> query = em.createQuery("SELECT infra FROM TesisInfrastructure infra WHERE LOWER(infra.infraestructuraName) LIKE LOWER(:param) ORDER BY infra.infraestructuraName ASC", TesisInfrastructure.class);
            return query.setParameter("param", "%" + value + "%").getResultList();
        } finally {
            em.close();
        }
    }

}

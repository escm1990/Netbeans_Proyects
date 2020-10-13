/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisOffer;
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
public class TesisOfferJpaController implements Serializable {

    public TesisOfferJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisOffer tesisOffer) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemImage fkTesisSystemImage = tesisOffer.getFkTesisSystemImage();
            if (fkTesisSystemImage != null) {
                fkTesisSystemImage = em.getReference(fkTesisSystemImage.getClass(), fkTesisSystemImage.getCodTesisSystemImages());
                tesisOffer.setFkTesisSystemImage(fkTesisSystemImage);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisOffer.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument = em.getReference(fkTesisSystemDocument.getClass(), fkTesisSystemDocument.getCodTesisSystemDocument());
                tesisOffer.setFkTesisSystemDocument(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisOffer.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus = em.getReference(fkTesisCampus.getClass(), fkTesisCampus.getCodTesisCampus());
                tesisOffer.setFkTesisCampus(fkTesisCampus);
            }
            em.persist(tesisOffer);
            if (fkTesisSystemImage != null) {
                fkTesisSystemImage.getTesisOfferCollection().add(tesisOffer);
                fkTesisSystemImage = em.merge(fkTesisSystemImage);
            }
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisOfferCollection().add(tesisOffer);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisOfferCollection().add(tesisOffer);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisOffer tesisOffer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisOffer persistentTesisOffer = em.find(TesisOffer.class, tesisOffer.getCodTesisOffer());
            TesisSystemImage fkTesisSystemImageOld = persistentTesisOffer.getFkTesisSystemImage();
            TesisSystemImage fkTesisSystemImageNew = tesisOffer.getFkTesisSystemImage();
            TesisSystemDocument fkTesisSystemDocumentOld = persistentTesisOffer.getFkTesisSystemDocument();
            TesisSystemDocument fkTesisSystemDocumentNew = tesisOffer.getFkTesisSystemDocument();
            TesisCampus fkTesisCampusOld = persistentTesisOffer.getFkTesisCampus();
            TesisCampus fkTesisCampusNew = tesisOffer.getFkTesisCampus();
            if (fkTesisSystemImageNew != null) {
                fkTesisSystemImageNew = em.getReference(fkTesisSystemImageNew.getClass(), fkTesisSystemImageNew.getCodTesisSystemImages());
                tesisOffer.setFkTesisSystemImage(fkTesisSystemImageNew);
            }
            if (fkTesisSystemDocumentNew != null) {
                fkTesisSystemDocumentNew = em.getReference(fkTesisSystemDocumentNew.getClass(), fkTesisSystemDocumentNew.getCodTesisSystemDocument());
                tesisOffer.setFkTesisSystemDocument(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusNew != null) {
                fkTesisCampusNew = em.getReference(fkTesisCampusNew.getClass(), fkTesisCampusNew.getCodTesisCampus());
                tesisOffer.setFkTesisCampus(fkTesisCampusNew);
            }
            tesisOffer = em.merge(tesisOffer);
            if (fkTesisSystemImageOld != null && !fkTesisSystemImageOld.equals(fkTesisSystemImageNew)) {
                fkTesisSystemImageOld.getTesisOfferCollection().remove(tesisOffer);
                fkTesisSystemImageOld = em.merge(fkTesisSystemImageOld);
            }
            if (fkTesisSystemImageNew != null && !fkTesisSystemImageNew.equals(fkTesisSystemImageOld)) {
                fkTesisSystemImageNew.getTesisOfferCollection().add(tesisOffer);
                fkTesisSystemImageNew = em.merge(fkTesisSystemImageNew);
            }
            if (fkTesisSystemDocumentOld != null && !fkTesisSystemDocumentOld.equals(fkTesisSystemDocumentNew)) {
                fkTesisSystemDocumentOld.getTesisOfferCollection().remove(tesisOffer);
                fkTesisSystemDocumentOld = em.merge(fkTesisSystemDocumentOld);
            }
            if (fkTesisSystemDocumentNew != null && !fkTesisSystemDocumentNew.equals(fkTesisSystemDocumentOld)) {
                fkTesisSystemDocumentNew.getTesisOfferCollection().add(tesisOffer);
                fkTesisSystemDocumentNew = em.merge(fkTesisSystemDocumentNew);
            }
            if (fkTesisCampusOld != null && !fkTesisCampusOld.equals(fkTesisCampusNew)) {
                fkTesisCampusOld.getTesisOfferCollection().remove(tesisOffer);
                fkTesisCampusOld = em.merge(fkTesisCampusOld);
            }
            if (fkTesisCampusNew != null && !fkTesisCampusNew.equals(fkTesisCampusOld)) {
                fkTesisCampusNew.getTesisOfferCollection().add(tesisOffer);
                fkTesisCampusNew = em.merge(fkTesisCampusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisOffer.getCodTesisOffer();
                if (findTesisOffer(id) == null) {
                    throw new NonexistentEntityException("The tesisOffer with id " + id + " no longer exists.");
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
            TesisOffer tesisOffer;
            try {
                tesisOffer = em.getReference(TesisOffer.class, id);
                tesisOffer.getCodTesisOffer();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisOffer with id " + id + " no longer exists.", enfe);
            }
            TesisSystemImage fkTesisSystemImage = tesisOffer.getFkTesisSystemImage();
            if (fkTesisSystemImage != null) {
                fkTesisSystemImage.getTesisOfferCollection().remove(tesisOffer);
                fkTesisSystemImage = em.merge(fkTesisSystemImage);
            }
            TesisSystemDocument fkTesisSystemDocument = tesisOffer.getFkTesisSystemDocument();
            if (fkTesisSystemDocument != null) {
                fkTesisSystemDocument.getTesisOfferCollection().remove(tesisOffer);
                fkTesisSystemDocument = em.merge(fkTesisSystemDocument);
            }
            TesisCampus fkTesisCampus = tesisOffer.getFkTesisCampus();
            if (fkTesisCampus != null) {
                fkTesisCampus.getTesisOfferCollection().remove(tesisOffer);
                fkTesisCampus = em.merge(fkTesisCampus);
            }
            em.remove(tesisOffer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisOffer> findTesisOfferEntities() {
        return findTesisOfferEntities(true, -1, -1);
    }

    public List<TesisOffer> findTesisOfferEntities(int maxResults, int firstResult) {
        return findTesisOfferEntities(false, maxResults, firstResult);
    }

    private List<TesisOffer> findTesisOfferEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisOffer.class));
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

    public TesisOffer findTesisOffer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisOffer.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisOfferCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisOffer> rt = cq.from(TesisOffer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisOffer> findAllOffers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisOffer> query = em.createQuery("SELECT offer FROM TesisOffer offer ORDER BY offer.updateDate DESC", TesisOffer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisOffer> findAllOffersOrder() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisOffer> query = em.createQuery("SELECT offer FROM TesisOffer offer ORDER BY offer.offerName ASC", TesisOffer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TesisOffer> findAllOfferByCriteria(String value) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisOffer> query = em.createQuery("SELECT offer FROM TesisOffer offer WHERE LOWER(offer.offerName) LIKE LOWER(:param) ORDER BY offer.offerName ASC", TesisOffer.class);
            return query.setParameter("param", "%" + value + "%").getResultList();
        } finally {
            em.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCulture;
import com.tesis.model.entity.TesisInfrastructure;
import com.tesis.model.entity.TesisMasters;
import com.tesis.model.entity.TesisOffer;
import com.tesis.model.entity.TesisPlans;
import com.tesis.model.entity.TesisSystemDocument;
import com.tesis.utils.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author luis.chavez
 */
public class TesisSystemDocumentJpaController implements Serializable {

    public TesisSystemDocumentJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisSystemDocument tesisSystemDocument) {
        if (tesisSystemDocument.getTesisMastersCollection() == null) {
            tesisSystemDocument.setTesisMastersCollection(new ArrayList<TesisMasters>());
        }
        if (tesisSystemDocument.getTesisOfferCollection() == null) {
            tesisSystemDocument.setTesisOfferCollection(new ArrayList<TesisOffer>());
        }
        if (tesisSystemDocument.getTesisPlansCollection() == null) {
            tesisSystemDocument.setTesisPlansCollection(new ArrayList<TesisPlans>());
        }
        if (tesisSystemDocument.getTesisCultureCollection() == null) {
            tesisSystemDocument.setTesisCultureCollection(new ArrayList<TesisCulture>());
        }
        if (tesisSystemDocument.getTesisInfrastructureCollection() == null) {
            tesisSystemDocument.setTesisInfrastructureCollection(new ArrayList<TesisInfrastructure>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TesisMasters> attachedTesisMastersCollection = new ArrayList<TesisMasters>();
            for (TesisMasters tesisMastersCollectionTesisMastersToAttach : tesisSystemDocument.getTesisMastersCollection()) {
                tesisMastersCollectionTesisMastersToAttach = em.getReference(tesisMastersCollectionTesisMastersToAttach.getClass(), tesisMastersCollectionTesisMastersToAttach.getCodTesisMasters());
                attachedTesisMastersCollection.add(tesisMastersCollectionTesisMastersToAttach);
            }
            tesisSystemDocument.setTesisMastersCollection(attachedTesisMastersCollection);
            Collection<TesisOffer> attachedTesisOfferCollection = new ArrayList<TesisOffer>();
            for (TesisOffer tesisOfferCollectionTesisOfferToAttach : tesisSystemDocument.getTesisOfferCollection()) {
                tesisOfferCollectionTesisOfferToAttach = em.getReference(tesisOfferCollectionTesisOfferToAttach.getClass(), tesisOfferCollectionTesisOfferToAttach.getCodTesisOffer());
                attachedTesisOfferCollection.add(tesisOfferCollectionTesisOfferToAttach);
            }
            tesisSystemDocument.setTesisOfferCollection(attachedTesisOfferCollection);
            Collection<TesisPlans> attachedTesisPlansCollection = new ArrayList<TesisPlans>();
            for (TesisPlans tesisPlansCollectionTesisPlansToAttach : tesisSystemDocument.getTesisPlansCollection()) {
                tesisPlansCollectionTesisPlansToAttach = em.getReference(tesisPlansCollectionTesisPlansToAttach.getClass(), tesisPlansCollectionTesisPlansToAttach.getCodTesisPlans());
                attachedTesisPlansCollection.add(tesisPlansCollectionTesisPlansToAttach);
            }
            tesisSystemDocument.setTesisPlansCollection(attachedTesisPlansCollection);
            Collection<TesisCulture> attachedTesisCultureCollection = new ArrayList<TesisCulture>();
            for (TesisCulture tesisCultureCollectionTesisCultureToAttach : tesisSystemDocument.getTesisCultureCollection()) {
                tesisCultureCollectionTesisCultureToAttach = em.getReference(tesisCultureCollectionTesisCultureToAttach.getClass(), tesisCultureCollectionTesisCultureToAttach.getCodTesisCulture());
                attachedTesisCultureCollection.add(tesisCultureCollectionTesisCultureToAttach);
            }
            tesisSystemDocument.setTesisCultureCollection(attachedTesisCultureCollection);
            Collection<TesisInfrastructure> attachedTesisInfrastructureCollection = new ArrayList<TesisInfrastructure>();
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructureToAttach : tesisSystemDocument.getTesisInfrastructureCollection()) {
                tesisInfrastructureCollectionTesisInfrastructureToAttach = em.getReference(tesisInfrastructureCollectionTesisInfrastructureToAttach.getClass(), tesisInfrastructureCollectionTesisInfrastructureToAttach.getCodTesisInfrastructure());
                attachedTesisInfrastructureCollection.add(tesisInfrastructureCollectionTesisInfrastructureToAttach);
            }
            tesisSystemDocument.setTesisInfrastructureCollection(attachedTesisInfrastructureCollection);
            em.persist(tesisSystemDocument);
            for (TesisMasters tesisMastersCollectionTesisMasters : tesisSystemDocument.getTesisMastersCollection()) {
                TesisSystemDocument oldFkTesisSystemDocumentOfTesisMastersCollectionTesisMasters = tesisMastersCollectionTesisMasters.getFkTesisSystemDocument();
                tesisMastersCollectionTesisMasters.setFkTesisSystemDocument(tesisSystemDocument);
                tesisMastersCollectionTesisMasters = em.merge(tesisMastersCollectionTesisMasters);
                if (oldFkTesisSystemDocumentOfTesisMastersCollectionTesisMasters != null) {
                    oldFkTesisSystemDocumentOfTesisMastersCollectionTesisMasters.getTesisMastersCollection().remove(tesisMastersCollectionTesisMasters);
                    oldFkTesisSystemDocumentOfTesisMastersCollectionTesisMasters = em.merge(oldFkTesisSystemDocumentOfTesisMastersCollectionTesisMasters);
                }
            }
            for (TesisOffer tesisOfferCollectionTesisOffer : tesisSystemDocument.getTesisOfferCollection()) {
                TesisSystemDocument oldFkTesisSystemDocumentOfTesisOfferCollectionTesisOffer = tesisOfferCollectionTesisOffer.getFkTesisSystemDocument();
                tesisOfferCollectionTesisOffer.setFkTesisSystemDocument(tesisSystemDocument);
                tesisOfferCollectionTesisOffer = em.merge(tesisOfferCollectionTesisOffer);
                if (oldFkTesisSystemDocumentOfTesisOfferCollectionTesisOffer != null) {
                    oldFkTesisSystemDocumentOfTesisOfferCollectionTesisOffer.getTesisOfferCollection().remove(tesisOfferCollectionTesisOffer);
                    oldFkTesisSystemDocumentOfTesisOfferCollectionTesisOffer = em.merge(oldFkTesisSystemDocumentOfTesisOfferCollectionTesisOffer);
                }
            }
            for (TesisPlans tesisPlansCollectionTesisPlans : tesisSystemDocument.getTesisPlansCollection()) {
                TesisSystemDocument oldFkTesisSystemDocumentOfTesisPlansCollectionTesisPlans = tesisPlansCollectionTesisPlans.getFkTesisSystemDocument();
                tesisPlansCollectionTesisPlans.setFkTesisSystemDocument(tesisSystemDocument);
                tesisPlansCollectionTesisPlans = em.merge(tesisPlansCollectionTesisPlans);
                if (oldFkTesisSystemDocumentOfTesisPlansCollectionTesisPlans != null) {
                    oldFkTesisSystemDocumentOfTesisPlansCollectionTesisPlans.getTesisPlansCollection().remove(tesisPlansCollectionTesisPlans);
                    oldFkTesisSystemDocumentOfTesisPlansCollectionTesisPlans = em.merge(oldFkTesisSystemDocumentOfTesisPlansCollectionTesisPlans);
                }
            }
            for (TesisCulture tesisCultureCollectionTesisCulture : tesisSystemDocument.getTesisCultureCollection()) {
                TesisSystemDocument oldFkSystemDocumentOfTesisCultureCollectionTesisCulture = tesisCultureCollectionTesisCulture.getFkSystemDocument();
                tesisCultureCollectionTesisCulture.setFkSystemDocument(tesisSystemDocument);
                tesisCultureCollectionTesisCulture = em.merge(tesisCultureCollectionTesisCulture);
                if (oldFkSystemDocumentOfTesisCultureCollectionTesisCulture != null) {
                    oldFkSystemDocumentOfTesisCultureCollectionTesisCulture.getTesisCultureCollection().remove(tesisCultureCollectionTesisCulture);
                    oldFkSystemDocumentOfTesisCultureCollectionTesisCulture = em.merge(oldFkSystemDocumentOfTesisCultureCollectionTesisCulture);
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructure : tesisSystemDocument.getTesisInfrastructureCollection()) {
                TesisSystemDocument oldFkTesisSystemDocumentOfTesisInfrastructureCollectionTesisInfrastructure = tesisInfrastructureCollectionTesisInfrastructure.getFkTesisSystemDocument();
                tesisInfrastructureCollectionTesisInfrastructure.setFkTesisSystemDocument(tesisSystemDocument);
                tesisInfrastructureCollectionTesisInfrastructure = em.merge(tesisInfrastructureCollectionTesisInfrastructure);
                if (oldFkTesisSystemDocumentOfTesisInfrastructureCollectionTesisInfrastructure != null) {
                    oldFkTesisSystemDocumentOfTesisInfrastructureCollectionTesisInfrastructure.getTesisInfrastructureCollection().remove(tesisInfrastructureCollectionTesisInfrastructure);
                    oldFkTesisSystemDocumentOfTesisInfrastructureCollectionTesisInfrastructure = em.merge(oldFkTesisSystemDocumentOfTesisInfrastructureCollectionTesisInfrastructure);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisSystemDocument tesisSystemDocument) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemDocument persistentTesisSystemDocument = em.find(TesisSystemDocument.class, tesisSystemDocument.getCodTesisSystemDocument());
            Collection<TesisMasters> tesisMastersCollectionOld = persistentTesisSystemDocument.getTesisMastersCollection();
            Collection<TesisMasters> tesisMastersCollectionNew = tesisSystemDocument.getTesisMastersCollection();
            Collection<TesisOffer> tesisOfferCollectionOld = persistentTesisSystemDocument.getTesisOfferCollection();
            Collection<TesisOffer> tesisOfferCollectionNew = tesisSystemDocument.getTesisOfferCollection();
            Collection<TesisPlans> tesisPlansCollectionOld = persistentTesisSystemDocument.getTesisPlansCollection();
            Collection<TesisPlans> tesisPlansCollectionNew = tesisSystemDocument.getTesisPlansCollection();
            Collection<TesisCulture> tesisCultureCollectionOld = persistentTesisSystemDocument.getTesisCultureCollection();
            Collection<TesisCulture> tesisCultureCollectionNew = tesisSystemDocument.getTesisCultureCollection();
            Collection<TesisInfrastructure> tesisInfrastructureCollectionOld = persistentTesisSystemDocument.getTesisInfrastructureCollection();
            Collection<TesisInfrastructure> tesisInfrastructureCollectionNew = tesisSystemDocument.getTesisInfrastructureCollection();
            Collection<TesisMasters> attachedTesisMastersCollectionNew = new ArrayList<TesisMasters>();
            for (TesisMasters tesisMastersCollectionNewTesisMastersToAttach : tesisMastersCollectionNew) {
                tesisMastersCollectionNewTesisMastersToAttach = em.getReference(tesisMastersCollectionNewTesisMastersToAttach.getClass(), tesisMastersCollectionNewTesisMastersToAttach.getCodTesisMasters());
                attachedTesisMastersCollectionNew.add(tesisMastersCollectionNewTesisMastersToAttach);
            }
            tesisMastersCollectionNew = attachedTesisMastersCollectionNew;
            tesisSystemDocument.setTesisMastersCollection(tesisMastersCollectionNew);
            Collection<TesisOffer> attachedTesisOfferCollectionNew = new ArrayList<TesisOffer>();
            for (TesisOffer tesisOfferCollectionNewTesisOfferToAttach : tesisOfferCollectionNew) {
                tesisOfferCollectionNewTesisOfferToAttach = em.getReference(tesisOfferCollectionNewTesisOfferToAttach.getClass(), tesisOfferCollectionNewTesisOfferToAttach.getCodTesisOffer());
                attachedTesisOfferCollectionNew.add(tesisOfferCollectionNewTesisOfferToAttach);
            }
            tesisOfferCollectionNew = attachedTesisOfferCollectionNew;
            tesisSystemDocument.setTesisOfferCollection(tesisOfferCollectionNew);
            Collection<TesisPlans> attachedTesisPlansCollectionNew = new ArrayList<TesisPlans>();
            for (TesisPlans tesisPlansCollectionNewTesisPlansToAttach : tesisPlansCollectionNew) {
                tesisPlansCollectionNewTesisPlansToAttach = em.getReference(tesisPlansCollectionNewTesisPlansToAttach.getClass(), tesisPlansCollectionNewTesisPlansToAttach.getCodTesisPlans());
                attachedTesisPlansCollectionNew.add(tesisPlansCollectionNewTesisPlansToAttach);
            }
            tesisPlansCollectionNew = attachedTesisPlansCollectionNew;
            tesisSystemDocument.setTesisPlansCollection(tesisPlansCollectionNew);
            Collection<TesisCulture> attachedTesisCultureCollectionNew = new ArrayList<TesisCulture>();
            for (TesisCulture tesisCultureCollectionNewTesisCultureToAttach : tesisCultureCollectionNew) {
                tesisCultureCollectionNewTesisCultureToAttach = em.getReference(tesisCultureCollectionNewTesisCultureToAttach.getClass(), tesisCultureCollectionNewTesisCultureToAttach.getCodTesisCulture());
                attachedTesisCultureCollectionNew.add(tesisCultureCollectionNewTesisCultureToAttach);
            }
            tesisCultureCollectionNew = attachedTesisCultureCollectionNew;
            tesisSystemDocument.setTesisCultureCollection(tesisCultureCollectionNew);
            Collection<TesisInfrastructure> attachedTesisInfrastructureCollectionNew = new ArrayList<TesisInfrastructure>();
            for (TesisInfrastructure tesisInfrastructureCollectionNewTesisInfrastructureToAttach : tesisInfrastructureCollectionNew) {
                tesisInfrastructureCollectionNewTesisInfrastructureToAttach = em.getReference(tesisInfrastructureCollectionNewTesisInfrastructureToAttach.getClass(), tesisInfrastructureCollectionNewTesisInfrastructureToAttach.getCodTesisInfrastructure());
                attachedTesisInfrastructureCollectionNew.add(tesisInfrastructureCollectionNewTesisInfrastructureToAttach);
            }
            tesisInfrastructureCollectionNew = attachedTesisInfrastructureCollectionNew;
            tesisSystemDocument.setTesisInfrastructureCollection(tesisInfrastructureCollectionNew);
            tesisSystemDocument = em.merge(tesisSystemDocument);
            for (TesisMasters tesisMastersCollectionOldTesisMasters : tesisMastersCollectionOld) {
                if (!tesisMastersCollectionNew.contains(tesisMastersCollectionOldTesisMasters)) {
                    tesisMastersCollectionOldTesisMasters.setFkTesisSystemDocument(null);
                    tesisMastersCollectionOldTesisMasters = em.merge(tesisMastersCollectionOldTesisMasters);
                }
            }
            for (TesisMasters tesisMastersCollectionNewTesisMasters : tesisMastersCollectionNew) {
                if (!tesisMastersCollectionOld.contains(tesisMastersCollectionNewTesisMasters)) {
                    TesisSystemDocument oldFkTesisSystemDocumentOfTesisMastersCollectionNewTesisMasters = tesisMastersCollectionNewTesisMasters.getFkTesisSystemDocument();
                    tesisMastersCollectionNewTesisMasters.setFkTesisSystemDocument(tesisSystemDocument);
                    tesisMastersCollectionNewTesisMasters = em.merge(tesisMastersCollectionNewTesisMasters);
                    if (oldFkTesisSystemDocumentOfTesisMastersCollectionNewTesisMasters != null && !oldFkTesisSystemDocumentOfTesisMastersCollectionNewTesisMasters.equals(tesisSystemDocument)) {
                        oldFkTesisSystemDocumentOfTesisMastersCollectionNewTesisMasters.getTesisMastersCollection().remove(tesisMastersCollectionNewTesisMasters);
                        oldFkTesisSystemDocumentOfTesisMastersCollectionNewTesisMasters = em.merge(oldFkTesisSystemDocumentOfTesisMastersCollectionNewTesisMasters);
                    }
                }
            }
            for (TesisOffer tesisOfferCollectionOldTesisOffer : tesisOfferCollectionOld) {
                if (!tesisOfferCollectionNew.contains(tesisOfferCollectionOldTesisOffer)) {
                    tesisOfferCollectionOldTesisOffer.setFkTesisSystemDocument(null);
                    tesisOfferCollectionOldTesisOffer = em.merge(tesisOfferCollectionOldTesisOffer);
                }
            }
            for (TesisOffer tesisOfferCollectionNewTesisOffer : tesisOfferCollectionNew) {
                if (!tesisOfferCollectionOld.contains(tesisOfferCollectionNewTesisOffer)) {
                    TesisSystemDocument oldFkTesisSystemDocumentOfTesisOfferCollectionNewTesisOffer = tesisOfferCollectionNewTesisOffer.getFkTesisSystemDocument();
                    tesisOfferCollectionNewTesisOffer.setFkTesisSystemDocument(tesisSystemDocument);
                    tesisOfferCollectionNewTesisOffer = em.merge(tesisOfferCollectionNewTesisOffer);
                    if (oldFkTesisSystemDocumentOfTesisOfferCollectionNewTesisOffer != null && !oldFkTesisSystemDocumentOfTesisOfferCollectionNewTesisOffer.equals(tesisSystemDocument)) {
                        oldFkTesisSystemDocumentOfTesisOfferCollectionNewTesisOffer.getTesisOfferCollection().remove(tesisOfferCollectionNewTesisOffer);
                        oldFkTesisSystemDocumentOfTesisOfferCollectionNewTesisOffer = em.merge(oldFkTesisSystemDocumentOfTesisOfferCollectionNewTesisOffer);
                    }
                }
            }
            for (TesisPlans tesisPlansCollectionOldTesisPlans : tesisPlansCollectionOld) {
                if (!tesisPlansCollectionNew.contains(tesisPlansCollectionOldTesisPlans)) {
                    tesisPlansCollectionOldTesisPlans.setFkTesisSystemDocument(null);
                    tesisPlansCollectionOldTesisPlans = em.merge(tesisPlansCollectionOldTesisPlans);
                }
            }
            for (TesisPlans tesisPlansCollectionNewTesisPlans : tesisPlansCollectionNew) {
                if (!tesisPlansCollectionOld.contains(tesisPlansCollectionNewTesisPlans)) {
                    TesisSystemDocument oldFkTesisSystemDocumentOfTesisPlansCollectionNewTesisPlans = tesisPlansCollectionNewTesisPlans.getFkTesisSystemDocument();
                    tesisPlansCollectionNewTesisPlans.setFkTesisSystemDocument(tesisSystemDocument);
                    tesisPlansCollectionNewTesisPlans = em.merge(tesisPlansCollectionNewTesisPlans);
                    if (oldFkTesisSystemDocumentOfTesisPlansCollectionNewTesisPlans != null && !oldFkTesisSystemDocumentOfTesisPlansCollectionNewTesisPlans.equals(tesisSystemDocument)) {
                        oldFkTesisSystemDocumentOfTesisPlansCollectionNewTesisPlans.getTesisPlansCollection().remove(tesisPlansCollectionNewTesisPlans);
                        oldFkTesisSystemDocumentOfTesisPlansCollectionNewTesisPlans = em.merge(oldFkTesisSystemDocumentOfTesisPlansCollectionNewTesisPlans);
                    }
                }
            }
            for (TesisCulture tesisCultureCollectionOldTesisCulture : tesisCultureCollectionOld) {
                if (!tesisCultureCollectionNew.contains(tesisCultureCollectionOldTesisCulture)) {
                    tesisCultureCollectionOldTesisCulture.setFkSystemDocument(null);
                    tesisCultureCollectionOldTesisCulture = em.merge(tesisCultureCollectionOldTesisCulture);
                }
            }
            for (TesisCulture tesisCultureCollectionNewTesisCulture : tesisCultureCollectionNew) {
                if (!tesisCultureCollectionOld.contains(tesisCultureCollectionNewTesisCulture)) {
                    TesisSystemDocument oldFkSystemDocumentOfTesisCultureCollectionNewTesisCulture = tesisCultureCollectionNewTesisCulture.getFkSystemDocument();
                    tesisCultureCollectionNewTesisCulture.setFkSystemDocument(tesisSystemDocument);
                    tesisCultureCollectionNewTesisCulture = em.merge(tesisCultureCollectionNewTesisCulture);
                    if (oldFkSystemDocumentOfTesisCultureCollectionNewTesisCulture != null && !oldFkSystemDocumentOfTesisCultureCollectionNewTesisCulture.equals(tesisSystemDocument)) {
                        oldFkSystemDocumentOfTesisCultureCollectionNewTesisCulture.getTesisCultureCollection().remove(tesisCultureCollectionNewTesisCulture);
                        oldFkSystemDocumentOfTesisCultureCollectionNewTesisCulture = em.merge(oldFkSystemDocumentOfTesisCultureCollectionNewTesisCulture);
                    }
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionOldTesisInfrastructure : tesisInfrastructureCollectionOld) {
                if (!tesisInfrastructureCollectionNew.contains(tesisInfrastructureCollectionOldTesisInfrastructure)) {
                    tesisInfrastructureCollectionOldTesisInfrastructure.setFkTesisSystemDocument(null);
                    tesisInfrastructureCollectionOldTesisInfrastructure = em.merge(tesisInfrastructureCollectionOldTesisInfrastructure);
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionNewTesisInfrastructure : tesisInfrastructureCollectionNew) {
                if (!tesisInfrastructureCollectionOld.contains(tesisInfrastructureCollectionNewTesisInfrastructure)) {
                    TesisSystemDocument oldFkTesisSystemDocumentOfTesisInfrastructureCollectionNewTesisInfrastructure = tesisInfrastructureCollectionNewTesisInfrastructure.getFkTesisSystemDocument();
                    tesisInfrastructureCollectionNewTesisInfrastructure.setFkTesisSystemDocument(tesisSystemDocument);
                    tesisInfrastructureCollectionNewTesisInfrastructure = em.merge(tesisInfrastructureCollectionNewTesisInfrastructure);
                    if (oldFkTesisSystemDocumentOfTesisInfrastructureCollectionNewTesisInfrastructure != null && !oldFkTesisSystemDocumentOfTesisInfrastructureCollectionNewTesisInfrastructure.equals(tesisSystemDocument)) {
                        oldFkTesisSystemDocumentOfTesisInfrastructureCollectionNewTesisInfrastructure.getTesisInfrastructureCollection().remove(tesisInfrastructureCollectionNewTesisInfrastructure);
                        oldFkTesisSystemDocumentOfTesisInfrastructureCollectionNewTesisInfrastructure = em.merge(oldFkTesisSystemDocumentOfTesisInfrastructureCollectionNewTesisInfrastructure);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisSystemDocument.getCodTesisSystemDocument();
                if (findTesisSystemDocument(id) == null) {
                    throw new NonexistentEntityException("The tesisSystemDocument with id " + id + " no longer exists.");
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
            TesisSystemDocument tesisSystemDocument;
            try {
                tesisSystemDocument = em.getReference(TesisSystemDocument.class, id);
                tesisSystemDocument.getCodTesisSystemDocument();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisSystemDocument with id " + id + " no longer exists.", enfe);
            }
            Collection<TesisMasters> tesisMastersCollection = tesisSystemDocument.getTesisMastersCollection();
            for (TesisMasters tesisMastersCollectionTesisMasters : tesisMastersCollection) {
                tesisMastersCollectionTesisMasters.setFkTesisSystemDocument(null);
                tesisMastersCollectionTesisMasters = em.merge(tesisMastersCollectionTesisMasters);
            }
            Collection<TesisOffer> tesisOfferCollection = tesisSystemDocument.getTesisOfferCollection();
            for (TesisOffer tesisOfferCollectionTesisOffer : tesisOfferCollection) {
                tesisOfferCollectionTesisOffer.setFkTesisSystemDocument(null);
                tesisOfferCollectionTesisOffer = em.merge(tesisOfferCollectionTesisOffer);
            }
            Collection<TesisPlans> tesisPlansCollection = tesisSystemDocument.getTesisPlansCollection();
            for (TesisPlans tesisPlansCollectionTesisPlans : tesisPlansCollection) {
                tesisPlansCollectionTesisPlans.setFkTesisSystemDocument(null);
                tesisPlansCollectionTesisPlans = em.merge(tesisPlansCollectionTesisPlans);
            }
            Collection<TesisCulture> tesisCultureCollection = tesisSystemDocument.getTesisCultureCollection();
            for (TesisCulture tesisCultureCollectionTesisCulture : tesisCultureCollection) {
                tesisCultureCollectionTesisCulture.setFkSystemDocument(null);
                tesisCultureCollectionTesisCulture = em.merge(tesisCultureCollectionTesisCulture);
            }
            Collection<TesisInfrastructure> tesisInfrastructureCollection = tesisSystemDocument.getTesisInfrastructureCollection();
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructure : tesisInfrastructureCollection) {
                tesisInfrastructureCollectionTesisInfrastructure.setFkTesisSystemDocument(null);
                tesisInfrastructureCollectionTesisInfrastructure = em.merge(tesisInfrastructureCollectionTesisInfrastructure);
            }
            em.remove(tesisSystemDocument);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisSystemDocument> findTesisSystemDocumentEntities() {
        return findTesisSystemDocumentEntities(true, -1, -1);
    }

    public List<TesisSystemDocument> findTesisSystemDocumentEntities(int maxResults, int firstResult) {
        return findTesisSystemDocumentEntities(false, maxResults, firstResult);
    }

    private List<TesisSystemDocument> findTesisSystemDocumentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisSystemDocument.class));
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

    public TesisSystemDocument findTesisSystemDocument(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisSystemDocument.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisSystemDocumentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisSystemDocument> rt = cq.from(TesisSystemDocument.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<TesisSystemDocument> findListTesisSystemDocumentByDocumentDescription(String description) {
        EntityManager em = getEntityManager();
        try {
            String queryString = "SELECT file FROM TesisSystemDocument file "
                    + "WHERE file.documentDescription =:des";
            Query query = em.createQuery(queryString);
            query.setParameter("des", description);
            return query.getResultList();
        } finally {
            em.close();
        }

    }

}

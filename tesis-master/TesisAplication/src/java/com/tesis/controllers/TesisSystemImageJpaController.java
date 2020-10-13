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
import com.tesis.model.entity.TesisSystemImage;
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
public class TesisSystemImageJpaController implements Serializable {

    public TesisSystemImageJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisSystemImage tesisSystemImage) {
        if (tesisSystemImage.getTesisMastersCollection() == null) {
            tesisSystemImage.setTesisMastersCollection(new ArrayList<TesisMasters>());
        }
        if (tesisSystemImage.getTesisOfferCollection() == null) {
            tesisSystemImage.setTesisOfferCollection(new ArrayList<TesisOffer>());
        }
        if (tesisSystemImage.getTesisPlansCollection() == null) {
            tesisSystemImage.setTesisPlansCollection(new ArrayList<TesisPlans>());
        }
        if (tesisSystemImage.getTesisCultureCollection() == null) {
            tesisSystemImage.setTesisCultureCollection(new ArrayList<TesisCulture>());
        }
        if (tesisSystemImage.getTesisInfrastructureCollection() == null) {
            tesisSystemImage.setTesisInfrastructureCollection(new ArrayList<TesisInfrastructure>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TesisMasters> attachedTesisMastersCollection = new ArrayList<TesisMasters>();
            for (TesisMasters tesisMastersCollectionTesisMastersToAttach : tesisSystemImage.getTesisMastersCollection()) {
                tesisMastersCollectionTesisMastersToAttach = em.getReference(tesisMastersCollectionTesisMastersToAttach.getClass(), tesisMastersCollectionTesisMastersToAttach.getCodTesisMasters());
                attachedTesisMastersCollection.add(tesisMastersCollectionTesisMastersToAttach);
            }
            tesisSystemImage.setTesisMastersCollection(attachedTesisMastersCollection);
            Collection<TesisOffer> attachedTesisOfferCollection = new ArrayList<TesisOffer>();
            for (TesisOffer tesisOfferCollectionTesisOfferToAttach : tesisSystemImage.getTesisOfferCollection()) {
                tesisOfferCollectionTesisOfferToAttach = em.getReference(tesisOfferCollectionTesisOfferToAttach.getClass(), tesisOfferCollectionTesisOfferToAttach.getCodTesisOffer());
                attachedTesisOfferCollection.add(tesisOfferCollectionTesisOfferToAttach);
            }
            tesisSystemImage.setTesisOfferCollection(attachedTesisOfferCollection);
            Collection<TesisPlans> attachedTesisPlansCollection = new ArrayList<TesisPlans>();
            for (TesisPlans tesisPlansCollectionTesisPlansToAttach : tesisSystemImage.getTesisPlansCollection()) {
                tesisPlansCollectionTesisPlansToAttach = em.getReference(tesisPlansCollectionTesisPlansToAttach.getClass(), tesisPlansCollectionTesisPlansToAttach.getCodTesisPlans());
                attachedTesisPlansCollection.add(tesisPlansCollectionTesisPlansToAttach);
            }
            tesisSystemImage.setTesisPlansCollection(attachedTesisPlansCollection);
            Collection<TesisCulture> attachedTesisCultureCollection = new ArrayList<TesisCulture>();
            for (TesisCulture tesisCultureCollectionTesisCultureToAttach : tesisSystemImage.getTesisCultureCollection()) {
                tesisCultureCollectionTesisCultureToAttach = em.getReference(tesisCultureCollectionTesisCultureToAttach.getClass(), tesisCultureCollectionTesisCultureToAttach.getCodTesisCulture());
                attachedTesisCultureCollection.add(tesisCultureCollectionTesisCultureToAttach);
            }
            tesisSystemImage.setTesisCultureCollection(attachedTesisCultureCollection);
            Collection<TesisInfrastructure> attachedTesisInfrastructureCollection = new ArrayList<TesisInfrastructure>();
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructureToAttach : tesisSystemImage.getTesisInfrastructureCollection()) {
                tesisInfrastructureCollectionTesisInfrastructureToAttach = em.getReference(tesisInfrastructureCollectionTesisInfrastructureToAttach.getClass(), tesisInfrastructureCollectionTesisInfrastructureToAttach.getCodTesisInfrastructure());
                attachedTesisInfrastructureCollection.add(tesisInfrastructureCollectionTesisInfrastructureToAttach);
            }
            tesisSystemImage.setTesisInfrastructureCollection(attachedTesisInfrastructureCollection);
            em.persist(tesisSystemImage);
            for (TesisMasters tesisMastersCollectionTesisMasters : tesisSystemImage.getTesisMastersCollection()) {
                TesisSystemImage oldFkTesisSystemImagesOfTesisMastersCollectionTesisMasters = tesisMastersCollectionTesisMasters.getFkTesisSystemImages();
                tesisMastersCollectionTesisMasters.setFkTesisSystemImages(tesisSystemImage);
                tesisMastersCollectionTesisMasters = em.merge(tesisMastersCollectionTesisMasters);
                if (oldFkTesisSystemImagesOfTesisMastersCollectionTesisMasters != null) {
                    oldFkTesisSystemImagesOfTesisMastersCollectionTesisMasters.getTesisMastersCollection().remove(tesisMastersCollectionTesisMasters);
                    oldFkTesisSystemImagesOfTesisMastersCollectionTesisMasters = em.merge(oldFkTesisSystemImagesOfTesisMastersCollectionTesisMasters);
                }
            }
            for (TesisOffer tesisOfferCollectionTesisOffer : tesisSystemImage.getTesisOfferCollection()) {
                TesisSystemImage oldFkTesisSystemImageOfTesisOfferCollectionTesisOffer = tesisOfferCollectionTesisOffer.getFkTesisSystemImage();
                tesisOfferCollectionTesisOffer.setFkTesisSystemImage(tesisSystemImage);
                tesisOfferCollectionTesisOffer = em.merge(tesisOfferCollectionTesisOffer);
                if (oldFkTesisSystemImageOfTesisOfferCollectionTesisOffer != null) {
                    oldFkTesisSystemImageOfTesisOfferCollectionTesisOffer.getTesisOfferCollection().remove(tesisOfferCollectionTesisOffer);
                    oldFkTesisSystemImageOfTesisOfferCollectionTesisOffer = em.merge(oldFkTesisSystemImageOfTesisOfferCollectionTesisOffer);
                }
            }
            for (TesisPlans tesisPlansCollectionTesisPlans : tesisSystemImage.getTesisPlansCollection()) {
                TesisSystemImage oldFkTesisSystemImagesOfTesisPlansCollectionTesisPlans = tesisPlansCollectionTesisPlans.getFkTesisSystemImages();
                tesisPlansCollectionTesisPlans.setFkTesisSystemImages(tesisSystemImage);
                tesisPlansCollectionTesisPlans = em.merge(tesisPlansCollectionTesisPlans);
                if (oldFkTesisSystemImagesOfTesisPlansCollectionTesisPlans != null) {
                    oldFkTesisSystemImagesOfTesisPlansCollectionTesisPlans.getTesisPlansCollection().remove(tesisPlansCollectionTesisPlans);
                    oldFkTesisSystemImagesOfTesisPlansCollectionTesisPlans = em.merge(oldFkTesisSystemImagesOfTesisPlansCollectionTesisPlans);
                }
            }
            for (TesisCulture tesisCultureCollectionTesisCulture : tesisSystemImage.getTesisCultureCollection()) {
                TesisSystemImage oldFkSystemImagesOfTesisCultureCollectionTesisCulture = tesisCultureCollectionTesisCulture.getFkSystemImages();
                tesisCultureCollectionTesisCulture.setFkSystemImages(tesisSystemImage);
                tesisCultureCollectionTesisCulture = em.merge(tesisCultureCollectionTesisCulture);
                if (oldFkSystemImagesOfTesisCultureCollectionTesisCulture != null) {
                    oldFkSystemImagesOfTesisCultureCollectionTesisCulture.getTesisCultureCollection().remove(tesisCultureCollectionTesisCulture);
                    oldFkSystemImagesOfTesisCultureCollectionTesisCulture = em.merge(oldFkSystemImagesOfTesisCultureCollectionTesisCulture);
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructure : tesisSystemImage.getTesisInfrastructureCollection()) {
                TesisSystemImage oldFkTesisSystemImagesOfTesisInfrastructureCollectionTesisInfrastructure = tesisInfrastructureCollectionTesisInfrastructure.getFkTesisSystemImages();
                tesisInfrastructureCollectionTesisInfrastructure.setFkTesisSystemImages(tesisSystemImage);
                tesisInfrastructureCollectionTesisInfrastructure = em.merge(tesisInfrastructureCollectionTesisInfrastructure);
                if (oldFkTesisSystemImagesOfTesisInfrastructureCollectionTesisInfrastructure != null) {
                    oldFkTesisSystemImagesOfTesisInfrastructureCollectionTesisInfrastructure.getTesisInfrastructureCollection().remove(tesisInfrastructureCollectionTesisInfrastructure);
                    oldFkTesisSystemImagesOfTesisInfrastructureCollectionTesisInfrastructure = em.merge(oldFkTesisSystemImagesOfTesisInfrastructureCollectionTesisInfrastructure);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisSystemImage tesisSystemImage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisSystemImage persistentTesisSystemImage = em.find(TesisSystemImage.class, tesisSystemImage.getCodTesisSystemImages());
            Collection<TesisMasters> tesisMastersCollectionOld = persistentTesisSystemImage.getTesisMastersCollection();
            Collection<TesisMasters> tesisMastersCollectionNew = tesisSystemImage.getTesisMastersCollection();
            Collection<TesisOffer> tesisOfferCollectionOld = persistentTesisSystemImage.getTesisOfferCollection();
            Collection<TesisOffer> tesisOfferCollectionNew = tesisSystemImage.getTesisOfferCollection();
            Collection<TesisPlans> tesisPlansCollectionOld = persistentTesisSystemImage.getTesisPlansCollection();
            Collection<TesisPlans> tesisPlansCollectionNew = tesisSystemImage.getTesisPlansCollection();
            Collection<TesisCulture> tesisCultureCollectionOld = persistentTesisSystemImage.getTesisCultureCollection();
            Collection<TesisCulture> tesisCultureCollectionNew = tesisSystemImage.getTesisCultureCollection();
            Collection<TesisInfrastructure> tesisInfrastructureCollectionOld = persistentTesisSystemImage.getTesisInfrastructureCollection();
            Collection<TesisInfrastructure> tesisInfrastructureCollectionNew = tesisSystemImage.getTesisInfrastructureCollection();
            Collection<TesisMasters> attachedTesisMastersCollectionNew = new ArrayList<TesisMasters>();
            for (TesisMasters tesisMastersCollectionNewTesisMastersToAttach : tesisMastersCollectionNew) {
                tesisMastersCollectionNewTesisMastersToAttach = em.getReference(tesisMastersCollectionNewTesisMastersToAttach.getClass(), tesisMastersCollectionNewTesisMastersToAttach.getCodTesisMasters());
                attachedTesisMastersCollectionNew.add(tesisMastersCollectionNewTesisMastersToAttach);
            }
            tesisMastersCollectionNew = attachedTesisMastersCollectionNew;
            tesisSystemImage.setTesisMastersCollection(tesisMastersCollectionNew);
            Collection<TesisOffer> attachedTesisOfferCollectionNew = new ArrayList<TesisOffer>();
            for (TesisOffer tesisOfferCollectionNewTesisOfferToAttach : tesisOfferCollectionNew) {
                tesisOfferCollectionNewTesisOfferToAttach = em.getReference(tesisOfferCollectionNewTesisOfferToAttach.getClass(), tesisOfferCollectionNewTesisOfferToAttach.getCodTesisOffer());
                attachedTesisOfferCollectionNew.add(tesisOfferCollectionNewTesisOfferToAttach);
            }
            tesisOfferCollectionNew = attachedTesisOfferCollectionNew;
            tesisSystemImage.setTesisOfferCollection(tesisOfferCollectionNew);
            Collection<TesisPlans> attachedTesisPlansCollectionNew = new ArrayList<TesisPlans>();
            for (TesisPlans tesisPlansCollectionNewTesisPlansToAttach : tesisPlansCollectionNew) {
                tesisPlansCollectionNewTesisPlansToAttach = em.getReference(tesisPlansCollectionNewTesisPlansToAttach.getClass(), tesisPlansCollectionNewTesisPlansToAttach.getCodTesisPlans());
                attachedTesisPlansCollectionNew.add(tesisPlansCollectionNewTesisPlansToAttach);
            }
            tesisPlansCollectionNew = attachedTesisPlansCollectionNew;
            tesisSystemImage.setTesisPlansCollection(tesisPlansCollectionNew);
            Collection<TesisCulture> attachedTesisCultureCollectionNew = new ArrayList<TesisCulture>();
            for (TesisCulture tesisCultureCollectionNewTesisCultureToAttach : tesisCultureCollectionNew) {
                tesisCultureCollectionNewTesisCultureToAttach = em.getReference(tesisCultureCollectionNewTesisCultureToAttach.getClass(), tesisCultureCollectionNewTesisCultureToAttach.getCodTesisCulture());
                attachedTesisCultureCollectionNew.add(tesisCultureCollectionNewTesisCultureToAttach);
            }
            tesisCultureCollectionNew = attachedTesisCultureCollectionNew;
            tesisSystemImage.setTesisCultureCollection(tesisCultureCollectionNew);
            Collection<TesisInfrastructure> attachedTesisInfrastructureCollectionNew = new ArrayList<TesisInfrastructure>();
            for (TesisInfrastructure tesisInfrastructureCollectionNewTesisInfrastructureToAttach : tesisInfrastructureCollectionNew) {
                tesisInfrastructureCollectionNewTesisInfrastructureToAttach = em.getReference(tesisInfrastructureCollectionNewTesisInfrastructureToAttach.getClass(), tesisInfrastructureCollectionNewTesisInfrastructureToAttach.getCodTesisInfrastructure());
                attachedTesisInfrastructureCollectionNew.add(tesisInfrastructureCollectionNewTesisInfrastructureToAttach);
            }
            tesisInfrastructureCollectionNew = attachedTesisInfrastructureCollectionNew;
            tesisSystemImage.setTesisInfrastructureCollection(tesisInfrastructureCollectionNew);
            tesisSystemImage = em.merge(tesisSystemImage);
            for (TesisMasters tesisMastersCollectionOldTesisMasters : tesisMastersCollectionOld) {
                if (!tesisMastersCollectionNew.contains(tesisMastersCollectionOldTesisMasters)) {
                    tesisMastersCollectionOldTesisMasters.setFkTesisSystemImages(null);
                    tesisMastersCollectionOldTesisMasters = em.merge(tesisMastersCollectionOldTesisMasters);
                }
            }
            for (TesisMasters tesisMastersCollectionNewTesisMasters : tesisMastersCollectionNew) {
                if (!tesisMastersCollectionOld.contains(tesisMastersCollectionNewTesisMasters)) {
                    TesisSystemImage oldFkTesisSystemImagesOfTesisMastersCollectionNewTesisMasters = tesisMastersCollectionNewTesisMasters.getFkTesisSystemImages();
                    tesisMastersCollectionNewTesisMasters.setFkTesisSystemImages(tesisSystemImage);
                    tesisMastersCollectionNewTesisMasters = em.merge(tesisMastersCollectionNewTesisMasters);
                    if (oldFkTesisSystemImagesOfTesisMastersCollectionNewTesisMasters != null && !oldFkTesisSystemImagesOfTesisMastersCollectionNewTesisMasters.equals(tesisSystemImage)) {
                        oldFkTesisSystemImagesOfTesisMastersCollectionNewTesisMasters.getTesisMastersCollection().remove(tesisMastersCollectionNewTesisMasters);
                        oldFkTesisSystemImagesOfTesisMastersCollectionNewTesisMasters = em.merge(oldFkTesisSystemImagesOfTesisMastersCollectionNewTesisMasters);
                    }
                }
            }
            for (TesisOffer tesisOfferCollectionOldTesisOffer : tesisOfferCollectionOld) {
                if (!tesisOfferCollectionNew.contains(tesisOfferCollectionOldTesisOffer)) {
                    tesisOfferCollectionOldTesisOffer.setFkTesisSystemImage(null);
                    tesisOfferCollectionOldTesisOffer = em.merge(tesisOfferCollectionOldTesisOffer);
                }
            }
            for (TesisOffer tesisOfferCollectionNewTesisOffer : tesisOfferCollectionNew) {
                if (!tesisOfferCollectionOld.contains(tesisOfferCollectionNewTesisOffer)) {
                    TesisSystemImage oldFkTesisSystemImageOfTesisOfferCollectionNewTesisOffer = tesisOfferCollectionNewTesisOffer.getFkTesisSystemImage();
                    tesisOfferCollectionNewTesisOffer.setFkTesisSystemImage(tesisSystemImage);
                    tesisOfferCollectionNewTesisOffer = em.merge(tesisOfferCollectionNewTesisOffer);
                    if (oldFkTesisSystemImageOfTesisOfferCollectionNewTesisOffer != null && !oldFkTesisSystemImageOfTesisOfferCollectionNewTesisOffer.equals(tesisSystemImage)) {
                        oldFkTesisSystemImageOfTesisOfferCollectionNewTesisOffer.getTesisOfferCollection().remove(tesisOfferCollectionNewTesisOffer);
                        oldFkTesisSystemImageOfTesisOfferCollectionNewTesisOffer = em.merge(oldFkTesisSystemImageOfTesisOfferCollectionNewTesisOffer);
                    }
                }
            }
            for (TesisPlans tesisPlansCollectionOldTesisPlans : tesisPlansCollectionOld) {
                if (!tesisPlansCollectionNew.contains(tesisPlansCollectionOldTesisPlans)) {
                    tesisPlansCollectionOldTesisPlans.setFkTesisSystemImages(null);
                    tesisPlansCollectionOldTesisPlans = em.merge(tesisPlansCollectionOldTesisPlans);
                }
            }
            for (TesisPlans tesisPlansCollectionNewTesisPlans : tesisPlansCollectionNew) {
                if (!tesisPlansCollectionOld.contains(tesisPlansCollectionNewTesisPlans)) {
                    TesisSystemImage oldFkTesisSystemImagesOfTesisPlansCollectionNewTesisPlans = tesisPlansCollectionNewTesisPlans.getFkTesisSystemImages();
                    tesisPlansCollectionNewTesisPlans.setFkTesisSystemImages(tesisSystemImage);
                    tesisPlansCollectionNewTesisPlans = em.merge(tesisPlansCollectionNewTesisPlans);
                    if (oldFkTesisSystemImagesOfTesisPlansCollectionNewTesisPlans != null && !oldFkTesisSystemImagesOfTesisPlansCollectionNewTesisPlans.equals(tesisSystemImage)) {
                        oldFkTesisSystemImagesOfTesisPlansCollectionNewTesisPlans.getTesisPlansCollection().remove(tesisPlansCollectionNewTesisPlans);
                        oldFkTesisSystemImagesOfTesisPlansCollectionNewTesisPlans = em.merge(oldFkTesisSystemImagesOfTesisPlansCollectionNewTesisPlans);
                    }
                }
            }
            for (TesisCulture tesisCultureCollectionOldTesisCulture : tesisCultureCollectionOld) {
                if (!tesisCultureCollectionNew.contains(tesisCultureCollectionOldTesisCulture)) {
                    tesisCultureCollectionOldTesisCulture.setFkSystemImages(null);
                    tesisCultureCollectionOldTesisCulture = em.merge(tesisCultureCollectionOldTesisCulture);
                }
            }
            for (TesisCulture tesisCultureCollectionNewTesisCulture : tesisCultureCollectionNew) {
                if (!tesisCultureCollectionOld.contains(tesisCultureCollectionNewTesisCulture)) {
                    TesisSystemImage oldFkSystemImagesOfTesisCultureCollectionNewTesisCulture = tesisCultureCollectionNewTesisCulture.getFkSystemImages();
                    tesisCultureCollectionNewTesisCulture.setFkSystemImages(tesisSystemImage);
                    tesisCultureCollectionNewTesisCulture = em.merge(tesisCultureCollectionNewTesisCulture);
                    if (oldFkSystemImagesOfTesisCultureCollectionNewTesisCulture != null && !oldFkSystemImagesOfTesisCultureCollectionNewTesisCulture.equals(tesisSystemImage)) {
                        oldFkSystemImagesOfTesisCultureCollectionNewTesisCulture.getTesisCultureCollection().remove(tesisCultureCollectionNewTesisCulture);
                        oldFkSystemImagesOfTesisCultureCollectionNewTesisCulture = em.merge(oldFkSystemImagesOfTesisCultureCollectionNewTesisCulture);
                    }
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionOldTesisInfrastructure : tesisInfrastructureCollectionOld) {
                if (!tesisInfrastructureCollectionNew.contains(tesisInfrastructureCollectionOldTesisInfrastructure)) {
                    tesisInfrastructureCollectionOldTesisInfrastructure.setFkTesisSystemImages(null);
                    tesisInfrastructureCollectionOldTesisInfrastructure = em.merge(tesisInfrastructureCollectionOldTesisInfrastructure);
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionNewTesisInfrastructure : tesisInfrastructureCollectionNew) {
                if (!tesisInfrastructureCollectionOld.contains(tesisInfrastructureCollectionNewTesisInfrastructure)) {
                    TesisSystemImage oldFkTesisSystemImagesOfTesisInfrastructureCollectionNewTesisInfrastructure = tesisInfrastructureCollectionNewTesisInfrastructure.getFkTesisSystemImages();
                    tesisInfrastructureCollectionNewTesisInfrastructure.setFkTesisSystemImages(tesisSystemImage);
                    tesisInfrastructureCollectionNewTesisInfrastructure = em.merge(tesisInfrastructureCollectionNewTesisInfrastructure);
                    if (oldFkTesisSystemImagesOfTesisInfrastructureCollectionNewTesisInfrastructure != null && !oldFkTesisSystemImagesOfTesisInfrastructureCollectionNewTesisInfrastructure.equals(tesisSystemImage)) {
                        oldFkTesisSystemImagesOfTesisInfrastructureCollectionNewTesisInfrastructure.getTesisInfrastructureCollection().remove(tesisInfrastructureCollectionNewTesisInfrastructure);
                        oldFkTesisSystemImagesOfTesisInfrastructureCollectionNewTesisInfrastructure = em.merge(oldFkTesisSystemImagesOfTesisInfrastructureCollectionNewTesisInfrastructure);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisSystemImage.getCodTesisSystemImages();
                if (findTesisSystemImage(id) == null) {
                    throw new NonexistentEntityException("The tesisSystemImage with id " + id + " no longer exists.");
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
            TesisSystemImage tesisSystemImage;
            try {
                tesisSystemImage = em.getReference(TesisSystemImage.class, id);
                tesisSystemImage.getCodTesisSystemImages();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisSystemImage with id " + id + " no longer exists.", enfe);
            }
            Collection<TesisMasters> tesisMastersCollection = tesisSystemImage.getTesisMastersCollection();
            for (TesisMasters tesisMastersCollectionTesisMasters : tesisMastersCollection) {
                tesisMastersCollectionTesisMasters.setFkTesisSystemImages(null);
                tesisMastersCollectionTesisMasters = em.merge(tesisMastersCollectionTesisMasters);
            }
            Collection<TesisOffer> tesisOfferCollection = tesisSystemImage.getTesisOfferCollection();
            for (TesisOffer tesisOfferCollectionTesisOffer : tesisOfferCollection) {
                tesisOfferCollectionTesisOffer.setFkTesisSystemImage(null);
                tesisOfferCollectionTesisOffer = em.merge(tesisOfferCollectionTesisOffer);
            }
            Collection<TesisPlans> tesisPlansCollection = tesisSystemImage.getTesisPlansCollection();
            for (TesisPlans tesisPlansCollectionTesisPlans : tesisPlansCollection) {
                tesisPlansCollectionTesisPlans.setFkTesisSystemImages(null);
                tesisPlansCollectionTesisPlans = em.merge(tesisPlansCollectionTesisPlans);
            }
            Collection<TesisCulture> tesisCultureCollection = tesisSystemImage.getTesisCultureCollection();
            for (TesisCulture tesisCultureCollectionTesisCulture : tesisCultureCollection) {
                tesisCultureCollectionTesisCulture.setFkSystemImages(null);
                tesisCultureCollectionTesisCulture = em.merge(tesisCultureCollectionTesisCulture);
            }
            Collection<TesisInfrastructure> tesisInfrastructureCollection = tesisSystemImage.getTesisInfrastructureCollection();
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructure : tesisInfrastructureCollection) {
                tesisInfrastructureCollectionTesisInfrastructure.setFkTesisSystemImages(null);
                tesisInfrastructureCollectionTesisInfrastructure = em.merge(tesisInfrastructureCollectionTesisInfrastructure);
            }
            em.remove(tesisSystemImage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisSystemImage> findTesisSystemImageEntities() {
        return findTesisSystemImageEntities(true, -1, -1);
    }

    public List<TesisSystemImage> findTesisSystemImageEntities(int maxResults, int firstResult) {
        return findTesisSystemImageEntities(false, maxResults, firstResult);
    }

    private List<TesisSystemImage> findTesisSystemImageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisSystemImage.class));
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

    public TesisSystemImage findTesisSystemImage(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisSystemImage.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisSystemImageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisSystemImage> rt = cq.from(TesisSystemImage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public TesisSystemImage findTesisSystemImageByImageDescription(String name) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisSystemImage> query = em.createQuery("SELECT image FROM TesisSystemImage image WHERE image.imageDescription =:name", TesisSystemImage.class);
            return query.setParameter("name", name).getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<TesisSystemImage> findListTesisSystemImageByImageDescription(String description) {
        EntityManager em = getEntityManager();
        try {
            String queryString = "SELECT images FROM TesisSystemImage images "
                    + "WHERE images.imageDescription =:des";
            Query query = em.createQuery(queryString);
            query.setParameter("des", description);
            return query.getResultList();
        } finally {
            em.close();
        }

    }

}

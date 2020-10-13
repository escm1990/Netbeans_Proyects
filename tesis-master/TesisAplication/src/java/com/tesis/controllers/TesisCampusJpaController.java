/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.controllers;

import com.tesis.controllers.exceptions.NonexistentEntityException;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisCulture;
import com.tesis.model.entity.TesisInfrastructure;
import com.tesis.model.entity.TesisMasters;
import com.tesis.model.entity.TesisOffer;
import com.tesis.model.entity.TesisPlans;
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
public class TesisCampusJpaController implements Serializable {

    public TesisCampusJpaController() {
        this.emf = JpaUtil.getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TesisCampus tesisCampus) {
        if (tesisCampus.getTesisMastersCollection() == null) {
            tesisCampus.setTesisMastersCollection(new ArrayList<TesisMasters>());
        }
        if (tesisCampus.getTesisOfferCollection() == null) {
            tesisCampus.setTesisOfferCollection(new ArrayList<TesisOffer>());
        }
        if (tesisCampus.getTesisPlansCollection() == null) {
            tesisCampus.setTesisPlansCollection(new ArrayList<TesisPlans>());
        }
        if (tesisCampus.getTesisUserCampusCollection() == null) {
            tesisCampus.setTesisUserCampusCollection(new ArrayList<TesisUserCampus>());
        }
        if (tesisCampus.getTesisCultureCollection() == null) {
            tesisCampus.setTesisCultureCollection(new ArrayList<TesisCulture>());
        }
        if (tesisCampus.getTesisInfrastructureCollection() == null) {
            tesisCampus.setTesisInfrastructureCollection(new ArrayList<TesisInfrastructure>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TesisMasters> attachedTesisMastersCollection = new ArrayList<TesisMasters>();
            for (TesisMasters tesisMastersCollectionTesisMastersToAttach : tesisCampus.getTesisMastersCollection()) {
                tesisMastersCollectionTesisMastersToAttach = em.getReference(tesisMastersCollectionTesisMastersToAttach.getClass(), tesisMastersCollectionTesisMastersToAttach.getCodTesisMasters());
                attachedTesisMastersCollection.add(tesisMastersCollectionTesisMastersToAttach);
            }
            tesisCampus.setTesisMastersCollection(attachedTesisMastersCollection);
            Collection<TesisOffer> attachedTesisOfferCollection = new ArrayList<TesisOffer>();
            for (TesisOffer tesisOfferCollectionTesisOfferToAttach : tesisCampus.getTesisOfferCollection()) {
                tesisOfferCollectionTesisOfferToAttach = em.getReference(tesisOfferCollectionTesisOfferToAttach.getClass(), tesisOfferCollectionTesisOfferToAttach.getCodTesisOffer());
                attachedTesisOfferCollection.add(tesisOfferCollectionTesisOfferToAttach);
            }
            tesisCampus.setTesisOfferCollection(attachedTesisOfferCollection);
            Collection<TesisPlans> attachedTesisPlansCollection = new ArrayList<TesisPlans>();
            for (TesisPlans tesisPlansCollectionTesisPlansToAttach : tesisCampus.getTesisPlansCollection()) {
                tesisPlansCollectionTesisPlansToAttach = em.getReference(tesisPlansCollectionTesisPlansToAttach.getClass(), tesisPlansCollectionTesisPlansToAttach.getCodTesisPlans());
                attachedTesisPlansCollection.add(tesisPlansCollectionTesisPlansToAttach);
            }
            tesisCampus.setTesisPlansCollection(attachedTesisPlansCollection);
            Collection<TesisUserCampus> attachedTesisUserCampusCollection = new ArrayList<TesisUserCampus>();
            for (TesisUserCampus tesisUserCampusCollectionTesisUserCampusToAttach : tesisCampus.getTesisUserCampusCollection()) {
                tesisUserCampusCollectionTesisUserCampusToAttach = em.getReference(tesisUserCampusCollectionTesisUserCampusToAttach.getClass(), tesisUserCampusCollectionTesisUserCampusToAttach.getCodTesisUserCampus());
                attachedTesisUserCampusCollection.add(tesisUserCampusCollectionTesisUserCampusToAttach);
            }
            tesisCampus.setTesisUserCampusCollection(attachedTesisUserCampusCollection);
            Collection<TesisCulture> attachedTesisCultureCollection = new ArrayList<TesisCulture>();
            for (TesisCulture tesisCultureCollectionTesisCultureToAttach : tesisCampus.getTesisCultureCollection()) {
                tesisCultureCollectionTesisCultureToAttach = em.getReference(tesisCultureCollectionTesisCultureToAttach.getClass(), tesisCultureCollectionTesisCultureToAttach.getCodTesisCulture());
                attachedTesisCultureCollection.add(tesisCultureCollectionTesisCultureToAttach);
            }
            tesisCampus.setTesisCultureCollection(attachedTesisCultureCollection);
            Collection<TesisInfrastructure> attachedTesisInfrastructureCollection = new ArrayList<TesisInfrastructure>();
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructureToAttach : tesisCampus.getTesisInfrastructureCollection()) {
                tesisInfrastructureCollectionTesisInfrastructureToAttach = em.getReference(tesisInfrastructureCollectionTesisInfrastructureToAttach.getClass(), tesisInfrastructureCollectionTesisInfrastructureToAttach.getCodTesisInfrastructure());
                attachedTesisInfrastructureCollection.add(tesisInfrastructureCollectionTesisInfrastructureToAttach);
            }
            tesisCampus.setTesisInfrastructureCollection(attachedTesisInfrastructureCollection);
            em.persist(tesisCampus);
            for (TesisMasters tesisMastersCollectionTesisMasters : tesisCampus.getTesisMastersCollection()) {
                TesisCampus oldFkTesisCampusOfTesisMastersCollectionTesisMasters = tesisMastersCollectionTesisMasters.getFkTesisCampus();
                tesisMastersCollectionTesisMasters.setFkTesisCampus(tesisCampus);
                tesisMastersCollectionTesisMasters = em.merge(tesisMastersCollectionTesisMasters);
                if (oldFkTesisCampusOfTesisMastersCollectionTesisMasters != null) {
                    oldFkTesisCampusOfTesisMastersCollectionTesisMasters.getTesisMastersCollection().remove(tesisMastersCollectionTesisMasters);
                    oldFkTesisCampusOfTesisMastersCollectionTesisMasters = em.merge(oldFkTesisCampusOfTesisMastersCollectionTesisMasters);
                }
            }
            for (TesisOffer tesisOfferCollectionTesisOffer : tesisCampus.getTesisOfferCollection()) {
                TesisCampus oldFkTesisCampusOfTesisOfferCollectionTesisOffer = tesisOfferCollectionTesisOffer.getFkTesisCampus();
                tesisOfferCollectionTesisOffer.setFkTesisCampus(tesisCampus);
                tesisOfferCollectionTesisOffer = em.merge(tesisOfferCollectionTesisOffer);
                if (oldFkTesisCampusOfTesisOfferCollectionTesisOffer != null) {
                    oldFkTesisCampusOfTesisOfferCollectionTesisOffer.getTesisOfferCollection().remove(tesisOfferCollectionTesisOffer);
                    oldFkTesisCampusOfTesisOfferCollectionTesisOffer = em.merge(oldFkTesisCampusOfTesisOfferCollectionTesisOffer);
                }
            }
            for (TesisPlans tesisPlansCollectionTesisPlans : tesisCampus.getTesisPlansCollection()) {
                TesisCampus oldFkTesisCampusOfTesisPlansCollectionTesisPlans = tesisPlansCollectionTesisPlans.getFkTesisCampus();
                tesisPlansCollectionTesisPlans.setFkTesisCampus(tesisCampus);
                tesisPlansCollectionTesisPlans = em.merge(tesisPlansCollectionTesisPlans);
                if (oldFkTesisCampusOfTesisPlansCollectionTesisPlans != null) {
                    oldFkTesisCampusOfTesisPlansCollectionTesisPlans.getTesisPlansCollection().remove(tesisPlansCollectionTesisPlans);
                    oldFkTesisCampusOfTesisPlansCollectionTesisPlans = em.merge(oldFkTesisCampusOfTesisPlansCollectionTesisPlans);
                }
            }
            for (TesisUserCampus tesisUserCampusCollectionTesisUserCampus : tesisCampus.getTesisUserCampusCollection()) {
                TesisCampus oldFkTesisCampusOfTesisUserCampusCollectionTesisUserCampus = tesisUserCampusCollectionTesisUserCampus.getFkTesisCampus();
                tesisUserCampusCollectionTesisUserCampus.setFkTesisCampus(tesisCampus);
                tesisUserCampusCollectionTesisUserCampus = em.merge(tesisUserCampusCollectionTesisUserCampus);
                if (oldFkTesisCampusOfTesisUserCampusCollectionTesisUserCampus != null) {
                    oldFkTesisCampusOfTesisUserCampusCollectionTesisUserCampus.getTesisUserCampusCollection().remove(tesisUserCampusCollectionTesisUserCampus);
                    oldFkTesisCampusOfTesisUserCampusCollectionTesisUserCampus = em.merge(oldFkTesisCampusOfTesisUserCampusCollectionTesisUserCampus);
                }
            }
            for (TesisCulture tesisCultureCollectionTesisCulture : tesisCampus.getTesisCultureCollection()) {
                TesisCampus oldFkTesisCampusOfTesisCultureCollectionTesisCulture = tesisCultureCollectionTesisCulture.getFkTesisCampus();
                tesisCultureCollectionTesisCulture.setFkTesisCampus(tesisCampus);
                tesisCultureCollectionTesisCulture = em.merge(tesisCultureCollectionTesisCulture);
                if (oldFkTesisCampusOfTesisCultureCollectionTesisCulture != null) {
                    oldFkTesisCampusOfTesisCultureCollectionTesisCulture.getTesisCultureCollection().remove(tesisCultureCollectionTesisCulture);
                    oldFkTesisCampusOfTesisCultureCollectionTesisCulture = em.merge(oldFkTesisCampusOfTesisCultureCollectionTesisCulture);
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructure : tesisCampus.getTesisInfrastructureCollection()) {
                TesisCampus oldFkTesisCampusOfTesisInfrastructureCollectionTesisInfrastructure = tesisInfrastructureCollectionTesisInfrastructure.getFkTesisCampus();
                tesisInfrastructureCollectionTesisInfrastructure.setFkTesisCampus(tesisCampus);
                tesisInfrastructureCollectionTesisInfrastructure = em.merge(tesisInfrastructureCollectionTesisInfrastructure);
                if (oldFkTesisCampusOfTesisInfrastructureCollectionTesisInfrastructure != null) {
                    oldFkTesisCampusOfTesisInfrastructureCollectionTesisInfrastructure.getTesisInfrastructureCollection().remove(tesisInfrastructureCollectionTesisInfrastructure);
                    oldFkTesisCampusOfTesisInfrastructureCollectionTesisInfrastructure = em.merge(oldFkTesisCampusOfTesisInfrastructureCollectionTesisInfrastructure);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TesisCampus tesisCampus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TesisCampus persistentTesisCampus = em.find(TesisCampus.class, tesisCampus.getCodTesisCampus());
            Collection<TesisMasters> tesisMastersCollectionOld = persistentTesisCampus.getTesisMastersCollection();
            Collection<TesisMasters> tesisMastersCollectionNew = tesisCampus.getTesisMastersCollection();
            Collection<TesisOffer> tesisOfferCollectionOld = persistentTesisCampus.getTesisOfferCollection();
            Collection<TesisOffer> tesisOfferCollectionNew = tesisCampus.getTesisOfferCollection();
            Collection<TesisPlans> tesisPlansCollectionOld = persistentTesisCampus.getTesisPlansCollection();
            Collection<TesisPlans> tesisPlansCollectionNew = tesisCampus.getTesisPlansCollection();
            Collection<TesisUserCampus> tesisUserCampusCollectionOld = persistentTesisCampus.getTesisUserCampusCollection();
            Collection<TesisUserCampus> tesisUserCampusCollectionNew = tesisCampus.getTesisUserCampusCollection();
            Collection<TesisCulture> tesisCultureCollectionOld = persistentTesisCampus.getTesisCultureCollection();
            Collection<TesisCulture> tesisCultureCollectionNew = tesisCampus.getTesisCultureCollection();
            Collection<TesisInfrastructure> tesisInfrastructureCollectionOld = persistentTesisCampus.getTesisInfrastructureCollection();
            Collection<TesisInfrastructure> tesisInfrastructureCollectionNew = tesisCampus.getTesisInfrastructureCollection();
            Collection<TesisMasters> attachedTesisMastersCollectionNew = new ArrayList<TesisMasters>();
            for (TesisMasters tesisMastersCollectionNewTesisMastersToAttach : tesisMastersCollectionNew) {
                tesisMastersCollectionNewTesisMastersToAttach = em.getReference(tesisMastersCollectionNewTesisMastersToAttach.getClass(), tesisMastersCollectionNewTesisMastersToAttach.getCodTesisMasters());
                attachedTesisMastersCollectionNew.add(tesisMastersCollectionNewTesisMastersToAttach);
            }
            tesisMastersCollectionNew = attachedTesisMastersCollectionNew;
            tesisCampus.setTesisMastersCollection(tesisMastersCollectionNew);
            Collection<TesisOffer> attachedTesisOfferCollectionNew = new ArrayList<TesisOffer>();
            for (TesisOffer tesisOfferCollectionNewTesisOfferToAttach : tesisOfferCollectionNew) {
                tesisOfferCollectionNewTesisOfferToAttach = em.getReference(tesisOfferCollectionNewTesisOfferToAttach.getClass(), tesisOfferCollectionNewTesisOfferToAttach.getCodTesisOffer());
                attachedTesisOfferCollectionNew.add(tesisOfferCollectionNewTesisOfferToAttach);
            }
            tesisOfferCollectionNew = attachedTesisOfferCollectionNew;
            tesisCampus.setTesisOfferCollection(tesisOfferCollectionNew);
            Collection<TesisPlans> attachedTesisPlansCollectionNew = new ArrayList<TesisPlans>();
            for (TesisPlans tesisPlansCollectionNewTesisPlansToAttach : tesisPlansCollectionNew) {
                tesisPlansCollectionNewTesisPlansToAttach = em.getReference(tesisPlansCollectionNewTesisPlansToAttach.getClass(), tesisPlansCollectionNewTesisPlansToAttach.getCodTesisPlans());
                attachedTesisPlansCollectionNew.add(tesisPlansCollectionNewTesisPlansToAttach);
            }
            tesisPlansCollectionNew = attachedTesisPlansCollectionNew;
            tesisCampus.setTesisPlansCollection(tesisPlansCollectionNew);
            Collection<TesisUserCampus> attachedTesisUserCampusCollectionNew = new ArrayList<TesisUserCampus>();
            for (TesisUserCampus tesisUserCampusCollectionNewTesisUserCampusToAttach : tesisUserCampusCollectionNew) {
                tesisUserCampusCollectionNewTesisUserCampusToAttach = em.getReference(tesisUserCampusCollectionNewTesisUserCampusToAttach.getClass(), tesisUserCampusCollectionNewTesisUserCampusToAttach.getCodTesisUserCampus());
                attachedTesisUserCampusCollectionNew.add(tesisUserCampusCollectionNewTesisUserCampusToAttach);
            }
            tesisUserCampusCollectionNew = attachedTesisUserCampusCollectionNew;
            tesisCampus.setTesisUserCampusCollection(tesisUserCampusCollectionNew);
            Collection<TesisCulture> attachedTesisCultureCollectionNew = new ArrayList<TesisCulture>();
            for (TesisCulture tesisCultureCollectionNewTesisCultureToAttach : tesisCultureCollectionNew) {
                tesisCultureCollectionNewTesisCultureToAttach = em.getReference(tesisCultureCollectionNewTesisCultureToAttach.getClass(), tesisCultureCollectionNewTesisCultureToAttach.getCodTesisCulture());
                attachedTesisCultureCollectionNew.add(tesisCultureCollectionNewTesisCultureToAttach);
            }
            tesisCultureCollectionNew = attachedTesisCultureCollectionNew;
            tesisCampus.setTesisCultureCollection(tesisCultureCollectionNew);
            Collection<TesisInfrastructure> attachedTesisInfrastructureCollectionNew = new ArrayList<TesisInfrastructure>();
            for (TesisInfrastructure tesisInfrastructureCollectionNewTesisInfrastructureToAttach : tesisInfrastructureCollectionNew) {
                tesisInfrastructureCollectionNewTesisInfrastructureToAttach = em.getReference(tesisInfrastructureCollectionNewTesisInfrastructureToAttach.getClass(), tesisInfrastructureCollectionNewTesisInfrastructureToAttach.getCodTesisInfrastructure());
                attachedTesisInfrastructureCollectionNew.add(tesisInfrastructureCollectionNewTesisInfrastructureToAttach);
            }
            tesisInfrastructureCollectionNew = attachedTesisInfrastructureCollectionNew;
            tesisCampus.setTesisInfrastructureCollection(tesisInfrastructureCollectionNew);
            tesisCampus = em.merge(tesisCampus);
            for (TesisMasters tesisMastersCollectionOldTesisMasters : tesisMastersCollectionOld) {
                if (!tesisMastersCollectionNew.contains(tesisMastersCollectionOldTesisMasters)) {
                    tesisMastersCollectionOldTesisMasters.setFkTesisCampus(null);
                    tesisMastersCollectionOldTesisMasters = em.merge(tesisMastersCollectionOldTesisMasters);
                }
            }
            for (TesisMasters tesisMastersCollectionNewTesisMasters : tesisMastersCollectionNew) {
                if (!tesisMastersCollectionOld.contains(tesisMastersCollectionNewTesisMasters)) {
                    TesisCampus oldFkTesisCampusOfTesisMastersCollectionNewTesisMasters = tesisMastersCollectionNewTesisMasters.getFkTesisCampus();
                    tesisMastersCollectionNewTesisMasters.setFkTesisCampus(tesisCampus);
                    tesisMastersCollectionNewTesisMasters = em.merge(tesisMastersCollectionNewTesisMasters);
                    if (oldFkTesisCampusOfTesisMastersCollectionNewTesisMasters != null && !oldFkTesisCampusOfTesisMastersCollectionNewTesisMasters.equals(tesisCampus)) {
                        oldFkTesisCampusOfTesisMastersCollectionNewTesisMasters.getTesisMastersCollection().remove(tesisMastersCollectionNewTesisMasters);
                        oldFkTesisCampusOfTesisMastersCollectionNewTesisMasters = em.merge(oldFkTesisCampusOfTesisMastersCollectionNewTesisMasters);
                    }
                }
            }
            for (TesisOffer tesisOfferCollectionOldTesisOffer : tesisOfferCollectionOld) {
                if (!tesisOfferCollectionNew.contains(tesisOfferCollectionOldTesisOffer)) {
                    tesisOfferCollectionOldTesisOffer.setFkTesisCampus(null);
                    tesisOfferCollectionOldTesisOffer = em.merge(tesisOfferCollectionOldTesisOffer);
                }
            }
            for (TesisOffer tesisOfferCollectionNewTesisOffer : tesisOfferCollectionNew) {
                if (!tesisOfferCollectionOld.contains(tesisOfferCollectionNewTesisOffer)) {
                    TesisCampus oldFkTesisCampusOfTesisOfferCollectionNewTesisOffer = tesisOfferCollectionNewTesisOffer.getFkTesisCampus();
                    tesisOfferCollectionNewTesisOffer.setFkTesisCampus(tesisCampus);
                    tesisOfferCollectionNewTesisOffer = em.merge(tesisOfferCollectionNewTesisOffer);
                    if (oldFkTesisCampusOfTesisOfferCollectionNewTesisOffer != null && !oldFkTesisCampusOfTesisOfferCollectionNewTesisOffer.equals(tesisCampus)) {
                        oldFkTesisCampusOfTesisOfferCollectionNewTesisOffer.getTesisOfferCollection().remove(tesisOfferCollectionNewTesisOffer);
                        oldFkTesisCampusOfTesisOfferCollectionNewTesisOffer = em.merge(oldFkTesisCampusOfTesisOfferCollectionNewTesisOffer);
                    }
                }
            }
            for (TesisPlans tesisPlansCollectionOldTesisPlans : tesisPlansCollectionOld) {
                if (!tesisPlansCollectionNew.contains(tesisPlansCollectionOldTesisPlans)) {
                    tesisPlansCollectionOldTesisPlans.setFkTesisCampus(null);
                    tesisPlansCollectionOldTesisPlans = em.merge(tesisPlansCollectionOldTesisPlans);
                }
            }
            for (TesisPlans tesisPlansCollectionNewTesisPlans : tesisPlansCollectionNew) {
                if (!tesisPlansCollectionOld.contains(tesisPlansCollectionNewTesisPlans)) {
                    TesisCampus oldFkTesisCampusOfTesisPlansCollectionNewTesisPlans = tesisPlansCollectionNewTesisPlans.getFkTesisCampus();
                    tesisPlansCollectionNewTesisPlans.setFkTesisCampus(tesisCampus);
                    tesisPlansCollectionNewTesisPlans = em.merge(tesisPlansCollectionNewTesisPlans);
                    if (oldFkTesisCampusOfTesisPlansCollectionNewTesisPlans != null && !oldFkTesisCampusOfTesisPlansCollectionNewTesisPlans.equals(tesisCampus)) {
                        oldFkTesisCampusOfTesisPlansCollectionNewTesisPlans.getTesisPlansCollection().remove(tesisPlansCollectionNewTesisPlans);
                        oldFkTesisCampusOfTesisPlansCollectionNewTesisPlans = em.merge(oldFkTesisCampusOfTesisPlansCollectionNewTesisPlans);
                    }
                }
            }
            for (TesisUserCampus tesisUserCampusCollectionOldTesisUserCampus : tesisUserCampusCollectionOld) {
                if (!tesisUserCampusCollectionNew.contains(tesisUserCampusCollectionOldTesisUserCampus)) {
                    tesisUserCampusCollectionOldTesisUserCampus.setFkTesisCampus(null);
                    tesisUserCampusCollectionOldTesisUserCampus = em.merge(tesisUserCampusCollectionOldTesisUserCampus);
                }
            }
            for (TesisUserCampus tesisUserCampusCollectionNewTesisUserCampus : tesisUserCampusCollectionNew) {
                if (!tesisUserCampusCollectionOld.contains(tesisUserCampusCollectionNewTesisUserCampus)) {
                    TesisCampus oldFkTesisCampusOfTesisUserCampusCollectionNewTesisUserCampus = tesisUserCampusCollectionNewTesisUserCampus.getFkTesisCampus();
                    tesisUserCampusCollectionNewTesisUserCampus.setFkTesisCampus(tesisCampus);
                    tesisUserCampusCollectionNewTesisUserCampus = em.merge(tesisUserCampusCollectionNewTesisUserCampus);
                    if (oldFkTesisCampusOfTesisUserCampusCollectionNewTesisUserCampus != null && !oldFkTesisCampusOfTesisUserCampusCollectionNewTesisUserCampus.equals(tesisCampus)) {
                        oldFkTesisCampusOfTesisUserCampusCollectionNewTesisUserCampus.getTesisUserCampusCollection().remove(tesisUserCampusCollectionNewTesisUserCampus);
                        oldFkTesisCampusOfTesisUserCampusCollectionNewTesisUserCampus = em.merge(oldFkTesisCampusOfTesisUserCampusCollectionNewTesisUserCampus);
                    }
                }
            }
            for (TesisCulture tesisCultureCollectionOldTesisCulture : tesisCultureCollectionOld) {
                if (!tesisCultureCollectionNew.contains(tesisCultureCollectionOldTesisCulture)) {
                    tesisCultureCollectionOldTesisCulture.setFkTesisCampus(null);
                    tesisCultureCollectionOldTesisCulture = em.merge(tesisCultureCollectionOldTesisCulture);
                }
            }
            for (TesisCulture tesisCultureCollectionNewTesisCulture : tesisCultureCollectionNew) {
                if (!tesisCultureCollectionOld.contains(tesisCultureCollectionNewTesisCulture)) {
                    TesisCampus oldFkTesisCampusOfTesisCultureCollectionNewTesisCulture = tesisCultureCollectionNewTesisCulture.getFkTesisCampus();
                    tesisCultureCollectionNewTesisCulture.setFkTesisCampus(tesisCampus);
                    tesisCultureCollectionNewTesisCulture = em.merge(tesisCultureCollectionNewTesisCulture);
                    if (oldFkTesisCampusOfTesisCultureCollectionNewTesisCulture != null && !oldFkTesisCampusOfTesisCultureCollectionNewTesisCulture.equals(tesisCampus)) {
                        oldFkTesisCampusOfTesisCultureCollectionNewTesisCulture.getTesisCultureCollection().remove(tesisCultureCollectionNewTesisCulture);
                        oldFkTesisCampusOfTesisCultureCollectionNewTesisCulture = em.merge(oldFkTesisCampusOfTesisCultureCollectionNewTesisCulture);
                    }
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionOldTesisInfrastructure : tesisInfrastructureCollectionOld) {
                if (!tesisInfrastructureCollectionNew.contains(tesisInfrastructureCollectionOldTesisInfrastructure)) {
                    tesisInfrastructureCollectionOldTesisInfrastructure.setFkTesisCampus(null);
                    tesisInfrastructureCollectionOldTesisInfrastructure = em.merge(tesisInfrastructureCollectionOldTesisInfrastructure);
                }
            }
            for (TesisInfrastructure tesisInfrastructureCollectionNewTesisInfrastructure : tesisInfrastructureCollectionNew) {
                if (!tesisInfrastructureCollectionOld.contains(tesisInfrastructureCollectionNewTesisInfrastructure)) {
                    TesisCampus oldFkTesisCampusOfTesisInfrastructureCollectionNewTesisInfrastructure = tesisInfrastructureCollectionNewTesisInfrastructure.getFkTesisCampus();
                    tesisInfrastructureCollectionNewTesisInfrastructure.setFkTesisCampus(tesisCampus);
                    tesisInfrastructureCollectionNewTesisInfrastructure = em.merge(tesisInfrastructureCollectionNewTesisInfrastructure);
                    if (oldFkTesisCampusOfTesisInfrastructureCollectionNewTesisInfrastructure != null && !oldFkTesisCampusOfTesisInfrastructureCollectionNewTesisInfrastructure.equals(tesisCampus)) {
                        oldFkTesisCampusOfTesisInfrastructureCollectionNewTesisInfrastructure.getTesisInfrastructureCollection().remove(tesisInfrastructureCollectionNewTesisInfrastructure);
                        oldFkTesisCampusOfTesisInfrastructureCollectionNewTesisInfrastructure = em.merge(oldFkTesisCampusOfTesisInfrastructureCollectionNewTesisInfrastructure);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tesisCampus.getCodTesisCampus();
                if (findTesisCampus(id) == null) {
                    throw new NonexistentEntityException("The tesisCampus with id " + id + " no longer exists.");
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
            TesisCampus tesisCampus;
            try {
                tesisCampus = em.getReference(TesisCampus.class, id);
                tesisCampus.getCodTesisCampus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tesisCampus with id " + id + " no longer exists.", enfe);
            }
            Collection<TesisMasters> tesisMastersCollection = tesisCampus.getTesisMastersCollection();
            for (TesisMasters tesisMastersCollectionTesisMasters : tesisMastersCollection) {
                tesisMastersCollectionTesisMasters.setFkTesisCampus(null);
                tesisMastersCollectionTesisMasters = em.merge(tesisMastersCollectionTesisMasters);
            }
            Collection<TesisOffer> tesisOfferCollection = tesisCampus.getTesisOfferCollection();
            for (TesisOffer tesisOfferCollectionTesisOffer : tesisOfferCollection) {
                tesisOfferCollectionTesisOffer.setFkTesisCampus(null);
                tesisOfferCollectionTesisOffer = em.merge(tesisOfferCollectionTesisOffer);
            }
            Collection<TesisPlans> tesisPlansCollection = tesisCampus.getTesisPlansCollection();
            for (TesisPlans tesisPlansCollectionTesisPlans : tesisPlansCollection) {
                tesisPlansCollectionTesisPlans.setFkTesisCampus(null);
                tesisPlansCollectionTesisPlans = em.merge(tesisPlansCollectionTesisPlans);
            }
            Collection<TesisUserCampus> tesisUserCampusCollection = tesisCampus.getTesisUserCampusCollection();
            for (TesisUserCampus tesisUserCampusCollectionTesisUserCampus : tesisUserCampusCollection) {
                tesisUserCampusCollectionTesisUserCampus.setFkTesisCampus(null);
                tesisUserCampusCollectionTesisUserCampus = em.merge(tesisUserCampusCollectionTesisUserCampus);
            }
            Collection<TesisCulture> tesisCultureCollection = tesisCampus.getTesisCultureCollection();
            for (TesisCulture tesisCultureCollectionTesisCulture : tesisCultureCollection) {
                tesisCultureCollectionTesisCulture.setFkTesisCampus(null);
                tesisCultureCollectionTesisCulture = em.merge(tesisCultureCollectionTesisCulture);
            }
            Collection<TesisInfrastructure> tesisInfrastructureCollection = tesisCampus.getTesisInfrastructureCollection();
            for (TesisInfrastructure tesisInfrastructureCollectionTesisInfrastructure : tesisInfrastructureCollection) {
                tesisInfrastructureCollectionTesisInfrastructure.setFkTesisCampus(null);
                tesisInfrastructureCollectionTesisInfrastructure = em.merge(tesisInfrastructureCollectionTesisInfrastructure);
            }
            em.remove(tesisCampus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TesisCampus> findTesisCampusEntities() {
        return findTesisCampusEntities(true, -1, -1);
    }

    public List<TesisCampus> findTesisCampusEntities(int maxResults, int firstResult) {
        return findTesisCampusEntities(false, maxResults, firstResult);
    }

    private List<TesisCampus> findTesisCampusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TesisCampus.class));
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

    public TesisCampus findTesisCampus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TesisCampus.class, id);
        } finally {
            em.close();
        }
    }

    public int getTesisCampusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TesisCampus> rt = cq.from(TesisCampus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public TesisCampus findTesisCampusByCampusName(String name) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<TesisCampus> query = em.createQuery("SELECT campus FROM TesisCampus campus WHERE campus.campusName =:name", TesisCampus.class);
            return query.setParameter("name", name).getSingleResult();
        } finally {
            em.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs230.pz.ejb;

import com.cs230.pz.entity.PregledPacijenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Korsn
 */
@Stateless
public class PregledPacijentaFacade extends AbstractFacade<PregledPacijenta> {

    @PersistenceContext(unitName = "tutorialsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PregledPacijentaFacade() {
        super(PregledPacijenta.class);
    }
    
}

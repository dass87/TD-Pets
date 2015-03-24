/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.tripdashboard.pets.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.tripdashboard.pets.entities.Pet;

/**
 *
 * @author David
 */
@Stateless
public class PetFacade extends AbstractFacade<Pet> {
    @PersistenceContext(unitName = "pt.tripdashboard_pets_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PetFacade() {
        super(Pet.class);
    }
    
}

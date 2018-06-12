package com.cs230.pz.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cs230.pz.entity.Group;
import com.cs230.pz.entity.User;
import com.cs230.pz.utils.AuthenticationUtils;
import java.sql.SQLException;
import javax.ejb.EJBException;


@Stateless
public class UserEJB {
	
	@PersistenceContext(unitName="tutorialsPU")
	private EntityManager em;
	
	public User createUser(User user)  {
		try {
                    
                
			user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
                        
		}
                Group group = new Group();
 
		group.setEmail(user.getEmail());
		group.setGroupname(Group.USERS_GROUP);
                
		em.persist(user);
		em.persist(group);
		
		return user;
	}

	public User findUserById(String id) {
		TypedQuery<User> query = em.createNamedQuery("findUserById", User.class);
		query.setParameter("email", id);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			// getSingleResult throws NoResultException in case there is no user in DB
			// ignore exception and return NULL for user instead
		}
		return user;
	}
}

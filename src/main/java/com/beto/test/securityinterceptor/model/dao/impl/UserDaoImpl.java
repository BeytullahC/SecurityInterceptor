/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.dao.impl;

import com.beto.test.securityinterceptor.model.dao.UserDao;
import com.beto.test.securityinterceptor.model.entity.SecUserDef;
import com.beto.test.securityinterceptor.model.dao.generic.AbstractDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository(value ="userDaoImpl" )
public class UserDaoImpl extends AbstractDao<SecUserDef> implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public UserDaoImpl() {
        super(SecUserDef.class);
    }

    @Override
    public SecUserDef getUser(String login) {
        logger.debug("getUser method called..." + login);
        SecUserDef user;
        TypedQuery<SecUserDef> query = em.createNamedQuery("SecUserDef.findByUsername",SecUserDef.class);
        query.setParameter("username", login);
        user = query.getSingleResult();
        logger.debug(user.toString());
        return user;

    }

}

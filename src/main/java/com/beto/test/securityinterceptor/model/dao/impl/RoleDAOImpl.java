package com.beto.test.securityinterceptor.model.dao.impl;




import com.beto.test.securityinterceptor.model.dao.RoleDAO;
import com.beto.test.securityinterceptor.model.dao.generic.AbstractDao;
import com.beto.test.securityinterceptor.model.entity.SecRoleDef;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends AbstractDao<SecRoleDef> implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    public RoleDAOImpl() {
        super(SecRoleDef.class);
    }

    @Override
    public SecRoleDef getRole(int id) {
        SecRoleDef role = (SecRoleDef) em.find(SecRoleDef.class, id);
        return role;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

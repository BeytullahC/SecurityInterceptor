/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beto.test.securityinterceptor.model.dao.PageRoleDao;
import com.beto.test.securityinterceptor.model.dao.RoleDAO;
import com.beto.test.securityinterceptor.model.dao.UserDao;
import com.beto.test.securityinterceptor.model.entity.SecPageDef;
import com.beto.test.securityinterceptor.model.entity.SecPageRoleDef;
import com.beto.test.securityinterceptor.model.entity.SecUserDef;

@Service(value = "userPageRole")
@Transactional(readOnly = true)
public class UserPageRoleServiceImpl implements UserPageRoleService {

    private static final Logger logger = Logger.getLogger(UserPageRoleServiceImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PageRoleDao pageRoleDao;


    @Override
    public SecUserDef getUser(String login) {
        return userDao.getUser(login);
    }

    @Override
    public SecUserDef findByUsername(String userName) throws Exception {
        return getUser(userName);
    }

    @Override
    public List<SecPageRoleDef> findUrlByUrl(String url) throws Exception {
        
    	List<SecPageRoleDef> pageRoles =null;
    	try {
    		url=StringUtils.substringBefore(url, "?");
            logger.debug("findUrlByUrl method is called..." + url);
            TypedQuery<SecPageDef> createQuery = em.createNamedQuery("SecPageDef.findByViewId", SecPageDef.class);
            createQuery.setParameter("viewId", url);
            pageRoles = createQuery.getSingleResult().getSecPageRoleDefList();

            for (SecPageRoleDef pageRole : pageRoles) {
                logger.debug(pageRole.toString());
            }
		} catch (NoResultException e) {
			// TODO: handle exception
		}
        

        return pageRoles;
    }

    @Override
    public List<SecPageRoleDef> getAuthorizedPages(List<String> roles) throws Exception {
        TypedQuery<SecPageRoleDef> typedQuery = em.createQuery("SELECT p FROM PageRole p WHERE p.role IN=:roles", SecPageRoleDef.class);
        List<SecPageRoleDef> resultList = typedQuery.setParameter("roles", roles).getResultList();
        if (logger.isDebugEnabled()) {
            for (SecPageRoleDef pageRole : resultList) {
                logger.debug(pageRole.toString());
            }
        }
        return resultList;
    }

    @Override
    public List<SecPageRoleDef> getHigherRoles(Long roleOrder) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SecPageRoleDef> getRoleReleations(String role) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasPermission(String role, String viewId, String fieldCode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SecUserDef login(String userName, String pwd) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SecUserDef findByEmail(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

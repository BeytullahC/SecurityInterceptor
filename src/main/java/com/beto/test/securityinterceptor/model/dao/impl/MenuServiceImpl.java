/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.dao.impl;

import com.beto.test.securityinterceptor.model.dao.MenuService;
import com.beto.test.securityinterceptor.model.dao.PageDao;
import com.beto.test.securityinterceptor.model.dao.UserDao;
import com.beto.test.securityinterceptor.model.entity.SecPageDef;
import com.beto.test.securityinterceptor.model.entity.SecRoleDef;
import com.beto.test.securityinterceptor.model.util.ProjectUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 912867
 */
@Component
@Transactional
public class MenuServiceImpl implements MenuService, Serializable {

    private static final Logger LOGGER = Logger.getLogger(MenuServiceImpl.class);
    private static final long serialVersionUID = 1L;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PageDao pageDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<SecPageDef> pageList() {
        LOGGER.debug("\n\n\nTEST OK\n\n\n");
        List<SecRoleDef> secRoleDefs = userDao.getUser(ProjectUtil.getUser().getUsername()).getSecRoleDefList();
        List<String> list = new ArrayList<>();
        for (SecRoleDef secRoleDef : secRoleDefs) {
            list.add(secRoleDef.getRole());
        }
        TypedQuery<SecPageDef> tq = em.createQuery("SELECT DISTINCT(p) FROM SecPageRoleDef s,SecPageDef p WHERE s.role IN:inList AND s.viewId=p.viewId", SecPageDef.class);
        tq.setParameter("inList", list);
        return tq.getResultList();
    }
    
    public String test(){
        return "TEST OK";
    }

}

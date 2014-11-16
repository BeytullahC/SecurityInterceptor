/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.dao;

import com.beto.test.securityinterceptor.model.entity.SecUserDef;
import com.beto.test.securityinterceptor.model.dao.generic.IGenericDao;


/**
 *
 * @author Belgelerim
 */
public interface UserDao extends IGenericDao<SecUserDef>{
    
    public SecUserDef getUser(String login);
    
    
}

package com.beto.test.securityinterceptor.model.dao;

import com.beto.test.securityinterceptor.model.entity.SecRoleDef;
import com.beto.test.securityinterceptor.model.dao.generic.IGenericDao;


public interface RoleDAO extends IGenericDao<SecRoleDef>{
	
	public SecRoleDef getRole(int id);

}

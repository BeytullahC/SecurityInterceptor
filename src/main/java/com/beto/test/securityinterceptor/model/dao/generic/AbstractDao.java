/*
 * Copyright 2014 912867.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.beto.test.securityinterceptor.model.dao.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 912867
 * @param <T>
 */
@Repository
@Transactional
public abstract class AbstractDao<T> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDao.class);
    private final Class<T> entityClass;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    public boolean save(T t) throws Exception {
        getEntityManager().persist(t);
        return true;
    }

    public T update(T t) throws Exception {
        return getEntityManager().merge(t);
    }

    public boolean delete(T t) throws Exception {
        getEntityManager().remove(getEntityManager().merge(t));
        return true;
    }

    public T find(Serializable id){
    	  
        try {
        	 return getEntityManager().find(entityClass, id);
 	      } catch (NoResultException e) {
 		    LOGGER.debug("NO DATA FOUND...");
 	    } 
     	return null;
       
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
       
        try {
        	 CriteriaQuery<Object> cq = getEntityManager().getCriteriaBuilder().createQuery();
             cq.select(cq.from(entityClass));
             return (List<T>) getEntityManager().createQuery(cq).getResultList();
 	      } catch (NoResultException e) {
 		    LOGGER.debug("NO DATA FOUND...");
 	    } 
     	return null;
    }

    public List<T> getListWithNamedQuery(String query, String inParamName, List<?> inList) throws Exception {
        
        try {
        	TypedQuery<T> tq = getEntityManager().createNamedQuery(query, entityClass);
            tq.setParameter(inParamName, inList);
            return tq.getResultList();
 	      } catch (NoResultException e) {
 		    LOGGER.debug("NO DATA FOUND...");
 	    } 
     	return null;
    }

    public List<T> getListWithNamedQuery(String query, Map<String, Object> inList) throws Exception {
       try {
    	   TypedQuery<T> tq = getEntityManager().createNamedQuery(query, entityClass);
           for (Map.Entry<String, Object> entrySet : inList.entrySet()) {
               String key = entrySet.getKey();
               Object value = entrySet.getValue();
               tq.setParameter(key, value);
           }
           return tq.getResultList();
	      } catch (NoResultException e) {
		    LOGGER.debug("NO DATA FOUND...");
	    } 
    	return null;
    }

    public T getObWithNamedQuery(String query, String paramName, Object param) throws Exception {
        TypedQuery<T> tq = getEntityManager().createNamedQuery(query, entityClass);
        tq.setParameter(paramName, param);
        return tq.getSingleResult();
    }
    
    public List<T> selectNativeQueryToList(String Q) throws Exception{
        TypedQuery<T> tq = getEntityManager().createQuery(Q, entityClass);
        return tq.getResultList();
    }
    
   

}

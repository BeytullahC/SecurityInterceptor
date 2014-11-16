/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.domain;

import com.beto.test.securityinterceptor.model.entity.SecPageRoleDef;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Belgelerim
 */
@Component("singletonPageRole")
@Scope("singleton")
public class SingletonPageRole implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 116376467242211146L;

	private static final Logger logger = Logger.getLogger(SingletonPageRole.class);
    
    private Map<String,List<SecPageRoleDef>> permissions = new HashMap<String,List<SecPageRoleDef>>();
    
    //private long lastReset = System.currentTimeMillis();
    
    public SingletonPageRole() {
        super();
    }
    
    public synchronized void addPermissions(String url,List<SecPageRoleDef> permission){
        logger.debug("SecureSingletonBean.addPermissions() method called... url"+url);
        for (SecPageRoleDef secPageRoleDef : permission) {
            logger.debug(secPageRoleDef.toString());
        }
        permissions.put(url, permission);
    }
    
    public synchronized List<SecPageRoleDef> getPermissions(String url){
        logger.debug("SecureSingletonBean.getPermissions() method called...");
        //long elapsedTime = (((System.currentTimeMillis() - lastReset)/ 1000) / 60) % 60;
        permissions.clear();
//        if(elapsedTime >= 5){
//            lastReset = System.currentTimeMillis();
//            permissions.clear();
//        }
        return permissions.get(url);
    }
}

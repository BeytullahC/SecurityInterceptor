/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.security;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Belgelerim
 */
public class UserNamePasswordAuth extends UsernamePasswordAuthenticationFilter {
    
    
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        logger.debug("ExUsernamePasswordAuthenticationFilter.obtainUsername() method called..."+request.getParameter(getUsernameParameter())+"   "+request.getParameter(getPasswordParameter()));
        String username = request.getParameter(getUsernameParameter());
        String password = request.getParameter(getPasswordParameter());
        
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new BadCredentialsException("");
        }
        
       return  username;
    }
    
    
    
}

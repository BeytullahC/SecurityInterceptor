/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.util;

import com.beto.test.securityinterceptor.model.dao.UserDao;
import com.beto.test.securityinterceptor.model.entity.SecUserDef;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author 912867
 */
@Service
public class ProjectUtil {
    @Autowired
    private HttpSession httpSession;
    
    
    @Autowired
    private UserDao userDao;

    public static User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }

    public  SecUserDef getUserEntity() {
        return (SecUserDef) session().getAttribute("user-table");
    }

    public SecUserDef getUserWithDb() {
        return userDao.getUser(getUser().getUsername());
    }

    public  HttpSession session() {
       return httpSession;
    }
}

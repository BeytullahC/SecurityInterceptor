/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.security;


import com.beto.test.securityinterceptor.model.entity.SecPageRoleDef;
import com.beto.test.securityinterceptor.model.entity.SecUserDef;
import java.util.List;

/**
 *
 * @author Belgelerim
 */
public interface UserPageRoleService {
      
    public SecUserDef getUser(String login);

    public SecUserDef findByUsername(String userName) throws Exception;

    public List<SecPageRoleDef> findUrlByUrl(String url) throws Exception;

    public List<SecPageRoleDef> getAuthorizedPages(List<String> roles) throws Exception;

    public List<SecPageRoleDef> getHigherRoles(Long roleOrder) throws Exception;

    public List<SecPageRoleDef> getRoleReleations(String role) throws Exception;

    public boolean hasPermission(String role, String viewId, String fieldCode) throws Exception;

    public SecUserDef login(String userName, String pwd) throws Exception;

    public SecUserDef findByEmail(String email) throws Exception;
}

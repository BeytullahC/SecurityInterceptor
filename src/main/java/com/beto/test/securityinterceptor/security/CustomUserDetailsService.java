package com.beto.test.securityinterceptor.security;

import com.beto.test.securityinterceptor.model.dao.RoleDAO;
import com.beto.test.securityinterceptor.model.dao.UserDao;
import com.beto.test.securityinterceptor.model.entity.SecRoleDef;
import com.beto.test.securityinterceptor.model.util.ProjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserDao userDAO;

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private ProjectUtil util;

    Map<String, Object> paramMap = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        logger.debug("loadUserByUsername method called..." + login);
        if (roleDao == null) {
            logger.error("\n--------------\n ROLE DAO NUL \n---------------------\n");
        }
        if (userDAO == null) {
            logger.error("\n--------------\n USER DAO NUL \n---------------------\n");
        }
//        try {
//            ldapAuth.authenticate("912867", "Dakich+352").toString();
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(CustomUserDetailsService.class.getName()).log(Level.SEVERE, null, ex);
//        }
        paramMap.clear();
        paramMap.put("sicil", login);
        com.beto.test.securityinterceptor.model.entity.SecUserDef domainUser = null;

        try {
            domainUser = userDAO.getUser(login);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        
        return new User(
                domainUser.getUsername(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getSecRoleDefList())
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<SecRoleDef> roles) {
        logger.debug("getAuthorities method called...");
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(roles));
        return authList;
    }

    public List<String> getRoles(List<SecRoleDef> roleList) {

        try {
            logger.debug("getRoles method called..." + roleList);
            List<String> roles = new ArrayList<>();
            for (SecRoleDef roleFor : roleList) {
                roles.add(roleFor.getRole());
                logger.debug(roleFor.getRole());
            }
            return roles;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return null;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        logger.debug("getGrantedAuthorities method called...");
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}

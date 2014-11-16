package com.beto.test.securityinterceptor.security;


import com.beto.test.securityinterceptor.model.dao.PageRoleDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author 912867
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final Logger logger = Logger.getLogger(SecurityConfig.class);
    
    @Autowired
    private PageRoleDao pageRoleDao;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("configure method is called...");
        addPageAndRoles(http);
//        http.authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/login?error")
//                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .logout().logoutSuccessUrl("/login?logout")
//                .and()
//                .exceptionHandling().accessDeniedPage("/403")
//                .and()
//                .csrf();
    }
    
    public void addPageAndRoles(HttpSecurity http) throws Exception {
        logger.debug("addPageAndRoles method is called...");
//        try {
//            List<PageRole> pages = pageRoleDao.findAll();
//            for (PageRole page : pages) {
//                logger.debug("page  ... " + page.getPage().getPageUrl() + " ... " + page.getRoles().getRole());
//                http.authorizeRequests()
//                        .antMatchers(page.getPage().getPageUrl() + "/**").access("hasRole('" + page.getRoles().getRole() + "')");
//            }
//        } catch (Exception ex) {
//            logger.error(ex.getMessage(), ex);
//        }
        
    }
}

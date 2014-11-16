package com.beto.test.securityinterceptor.controller;

import com.beto.test.securityinterceptor.model.util.ProjectUtil;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private static final Logger logger = Logger.getLogger(HelloController.class);
    @Autowired
    private ProjectUtil pu;
//    @Autowired
//    private MenuService menuService;

    @RequestMapping(value = {"/welcome**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value ={"/","/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpSession session) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        } else if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
//        try {
//            userDao.findAll();
//        } catch (Exception ex) {
//            logger.error(ex);
//        }

        return model;

    }

    @RequestMapping(value = "/loginModal", method = RequestMethod.GET)
    public ModelAndView loginModal(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("loginModal");
//        try {
//            userDao.findAll();
//        } catch (Exception ex) {
//            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return model;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/notification")
    public ModelAndView notification() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("notification");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template")
    public ModelAndView template() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("template");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public ModelAndView index() {
        logger.debug("index method called");
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", ProjectUtil.getUser());
//        mav.addObject("menu", menuService.pageList());
        mav.setViewName("index");
        try {
            pu.session().setAttribute("user-table", pu.getUserWithDb());
            logger.debug("ENTITY USER" + pu.getUserEntity().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return mav;
    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }
}

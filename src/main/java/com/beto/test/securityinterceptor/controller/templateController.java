/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.controller;

import com.beto.test.securityinterceptor.model.dao.MenuService;
import com.beto.test.securityinterceptor.model.entity.SecPageDef;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author 912867
 */
@Controller
public class templateController extends AbstractController {

    @Autowired
    private MenuService ms;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("menu");
        model.addObject("msg", "hello world!");
        for (SecPageDef def : ms.pageList()) {
            logger.debug("PAGE : " + def.getViewId());
        }
        model.addObject("menu", ms.pageList());
        return model;
    }

}

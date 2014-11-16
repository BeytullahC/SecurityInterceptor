/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.controller;

import com.beto.test.securityinterceptor.model.dao.UserDao;
import com.beto.test.securityinterceptor.model.entity.SecUserDef;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 912867
 */
@Controller
public class CrudController {

    private static final Logger logger = Logger.getLogger(CrudController.class);

    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    private String listPersons(Model model) {
        logger.debug("listPersons method called");
        model.addAttribute("person", new SecUserDef());
        model.addAttribute("listPersons", userDao.findAll());
        return "person";
    }

    //For add and update person both
    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") SecUserDef p) {
        logger.debug("addPerson method called");
        if (p.getId() == null) {
            try {
                //new person, add it
                userDao.save(p);
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        } else {
            try {
                //existing person, call update
                userDao.update(p);
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        }

        return "redirect:/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") Long id) {
        logger.debug("removePerson method called");
        try {
            userDao.delete(userDao.find(id));
            return "redirect:/persons";
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, Model model) {
        logger.debug("editPerson method called");
        model.addAttribute("person", userDao.find(id));
        model.addAttribute("listPersons", userDao.findAll());
        model.addAttribute("modalOpen", "true");
        return "person";
    }
}

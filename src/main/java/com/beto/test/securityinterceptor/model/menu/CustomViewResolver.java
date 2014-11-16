/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.menu;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Component;

/**
 *
 * @author 912867
 */
@Component
public class CustomViewResolver implements ViewPreparer {
   private static final Logger logger= Logger.getLogger(CustomViewResolver.class);
    @Override
    public void execute(Request arg0, AttributeContext arg1) {
        logger.debug("execute method called...");
        List<org.apache.tiles.beans.MenuItem> menus = new ArrayList<>();
        menus.add(new MenuItem("ADMIN", "/admin", null, "ADMIN"));
        menus.add(new MenuItem("TEMPLATE", "/template", null, "temp"));
        arg1.putAttribute("menu", new Attribute(menus));
    }

}

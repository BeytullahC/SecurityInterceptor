/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.security;

import org.apache.log4j.Logger;

/**
 *
 * @author Belgelerim
 */

public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    private static final Logger logger = Logger.getLogger(PasswordEncoder.class);


    @Override
    public String encode(CharSequence rawPassword) {        
        logger.debug("RAW PASS :"+rawPassword.length());
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        logger.debug(rawPassword.toString()+"=="+encodedPassword);
        return  (encodedPassword == null ? encodedPassword == null : encodedPassword.equals(encode(rawPassword)));
    }

}

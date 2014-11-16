/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.menu;

import java.io.Serializable;

/**
 *
 * @author 912867
 */
public class MenuItem implements org.apache.tiles.beans.MenuItem, Serializable {

    private static final long serialVersionUID = 1L;

    private String value;

    private String link;
    private String icon;
    private String tooltip;

    public MenuItem(String value, String link, String icon, String tooltip) {
        this.value = value;
        this.link = link;
        this.icon = icon;
        this.tooltip = tooltip;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public String getTooltip() {
        return tooltip;
    }
}

package com.beto.test.securityinterceptor.security;

import com.beto.test.securityinterceptor.model.dao.RoleDAO;
import com.beto.test.securityinterceptor.model.domain.SingletonPageRole;
import com.beto.test.securityinterceptor.model.entity.SecPageRoleDef;
import com.beto.test.securityinterceptor.model.entity.SecRoleDef;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Belgelerim
 */
@Service
public class CustomFilterInvocationSecurityMetadataSource extends
		DefaultFilterInvocationSecurityMetadataSource {

	private static final Logger LOOGER = Logger
			.getLogger(CustomFilterInvocationSecurityMetadataSource.class);

	@Autowired
	private UserPageRoleService urlRepository;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private SingletonPageRole sbean;

	private List<SecPageRoleDef> liste = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CustomFilterInvocationSecurityMetadataSource() {
		super(new java.util.LinkedHashMap());
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) {
		LOOGER.debug("CustomFilterInvocationSecurityMetadataSource.getAttributes() method called...");
		FilterInvocation fi = (FilterInvocation) object;

		String url = fi.getRequestUrl();

		String urlPropsValue = null;

		if (url.contains(".jsf")) {
			int lastSlashIndex = url.lastIndexOf(".jsf");
			url = url.substring(0, lastSlashIndex);
		}

		if (!StringUtils.isEmpty(url)
				&& (url.startsWith("/css/") || url.startsWith("/img/")
						|| url.startsWith("/assets/") || url.startsWith("/js/") || url
							.startsWith("/resources/"))) {
			return null;
		}

		urlPropsValue = getRole(url);

		String attr = "";
		if (urlPropsValue != null) {
			attr = addAttr(urlPropsValue, attr);
		}

		if (!url.endsWith("/")) {
			int lastSlashIndex = url.lastIndexOf("/");
			url = url.substring(0, lastSlashIndex + 1);
		}

		/**
		 * DoÄŸrudan url'e atanmÄ±ÅŸ bir role tanÄ±mÄ± yoksa dizin role
		 * atamalarÄ± var mÄ± diye kontrol et
		 */
		if (attr == null || attr.equals("")) {
			attr = getUrlHigherDirectoryRoles(url, attr, urlPropsValue);
		}

		LOOGER.debug("getAttributes [Tespit Edilen Roller : " + attr + "]");

		if (attr.length() == 0) {
			// throw new
			// org.springframework.security.access.AccessDeniedException("EriÅŸim HatasÄ±");
			return null;
		}
		return SecurityConfig.createListFromCommaDelimitedString(attr);
	}

	private String addAttr(String role, String attr) {
		LOOGER.debug("CustomFilterInvocationSecurityMetadataSource.addAttr() method called...");
		if (attr != null) {
			String[] arr = attr.split(",");
			boolean contain = false;
			for (String e : arr) {
				if (e.equals(role)) {
					contain = true;
				}
			}
			if (!contain) {
				attr += (attr != null && !attr.equals("") ? "," : "") + role;
			}
		} else {
			attr = role;
		}
		return attr;
	}

	private List<SecPageRoleDef> getPattern(String url) throws Exception {
		LOOGER.debug("CustomFilterInvocationSecurityMetadataSource.getPattern() method called...");
		/*
		 * URL bilgisi Ã¶ncelikle SecureSingletonBean iÃ§erisindeki permission
		 * mapinde aranÄ±r. Bu sayede sorgulama konusunda hÄ±z kanÄ±lmÄ±ÅŸ olur.
		 */
		liste = sbean.getPermissions(url);

		if (liste == null) {
			liste = urlRepository.findUrlByUrl(url);
			if (liste == null) {
				liste = new ArrayList<SecPageRoleDef>();
			}
			sbean.addPermissions(url, liste);
		}

		List<SecPageRoleDef> uliste = new ArrayList<>();

		for (SecPageRoleDef p : liste) { // .replaceAll(">", "/")
			if ((p.getViewId().getViewId()).equals(url)) {
				uliste.add(p);
			}
		}

		return uliste;
	}

	private String getRole(String url) {
		try {
			LOOGER.debug("getRole [url : " + url + "]");

			List<SecPageRoleDef> uliste = getPattern(url);
			String roles = null;
			for (SecPageRoleDef p : uliste) {
				SecRoleDef role = p.getRole();
				if (role != null) {
					logger.debug("\n\nADD ROLE" + role.getRole() + "");
					roles = addAttr(role.getRole(), roles);
				}
			}

			LOOGER.debug("getRole [roles : " + roles + "]");

			return roles;
		} catch (Exception e) {
			LOOGER.error(e.getMessage(), e);
		}
		return null;
	}

	private String getUrlHigherDirectoryRoles(String url, String attr,
			String urlPropsValue) {
		LOOGER.debug("CustomFilterInvocationSecurityMetadataSource.getUrlHigherDirectoryRoles() method called...");
		try {
			String[] urlParts = url.split("/");

			StringBuilder urlBuilder = new StringBuilder();
			for (String urlPart : urlParts) {
				if (urlPart.trim().length() == 0) {
					continue;
				}
				urlBuilder.append("/").append(urlPart);
				urlPropsValue = getRole(urlBuilder.toString() + "/**");

				if (urlPropsValue != null) {
					/**
					 * Yeni bir role tespit edilmiÅŸ ise diÄŸer tespit edilen
					 * rolleri sil
					 */
					attr = "";
					attr = addAttr(urlPropsValue, attr);
				}
			}
			return attr;
		} catch (Exception e) {
			LOOGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	public void setUrlRepository(UserPageRoleService urlRepository) {
		this.urlRepository = urlRepository;
	}

	public UserPageRoleService getUrlRepository() {
		return urlRepository;
	}

	public void setSbean(SingletonPageRole sbean) {
		this.sbean = sbean;
	}

	public SingletonPageRole getSbean() {
		return sbean;
	}

}

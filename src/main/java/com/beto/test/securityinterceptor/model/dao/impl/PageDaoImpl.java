/*
 * Copyright 2014 912867.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.beto.test.securityinterceptor.model.dao.impl;

import com.beto.test.securityinterceptor.model.dao.PageDao;
import com.beto.test.securityinterceptor.model.entity.SecPageDef;
import com.beto.test.securityinterceptor.model.dao.generic.AbstractDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PageDaoImpl extends AbstractDao<SecPageDef> implements PageDao {

    @PersistenceContext(unitName = "SPRING_TESTER")
    private EntityManager em;

    public PageDaoImpl() {
        super(SecPageDef.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

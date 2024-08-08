package com.beko.dao;

import com.beko.entity.Company;
import org.hibernate.SessionFactory;

public class CompanyDao extends DaoBase<Integer, Company> {
    public CompanyDao(SessionFactory sessionFactory) {
        super(Company.class, sessionFactory);
    }
}

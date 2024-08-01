package com.beko;

import com.beko.entity.Company;
import com.beko.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class HibernateRunnerTest {
    @Test
    public void containerTest() {
        try (var sessionFactory = HibernateTestUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var company = Company.builder()
                    .name("Google")
                    .build();

            session.save(company);

            session.getTransaction().commit();
        }
    }
}

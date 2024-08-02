package com.beko;

import com.beko.entity.*;
import com.beko.util.HibernateTestUtil;
import org.junit.jupiter.api.Test;

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

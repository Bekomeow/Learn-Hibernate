package com.beko;

import com.beko.entity.*;
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

    @Test
    public void inheritanceTest() {
        try (var sessionFactory = HibernateTestUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var google = Company.builder()
                    .name("Google")
                    .build();
            session.save(google);

            var programmer = Programmer.builder()
                    .username("Beko@gmail.com")
                    .language(Language.JAVA)
                    .company(google)
                    .build();
            session.save(programmer);

            var manager = Manager.builder()
                    .username("Akaru@gmail.com")
                    .projectName("starter")
                    .company(google)
                    .build();
            session.save(manager);

            session.flush();

            session.clear();

            var programmer1 = session.get(Programmer.class, 1L);
            var manager1 = session.get(User.class, 2L);
            System.out.println();

            session.getTransaction().commit();
        }
    }
}

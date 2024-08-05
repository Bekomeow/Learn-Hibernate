package com.beko;

import com.beko.entity.User;
import com.beko.util.DataImporter;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session1 = sessionFactory.openSession()) {
                session1.beginTransaction();
                session1.enableFetchProfile("withCompanyAndPayment");

                var user = session1.get(User.class, 1L);
                System.out.println(user.getCompany().getName());

                session1.getTransaction().commit();
            }
        }
    }
}


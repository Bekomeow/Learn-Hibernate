package com.beko;

import com.beko.entity.Payment;
import com.beko.util.DataImporter;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.LockModeType;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session1 = sessionFactory.openSession()) {
                DataImporter.importData(sessionFactory);
                session1.beginTransaction();

                session1.getTransaction().commit();
            }
        }
    }
}


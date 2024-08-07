package com.beko;

import com.beko.entity.Payment;
import com.beko.entity.User;
import com.beko.util.DataImporter;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.LockModeType;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            User user = null;
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();

                user = session.find(User.class, 1L);
                user.getCompany().getName();
                user.getUserChats().size();
                var user1 = session.find(User.class, 1L);

                session.getTransaction().commit();
            }

            System.out.println("NEXT SESSION");

            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();

                var user2 = session.find(User.class, 1L);
                user2.getCompany().getName();
                user2.getUserChats().size();

                session.getTransaction().commit();
            }
        }
    }
}


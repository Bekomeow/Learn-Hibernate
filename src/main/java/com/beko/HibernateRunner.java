package com.beko;

import com.beko.entity.Birthday;
import com.beko.entity.PersonalInfo;
import com.beko.entity.User;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        User user = User.builder()
                .username("TestMail3mail.ru")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Beko")
                        .lastname("Toktamyssov")
                        .birthDate(new Birthday(LocalDate.of(2005, 6, 14)))
                        .build())
                .build();

        log.info("User entity is in transient state, object {}", user);

        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session1 = sessionFactory.openSession();
            try (session1) {
                var transaction = session1.beginTransaction();

                session1.saveOrUpdate(user);

                log.trace("User is in persistent state: user {}, session {}", user, session1);

                session1.getTransaction().commit();
            }
            log.warn("User is in detached state: user {}, session is closed {}", user, session1);
            try (var session2 = sessionFactory.openSession()) {
                var key = PersonalInfo.builder()
                        .firstname("Beko")
                        .lastname("Toktamyssov")
                        .birthDate(new Birthday(LocalDate.of(2005, 6, 14)))
                        .build();

                var user1 = session2.get(User.class, key);

                System.out.println(user1);
            }
        } catch (Exception exception) {
            log.error("Exception occurred", exception);
            throw exception;
        }
    }
}


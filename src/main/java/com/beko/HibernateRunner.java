package com.beko;

import com.beko.entity.PersonalInfo;
import com.beko.entity.User;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        User user = User.builder()
                .username("TestMail1@mail.ru")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Beko")
                        .lastname("Toktamyssov")
                        .build())
                .build();

        log.info("User entity is in transient state, object {}", user);

        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.openSession();
            try (session) {
                var transaction = session.beginTransaction();

                session.save(user);

                log.trace("User is in persistent state: user {}, session {}", user, session);

                session.getTransaction().commit();
            }
            log.warn("User is in detached state: user {}, session is closed {}", user, session);
        } catch (Exception exception) {
            log.error("Exception occurred", exception);
            throw exception;
        }
    }
}
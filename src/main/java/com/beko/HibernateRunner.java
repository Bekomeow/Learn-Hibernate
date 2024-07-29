package com.beko;

import com.beko.entity.User;
import com.beko.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateRunner {
    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);
    public static void main(String[] args) {
        User user = User.builder()
                .username("TestMail@mail.ru")
                .firstname("Beko")
                .lastname("Toktamyssov")
                .build();

        log.info("User entity is in transient state, object {}", user);

        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.openSession();
            try (session) {
                var transaction = session.getTransaction();

                log.trace("User is in persistent state: user {}, session {}", user, session);
            }
            log.warn("User is in detached state: user {}, session is closed {}", user, session);
        } catch (Exception exception) {
            log.error("Exception occurred", exception);
            throw exception;
        }
    }
}
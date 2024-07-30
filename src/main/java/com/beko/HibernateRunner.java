package com.beko;

import com.beko.entity.Birthday;
import com.beko.entity.Company;
import com.beko.entity.PersonalInfo;
import com.beko.entity.User;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        var company = Company.builder()
                .name("Google")
                .build();

        User user = User.builder()
                .username("TestMail3mail.ru")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Beko")
                        .lastname("Toktamyssov")
                        .birthDate(new Birthday(LocalDate.of(2005, 6, 14)))
                        .build())
                .company(company)
                .build();

        log.info("User entity is in transient state, object {}", user);

        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session1 = sessionFactory.openSession()) {
                var transaction = session1.beginTransaction();

                session1.saveOrUpdate(company);
                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            }
        }
    }
}


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
                .name("Yandex")
                .build();

        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session1 = sessionFactory.openSession()) {
                var transaction = session1.beginTransaction();

                var user = session1.get(User.class, 1L);
                System.out.println();
            }
        }
    }
}


package com.beko;

import com.beko.entity.Payment;
import com.beko.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.LockModeType;

@Slf4j
public class HibernateRunner {
//    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class); -> @Slf4j
    public static void main(String[] args) {
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session1 = sessionFactory.openSession();
                 var session2 = sessionFactory.openSession()) {
                session1.beginTransaction();
                session2.beginTransaction();

                var payment = session1.find(Payment.class, 1L, LockModeType.OPTIMISTIC);
                payment.setAmount(payment.getAmount() + 10);

                var theSamePayment = session2.find(Payment.class, 1L, LockModeType.OPTIMISTIC);
                theSamePayment.setAmount(payment.getAmount() + 20);

                session1.getTransaction().commit();
                session2.getTransaction().commit();
            }
        }
    }
}


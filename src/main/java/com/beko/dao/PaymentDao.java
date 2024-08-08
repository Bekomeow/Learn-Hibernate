package com.beko.dao;

import com.beko.entity.Payment;
import org.hibernate.SessionFactory;

public class PaymentDao extends DaoBase<Long, Payment> {
    public PaymentDao(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}

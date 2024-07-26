package com.beko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRunner {
    public static void main(String[] args) {
        // Создаем конфигурацию Hibernate
        var configuration = new Configuration();
        // Загружаем настройки из файла hibernate.cfg.xml
        configuration.configure();

        // Создаем фабрику сессий
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            // Открываем сессию и проверяем соединение
            System.out.println("OK");
        }
    }
}
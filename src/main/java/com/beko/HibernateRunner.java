package com.beko;

import com.beko.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        // Создаем конфигурацию Hibernate
        var configuration = new Configuration();

        // Добавляем сущность в SessionFactory,
        // Можно также добавить в hibernate.cfg.xml
        configuration.addAnnotatedClass(User.class);

        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());

        // Загружаем настройки из файла hibernate.cfg.xml
        configuration.configure();

        // Создаем фабрику сессий
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            // Открываем сессию и проверяем соединение

            session.beginTransaction();

            User user = User.builder()
                    .username("gabitcool31@gmail.com")
                    .firstname("Beko")
                    .lastname("Toktamyssov")
                    .birthDate(LocalDate.of(2005, 6, 14))
                    .age(19)
                    .build();

            session.save(user);

            session.getTransaction().commit();

        }
    }
}
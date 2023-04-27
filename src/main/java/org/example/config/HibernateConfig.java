package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateConfig {

    public static EntityManager getEntityManager() {
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        configuration.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(Environment.USER, "postgres");
        configuration.setProperty(Environment.PASS, "postgres");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Reader.class);
        return configuration.buildSessionFactory().createEntityManager();
    }
}

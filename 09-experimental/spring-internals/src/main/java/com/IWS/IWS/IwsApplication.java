package com.IWS.IWS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IwsApplication {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(101);
        s1.setName("gotam");
        s1.setStudentClass("cse-2");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = meta.getSessionFactoryBuilder().build();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        session.save(s1);
        t.commit();

        sf.close();
        session.close();

    }

}

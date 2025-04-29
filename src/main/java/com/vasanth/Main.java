package com.vasanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

//        Student s1 = new Student();
//        s1.setRollNo(107);
//        s1.setsName("hmmm");
//        s1.setsAge(20);

public class Main {
    public static void main(String[] args) {

        Address a1 = new Address();
        a1.setAid(1);
        a1.setNum(100);
        a1.setStreet("Nemilicherry");
        a1.setArea("Chromepet");

        Address a2 = new Address();
        a2.setAid(2);
        a2.setNum(19);
        a2.setStreet("Mainroad");
        a2.setArea("Chromepet");

        Address a3 = new Address();
        a3.setAid(3);
        a3.setNum(69);
        a3.setStreet("dasanroad");
        a3.setArea("Chitlapakkam");

        Player p1 = new Player();
        p1.setPid(101);
        p1.setPname("vas");
        p1.setPosition("forward");

        Player p2 = new Player();
        p2.setPid(102);
        p2.setPname("pras");
        p2.setPosition("winger");

        Player p3 = new Player();
        p3.setPid(103);
        p3.setPname("ram");
        p3.setPosition("defender");

        p1.setAddresses(Arrays.asList(a1,a2));
        p2.setAddresses(Arrays.asList(a2,a3));
        p3.setAddresses(Arrays.asList(a1));

        a1.setPlayers(Arrays.asList(p1,p3));
        a2.setPlayers(Arrays.asList(p1,p2));
        a3.setPlayers(Arrays.asList(p2));

//  for onetomany and manytoone
//        p1.setAddresses(Arrays.asList(a1,a2));
//
//        a1.setPlayer(p1);
//        a2.setPlayer(p1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.vasanth.Player.class)
                .addAnnotatedClass(com.vasanth.Address.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        //saving address first because address is priamry table now
//for onetomany and manytomany
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(p1);

        //for manytomany
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        session.persist(p1);
        session.persist(p2);
        session.persist(p3);


        transaction.commit();

        Player p5 = session.get(Player.class,101);
        System.out.println(p5);

        session.close();
        sf.close();

    }
}
package demo;

import domain.Customer;
import domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveDetailstoExisting {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Customer.class);
        cfg = cfg.addAnnotatedClass(Order.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //loading existing customer to place new order
        Customer c1 = ses.load(Customer.class, 1);

        Order ord1 = new Order();
        ord1.setOrderNo("ORD1009");

        Order ord2 = new Order();
        ord2.setOrderNo("ORD1010");

        c1.addOrder(ord1);
        c1.addOrder(ord2);

        tx = ses.beginTransaction();

        ses.save(ord1);
        ses.save(ord2);

        tx.commit();

        System.out.println("DETAILS INSERTED SUCCESSFULLY");

    }
}

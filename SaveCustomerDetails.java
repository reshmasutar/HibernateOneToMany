package demo;

import domain.Customer;
import domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCustomerDetails {
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

        //object of customer
        Customer c1 = new Customer();
        c1.setName("Reshma");
        c1.setEmail("reshma@gmail.com");

        //object of order class
        Order ord1 = new Order();
        ord1.setOrderNo("ORD1001");

        Order ord2 = new Order();
        ord2.setOrderNo("ORD1002");

        //add orders to customer list
        c1.addOrder(ord1);
        c1.addOrder(ord2);

        tx = ses.beginTransaction();
        ses.save(c1);
        ses.save(ord1);
        ses.save(ord2);
        tx.commit();

        System.out.println("DETAILS INSERTED SUCCESSFULLY");
    }
}

package demo;

import domain.Customer;
import domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveMultipleDetails {

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
            c1.setName("Payal");
            c1.setEmail("payal@gmail.com");

            Customer c2 = new Customer();
            c1.setName("Asha");
            c1.setEmail("asha@gmail.com");

            //object of order class
            Order ord1 = new Order();
            ord1.setOrderNo("ORD1003");

            Order ord2 = new Order();
            ord2.setOrderNo("ORD1004");

            Order ord3 = new Order();
            ord3.setOrderNo("ORD1005");

            //add orders to customer list
            c1.addOrder(ord1);
            c1.addOrder(ord2);
            c2.addOrder(ord3);

            tx = ses.beginTransaction();
            ses.save(c1);
            ses.save(c2);
            ses.save(ord1);
            ses.save(ord2);
            ses.save(ord3);

            tx.commit();

            System.out.println("DETAILS INSERTED SUCCESSFULLY");
        }
    }



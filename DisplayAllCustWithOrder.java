package demo;

import domain.Customer;
import domain.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllCustWithOrder {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg.addAnnotatedClass(Customer.class);
        cfg.addAnnotatedClass(Order.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt = ses.createCriteria(Customer.class);
        List<Customer> c1 = crt.list();
        for(Customer c : c1){
            System.out.println(c.getName());
            List<Order> c2 = c.getOrderList();
            for (Order o:c2) {
                System.out.println(o.getOrderNo());
            }
        }
        System.out.println("===================================================================");

        }
    }


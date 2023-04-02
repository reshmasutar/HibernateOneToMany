package demo;

import domain.Customer;
import domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayOrderById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id: ");
        int id = sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Customer.class);
        cfg = cfg.addAnnotatedClass(Order.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Customer c1 = ses.load(Customer.class, id);
        System.out.println("Name: "+c1.getName());
        List<Order> orderList = c1.getOrderList();
        for (Order o:orderList) {
            System.out.println(o.getOrderNo());
        }

    }
}

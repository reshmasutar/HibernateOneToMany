package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer_info")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private int cid;
        @Column(name = "customer_name")
        private  String name;
        @Column(name = "customer_email")
        private String email;

        @OneToMany(mappedBy = "customerRef", cascade = CascadeType.ALL)
        private List<Order> orderList;

        public int getCid() {
            return cid;
        }
        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public List<Order> getOrderList() {
            return orderList;
        }
        public void setOrderList(List<Order> orderList) {
            this.orderList = orderList;
        }

    @Override
    public String toString() {
        return name;
    }

    public void addOrder(Order ordRef){
            if (orderList == null){
                orderList = new LinkedList<>();
            }
            orderList.add(ordRef);
            ordRef.setCustomerRef(this);


        }
    }


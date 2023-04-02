package domain;

import javax.persistence.*;

@Entity
@Table(name = "order_info")
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "order_id")
        private int Id;
        @Column(name = "order_no")
        private String orderNo;
        @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
        @JoinColumn(name = "customer_ref")
        private Customer customerRef;

        public int getId() {
         return Id;
        }
        public void setId(int id) {
            Id = id;
        }

        public String getOrderNo() {
            return orderNo;
        }
        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public Customer getCustomerRef() {
            return customerRef;
        }
        public void setCustomerRef(Customer customerRef) {
            this.customerRef = customerRef;
        }

    @Override
    public String toString() {
        return orderNo;
    }
}




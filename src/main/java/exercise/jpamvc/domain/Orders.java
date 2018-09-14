package exercise.jpamvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name="ordernumber", nullable=false)
    private String ordernumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "orderDate", unique = true, nullable = false, length = 10)
    private Date orderDate;

    @OneToOne
    @JoinColumn(name = "shippingAddress")
    private Address shippingAddress;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "orderLineItem_id")
    private OrderLineItem orderLineItems;

    @Column(name="totalPrice", nullable=false)
    Double totalPrice;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOrderNumber() {
        return ordernumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.ordernumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderLineItem getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(OrderLineItem orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Orders(Long id, Account account, String orderNumber, Date orderDate, Address shippingAddress, OrderLineItem orderLineItem, Double totalPrice){
        this.id = id;
        this.account = account;
        this.ordernumber = orderNumber;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderLineItems = orderLineItem;
        this.totalPrice = totalPrice;
    }

    public Orders(){}

}

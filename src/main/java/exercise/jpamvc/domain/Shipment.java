package exercise.jpamvc.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "shippingAddress")
    private Address shippingAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
    private Set<OrderLineItem> orderLineItems = new HashSet<OrderLineItem>();

    @Temporal(TemporalType.DATE)
    @Column(name = "shippedDate", unique = true, nullable = false, length = 10)
    private Date shippedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "deliveryDate", unique = true, nullable = false, length = 10)
    private Date deliveryDate;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Shipment(long id, Account account, Address shippingAddress, Set<OrderLineItem> orderLineItems, Date shippedDate, Date deliveryDate){
        this.id = id;
        this.account = account;
        this.shippingAddress = shippingAddress;
        this.orderLineItems = orderLineItems;
        this.shippedDate = shippedDate;
        this.deliveryDate = deliveryDate;
    }

    public Shipment(){}
}

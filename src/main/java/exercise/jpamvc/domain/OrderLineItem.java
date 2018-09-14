package exercise.jpamvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product")
    private Product product;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name="price", nullable=false)
    Double price;

    @Column(name="totalPrice", nullable=false)
    Double totalPrice;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "shipment")
    private Shipment shipment;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = price * quantity;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public OrderLineItem(Long id, Product product, int quantity, Double price, Shipment shipment){
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        setTotalPrice();
        this.shipment = shipment;
    }

    public  OrderLineItem(){}
}

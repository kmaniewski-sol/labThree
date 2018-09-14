package exercise.jpamvc.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class OrderDetailsQuery {
    public final String orderNumber;
    public final String address;
    public final Double totalPrice;
    public final String lineItem;
    public final Long orderLineItems;


    @JsonCreator
    public OrderDetailsQuery(@JsonProperty("orderNumber") String orderNumber, @JsonProperty("adsress") String address,
                             @JsonProperty("totalPrice") Double totalPrice, @JsonProperty("lineItem") String lineItem,
                             @JsonProperty("orderLineItems") Long orderLineItems){
        this.orderNumber = orderNumber;
        this.address = address;
        this.totalPrice = totalPrice;
        this.lineItem = lineItem;
        this.orderLineItems = orderLineItems;
    }
}

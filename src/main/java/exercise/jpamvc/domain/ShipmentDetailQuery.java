package exercise.jpamvc.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ShipmentDetailQuery {
    public final String orderNumber;
    public final Date shippingDate;
    public final Date deliveryDate;
    public final String productName;
    public final int quantity;

    @JsonCreator
    public ShipmentDetailQuery(@JsonProperty("orderNumber") String orderNumber, @JsonProperty("shippingDate") Date shippingDate,
                             @JsonProperty("deliveryDate") Date deliveryDate, @JsonProperty("productName") String productName,
                               @JsonProperty("quantity") int quantity) {
        this.orderNumber = orderNumber;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.productName = productName;
        this.quantity = quantity;
    }
}

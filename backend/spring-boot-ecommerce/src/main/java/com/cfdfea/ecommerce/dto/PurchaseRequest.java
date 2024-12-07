package com.cfdfea.ecommerce.dto;

import com.cfdfea.ecommerce.entity.Address;
import com.cfdfea.ecommerce.entity.Customer;
import com.cfdfea.ecommerce.entity.Order;
import com.cfdfea.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;
// Purchase request
@Data
public class PurchaseRequest {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}

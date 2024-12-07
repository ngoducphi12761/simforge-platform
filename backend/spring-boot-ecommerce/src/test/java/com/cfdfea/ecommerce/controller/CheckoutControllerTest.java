package com.cfdfea.ecommerce.controller;

import com.cfdfea.ecommerce.dto.PurchaseRequest;
import com.cfdfea.ecommerce.dto.PurchaseResponse;
import com.cfdfea.ecommerce.entity.Address;
import com.cfdfea.ecommerce.entity.Customer;
import com.cfdfea.ecommerce.entity.Order;
import com.cfdfea.ecommerce.entity.OrderItem;
import com.cfdfea.ecommerce.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CheckoutControllerTest {

    @Mock
    private CheckoutService checkoutService;
    @InjectMocks
    private CheckoutController checkoutController;

    @Test
    void testCheckoutController() {
        // Arrange
        PurchaseRequest purchaseRequest = new PurchaseRequest();

        Address shippingAddress = new Address();
        shippingAddress.setStreet("123 Main St");
        shippingAddress.setCity("Springfield");
        shippingAddress.setState("IL");
        shippingAddress.setCountry("USA");
        shippingAddress.setZipCode("62704");

        Address billingAddress = new Address();
        billingAddress.setStreet("123 Main St");
        billingAddress.setCity("Springfield");
        billingAddress.setState("IL");
        billingAddress.setCountry("USA");
        billingAddress.setZipCode("62704");

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");

        Order order = new Order();
        order.setTotalPrice(BigDecimal.valueOf(99.99));
        order.setTotalQuantity(2);

        Set<OrderItem> orderItems = new HashSet<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(1L);
        orderItem.setQuantity(2);
        orderItem.setUnitPrice(BigDecimal.valueOf(49.99));
        orderItems.add(orderItem);

        order.setOrderItems(orderItems);

        purchaseRequest.setCustomer(customer);
        purchaseRequest.setOrder(order);
        purchaseRequest.setBillingAddress(billingAddress);
        purchaseRequest.setShippingAddress(shippingAddress);
        purchaseRequest.setOrderItems(orderItems);

        String trackingNumber = "test-tracking-number";
        PurchaseResponse purchaseResponse = new PurchaseResponse(trackingNumber);

        Mockito.when(checkoutService.placeOrder(any(PurchaseRequest.class))).thenReturn(purchaseResponse);

        // Act
        PurchaseResponse response = checkoutController.placeOrder(purchaseRequest).getBody();

        // Assert
        assertEquals(trackingNumber, response.getOrderTrackingNumber());
        assertEquals(purchaseResponse, response);

    }
}

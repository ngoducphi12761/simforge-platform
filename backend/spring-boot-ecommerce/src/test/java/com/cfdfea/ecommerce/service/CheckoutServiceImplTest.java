package com.cfdfea.ecommerce.service;

import com.cfdfea.ecommerce.dto.PurchaseRequest;
import com.cfdfea.ecommerce.dto.PurchaseResponse;
import com.cfdfea.ecommerce.entity.Address;
import com.cfdfea.ecommerce.entity.Customer;
import com.cfdfea.ecommerce.entity.Order;
import com.cfdfea.ecommerce.entity.OrderItem;
import com.cfdfea.ecommerce.repository.CustomerRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CheckoutServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CheckoutServiceImpl checkoutService;
    @Test
    void testPlaceOrder() {
        // Arrange
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

        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setCustomer(customer);
        purchaseRequest.setOrder(order);
        purchaseRequest.setBillingAddress(billingAddress);
        purchaseRequest.setShippingAddress(shippingAddress);
        purchaseRequest.setOrderItems(orderItems);

        // Mock behavior
        when(customerRepository.findByEmail("john.doe@example.com")).thenReturn(null); // Simulate no existing customer
        when(customerRepository.save(Mockito.any(Customer.class))).thenAnswer(invocation -> {
            Customer savedCustomer = invocation.getArgument(0);
            // Simulate adding an order to the customer
            Order savedOrder = savedCustomer.getOrders().iterator().next();
            savedOrder.setOrderTrackingNumber("TRACK1234"); // Simulate generated tracking number
            return savedCustomer;
        });

        // Act
        PurchaseResponse response = checkoutService.placeOrder(purchaseRequest);
        System.out.println("testing ===="+response);
        // Assert
        assertNotNull(response);
        assertEquals("TRACK1234", response.getOrderTrackingNumber());

        // Verify customer and order relationships
        Mockito.verify(customerRepository).findByEmail("john.doe@example.com");
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));

        // Ensure the saved order matches the request
        assertEquals(1, customer.getOrders().size());
        Order savedOrder = customer.getOrders().iterator().next();
        assertEquals(order.getTotalPrice(), savedOrder.getTotalPrice());
        assertEquals(orderItems.size(), savedOrder.getOrderItems().size());

    }

    @Test
    void testPlaceOrderForExistingCustomer() {
        // Arrange
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

        Customer existingCustomer = new Customer();
        existingCustomer.setId(1L); // Simulate an existing customer in the database
        existingCustomer.setFirstName("John");
        existingCustomer.setLastName("Doe");
        existingCustomer.setEmail("john.doe@example.com");

        Order order = new Order();
        order.setTotalPrice(BigDecimal.valueOf(199.99));
        order.setTotalQuantity(3);

        Set<OrderItem> orderItems = new HashSet<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(1L);
        orderItem.setQuantity(3);
        orderItem.setUnitPrice(BigDecimal.valueOf(66.66));
        orderItems.add(orderItem);

        order.setOrderItems(orderItems);

        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setCustomer(existingCustomer);
        purchaseRequest.setOrder(order);
        purchaseRequest.setBillingAddress(billingAddress);
        purchaseRequest.setShippingAddress(shippingAddress);
        purchaseRequest.setOrderItems(orderItems);

        // Mock behavior for existing customer
        when(customerRepository.findByEmail("john.doe@example.com")).thenReturn(existingCustomer);
        when(customerRepository.save(Mockito.any(Customer.class))).thenAnswer(invocation -> {
            Customer savedCustomer = invocation.getArgument(0);
            // Simulate order processing
            Order savedOrder = savedCustomer.getOrders().iterator().next();
            savedOrder.setOrderTrackingNumber("TRACK5678"); // Simulate generated tracking number
            return savedCustomer;
        });

        // Act
        PurchaseResponse response = checkoutService.placeOrder(purchaseRequest);

        // Assert
        assertNotNull(response);
        assertEquals("TRACK5678", response.getOrderTrackingNumber());

        // Verify customer and order relationships
        Mockito.verify(customerRepository).findByEmail("john.doe@example.com");
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));

        // Ensure the saved order matches the request
        assertEquals(1, existingCustomer.getOrders().size());
        Order savedOrder = existingCustomer.getOrders().iterator().next();
        assertEquals(order.getTotalPrice(), savedOrder.getTotalPrice());
        assertEquals(orderItems.size(), savedOrder.getOrderItems().size());
    }
}
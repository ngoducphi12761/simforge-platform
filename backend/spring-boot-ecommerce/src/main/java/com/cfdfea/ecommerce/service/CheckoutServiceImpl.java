package com.cfdfea.ecommerce.service;

import com.cfdfea.ecommerce.repository.CustomerRepository;
import com.cfdfea.ecommerce.dto.PurchaseRequest;
import com.cfdfea.ecommerce.dto.PurchaseResponse;
import com.cfdfea.ecommerce.entity.Customer;
import com.cfdfea.ecommerce.entity.Order;
import com.cfdfea.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseRequest purchaseRequest) {

        // retrieve the order info from dto
        Order order = purchaseRequest.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchaseRequest.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchaseRequest.getBillingAddress());
        order.setShippingAddress(purchaseRequest.getShippingAddress());

        // populate customer with order
        Customer customer = purchaseRequest.getCustomer();

        // check if this is an existing customer
        String theEmail = customer.getEmail();

        Customer customerFromDB = customerRepository.findByEmail(theEmail);

        if (customerFromDB != null) {
            // we found them ... let's assign them accordingly
            customer = customerFromDB;
        }

        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(order.getOrderTrackingNumber());
    }

    public String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}
package com.cfdfea.ecommerce.service;

import com.cfdfea.ecommerce.dto.PurchaseRequest;
import com.cfdfea.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(PurchaseRequest purchaseRequest);
}

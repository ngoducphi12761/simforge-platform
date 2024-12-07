package com.cfdfea.ecommerce.controller;

import com.cfdfea.ecommerce.dto.PurchaseRequest;
import com.cfdfea.ecommerce.dto.PurchaseResponse;
import com.cfdfea.ecommerce.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    final private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody PurchaseRequest purchaseRequest) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchaseRequest);
        return    ResponseEntity.status(HttpStatus.CREATED).body(purchaseResponse);

    }

}










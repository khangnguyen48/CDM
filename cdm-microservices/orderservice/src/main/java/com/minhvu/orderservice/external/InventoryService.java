package com.minhvu.orderservice.external;

import com.minhvu.orderservice.exception.CustomException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE/inventory")
public interface InventoryService {

    @PutMapping("/reduceQuantity/{id}")
    ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    );

//    default ResponseEntity<Void> fallback(Exception e) {
//        throw new CustomException("Product Service is not available",
//                "UNAVAILABLE",
//                500);
//    }
}

package com.devsuperior.dsdeliver.controllers;

import com.devsuperior.dsdeliver.DTO.OrderDTO;
import com.devsuperior.dsdeliver.DTO.ProductDTO;
import com.devsuperior.dsdeliver.services.OrderService;
import com.devsuperior.dsdeliver.services.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService service;

  @GetMapping
  public ResponseEntity<List<OrderDTO>> findAll(){
    List<OrderDTO> orders = service.findAll();
    return ResponseEntity.ok().body(orders);
  }
}

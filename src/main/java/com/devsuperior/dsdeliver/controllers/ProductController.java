package com.devsuperior.dsdeliver.controllers;

import com.devsuperior.dsdeliver.DTO.ProductDTO;
import com.devsuperior.dsdeliver.services.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/products")
@AllArgsConstructor
public class ProductController {

  private ProductService service;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> findAll(){
    List<ProductDTO> products = service.findAll();
    return ResponseEntity.ok().body(products);
  }
}

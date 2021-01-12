package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.DTO.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderService {

  private OrderRepository orderRepository;

  private ProductService productService;

  @Transactional(readOnly = true)
  //Por ser uma função apenas de leitura no banco, a anotação torna a busca mais rapida.
  public List<OrderDTO> findAll() {
    List<Order> orders = orderRepository.findOrdersWithProducts();
    return orders.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
  }

  @Transactional
  public OrderDTO insert(OrderDTO orderDTO){
    Order order = orderDTO.toEntity();
    order = orderRepository.save(order);
    return new OrderDTO(order);
  }

}

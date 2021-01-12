package com.devsuperior.dsdeliver.DTO;

import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {

  private Long id;
  private String address;
  private Double latitude;
  private Double longitude;
  private Instant moment;
  private OrderStatus status;

  private List<ProductDTO> products;

  public OrderDTO(Order entity) {
    id = entity.getId();
    address = entity.getAddress();
    latitude = entity.getLatitude();
    longitude = entity.getLongitude();
    moment = entity.getMoment();
    status = entity.getStatus();
    products = entity.getProducts().stream().map(product -> new ProductDTO(product)).collect(
        Collectors.toList());
  }

  public Order toEntity() {
    return Order.builder()
        .address(this.address)
        .latitude(this.latitude)
        .longitude(this.longitude)
        .moment(Instant.now())
        .status(OrderStatus.PENDING)
        .products(this.products.stream()
            .map(productDTO -> Product.builder().id(productDTO.getId()).build())
        .collect(Collectors.toSet()))
        .build();
  }
}

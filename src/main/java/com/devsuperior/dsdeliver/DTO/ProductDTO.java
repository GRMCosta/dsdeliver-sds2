package com.devsuperior.dsdeliver.DTO;

import com.devsuperior.dsdeliver.entities.Product;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

  private Long id;
  private String name;
  private Double price;
  private String description;
  private String imageUri;

  public ProductDTO(Product entity) {
    id = entity.getId();
    name = entity.getName();
    price = entity.getPrice();
    description = entity.getDescription();
    imageUri = entity.getImageUri();
  }
}

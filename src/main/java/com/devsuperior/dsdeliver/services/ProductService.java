package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.DTO.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductRepository productRepository;

  @Transactional(readOnly = true) //Por ser uma função apenas de leitura no banco, a busca é mais rapida.
  public List<ProductDTO> findAll() {
    List<Product> products = productRepository.findAllByOrderByNameAsc();
    return products.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
  }

  /*
  Essa função nao acessa realmente o banco, apenas faz uma referencia ao objeto para quando retornar
  a função save, retornar o objeto referenciado, caso queira entender melhor, faça uma chamada do endpoint
  POST /orders e veja o resultado, depois faça o mesmo na branch feature/withOutGetOne
  */
  public Product getReference(Long id) {
    return productRepository.getOne(id);
  }
}

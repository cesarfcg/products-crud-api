package br.com.cesarfcg.productscrud.Service;

import br.com.cesarfcg.productscrud.Dto.ProductRequestDTO;
import br.com.cesarfcg.productscrud.Dto.ProductResponseDTO;
import br.com.cesarfcg.productscrud.Entity.ProductEntity;
import br.com.cesarfcg.productscrud.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    public List<ProductEntity> list(){
        return productsRepository.findAll();
    }
    public ProductResponseDTO create(ProductRequestDTO dto){
        ProductEntity product = new ProductEntity();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        ProductEntity saved = productsRepository.save(product);
        return new ProductResponseDTO(saved.getName(), saved.getDescription(), saved.getPrice() );


    }
    public ProductResponseDTO update(Long id, ProductRequestDTO dto){
        ProductEntity productEntity = productsRepository.findById(id).orElseThrow();
        productEntity.setName(dto.name());
        productEntity.setDescription(dto.description());
        productEntity.setPrice(dto.price());
        ProductEntity saved = productsRepository.save(productEntity);
        return new ProductResponseDTO(saved.getName(), saved.getDescription(), saved.getPrice());
    }
    public List<ProductEntity> delete(Long id){
        productsRepository.deleteById(id);
        return list();
    }
}

package br.com.cesarfcg.productscrud.Service;

import br.com.cesarfcg.productscrud.Dto.Request.ProductRequestDTO;
import br.com.cesarfcg.productscrud.Dto.Response.ProductResponseDTO;
import br.com.cesarfcg.productscrud.Entity.ProductEntity;
import br.com.cesarfcg.productscrud.Repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    public List<ProductResponseDTO> list(){
        List<ProductEntity> products = productsRepository.findAll();
        List<ProductResponseDTO> response = new ArrayList<>();
        for (ProductEntity product : products){
            response.add(new ProductResponseDTO(product.getName(), product.getDescription(), product.getPrice()));
        }

        return response;
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
    public List<ProductResponseDTO> delete(Long id){
        productsRepository.deleteById(id);
        return list();
    }
}

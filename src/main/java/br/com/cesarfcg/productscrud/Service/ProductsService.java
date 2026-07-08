package br.com.cesarfcg.productscrud.Service;

import br.com.cesarfcg.productscrud.Entity.ProductEntity;
import br.com.cesarfcg.productscrud.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    public List<ProductEntity> list(){
        return productsRepository.findAll();
    }
    public ProductEntity create(ProductEntity product){
        return productsRepository.save(product);
    }
    public ProductEntity update(ProductEntity product){
        return productsRepository.save(product);
    }
    public List<ProductEntity> delete(Long id){
        productsRepository.deleteById(id);
        return list();
    }
}

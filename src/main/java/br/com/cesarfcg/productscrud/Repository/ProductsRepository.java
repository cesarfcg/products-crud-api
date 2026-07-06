package br.com.cesarfcg.productscrud.Repository;

import br.com.cesarfcg.productscrud.Entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
}

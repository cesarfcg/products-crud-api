package br.com.cesarfcg.productscrud.Controller;

import br.com.cesarfcg.productscrud.Dto.Request.ProductRequestDTO;
import br.com.cesarfcg.productscrud.Dto.Response.ProductResponseDTO;
import br.com.cesarfcg.productscrud.Dto.Response.RegisterResponseDTO;
import br.com.cesarfcg.productscrud.Entity.UserEntity;
import br.com.cesarfcg.productscrud.Service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/list")
    public List<ProductResponseDTO> list(){
        return productsService.list();
    }
    @PostMapping("/create")
    public ProductResponseDTO create(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        return productsService.create(productRequestDTO);
    }
    @PutMapping("/update/{id}")
    public ProductResponseDTO update(@Valid @PathVariable("id") Long id ,@RequestBody ProductRequestDTO dto){
        return productsService.update(id,dto);
    }
    @DeleteMapping("/delete/{id}")
    public List<ProductResponseDTO> delete(@PathVariable("id")Long id ){
        return productsService.delete(id);
    }

}

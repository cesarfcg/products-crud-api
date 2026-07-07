package br.com.cesarfcg.productscrud.Controller;

import br.com.cesarfcg.productscrud.Service.ProductsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {
    private ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }
}

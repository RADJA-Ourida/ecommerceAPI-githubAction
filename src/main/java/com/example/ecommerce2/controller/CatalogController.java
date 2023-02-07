package com.example.ecommerce2.controller;

import com.example.ecommerce2.model.*;
import com.example.ecommerce2.modelAPI.CatalogAPI;
import com.example.ecommerce2.modelAPI.CategoryAPI;
import com.example.ecommerce2.modelAPI.ProductAPI;
import com.example.ecommerce2.repository.CatalogRepository;
import com.example.ecommerce2.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogService catalogService;
    private final CatalogRepository catalogRepository;


    @PostMapping("/newProduct")
    public ResponseEntity<Product> createProduct(@RequestBody ProductAPI productAPI) {
        if (productAPI.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be positive !");
        }
        return new ResponseEntity<>(catalogService.createProduct(productAPI), HttpStatus.CREATED);
    }


    @PostMapping("/addProductStock/{idProduct}")
    public ResponseEntity<Stock> addProductStock(@PathVariable("idProduct") Integer idProduct, @RequestBody Integer qnt) {

        if (qnt < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        Stock stock = catalogService.addProductTOStock(idProduct, qnt);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }


    @PostMapping("/newCart")
    public ResponseEntity<Cart> createCart(@RequestBody List<Integer> idProductList) {

        return new ResponseEntity<>(catalogService.createCart(idProductList), HttpStatus.CREATED);

    }

    @PostMapping("/newCategory")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryAPI categoryAPI) {
        return new ResponseEntity<>(catalogService.createCategory(categoryAPI), HttpStatus.CREATED);
    }


    @PostMapping("/newCatalog")
    public ResponseEntity<Catalog> createCatalog(@RequestBody CatalogAPI catalogAPI) {
        return new ResponseEntity<>(catalogService.createCatalog(catalogAPI), HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> showAllCategories() {
        return new ResponseEntity<>(catalogService.showAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> showAllProducts() {
        return new ResponseEntity<>(catalogService.showAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> showAllStocks() {
        return new ResponseEntity<>(catalogService.showAllStocks(), HttpStatus.OK);
    }

    @GetMapping("/product/{idPoduct}")
    public ResponseEntity<Product> showOneProduct(@PathVariable("idPoduct") Integer idPoduct) {
        return new ResponseEntity<>(catalogService.showOneProduct(idPoduct), HttpStatus.OK);
    }

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<Category> showOneCategory(@PathVariable("idCategory") Integer idCategory) {
        return new ResponseEntity<>(catalogService.showOneCategory(idCategory), HttpStatus.OK);
    }

    @GetMapping("/cart/{idCart}")
    public ResponseEntity<Cart> showOneCart(@PathVariable("idCart") Integer idCart) {
        return new ResponseEntity<>(catalogService.showOneCart(idCart), HttpStatus.OK);
    }

    @GetMapping("/stock/{idStock}")
    public ResponseEntity<Stock> showOneStock(@PathVariable("idStock") Integer idStock) {
        return new ResponseEntity<>(catalogService.showOneStock(idStock), HttpStatus.OK);
    }


}

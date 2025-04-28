package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.handler;

import com.japs.backend.supermercado.pos.application.response.ApiResponse;
import com.japs.backend.supermercado.pos.application.services.ProductService;
import com.japs.backend.supermercado.pos.application.utils.ResponseBuilder;
import com.japs.backend.supermercado.pos.domain.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Product>> saveProduct(@Valid @RequestBody Product productRequest){
        log.info("Inicio creación de producto");
        log.info("request create cliente: {}",productRequest.toString());

        Product product = productService.save(productRequest);
        ApiResponse<Product> apiResponse = ResponseBuilder.successMessage("Producto creado exitosamente",product);

        log.info("response create producto: {}",apiResponse.toString());
        log.info("Finalizo creación de producto");

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long id, @RequestBody Product productRequest){
        log.info("Inicio actualizacion de producto: {}",id);
        log.info("request update producto: {}",productRequest.toString());

        Product product = productService.update(id,productRequest);
        ApiResponse<Product> apiResponse = ResponseBuilder.successMessage("Producto actualizado exitosamente",product);

        log.info("response update producto: {}",apiResponse.toString());
        log.info("Finalizo actualizacion de producto");

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id){
        log.info("Inicio eliminacion producto");
        log.info("request entrada id: {}",id);

        productService.delete(id);
        ApiResponse<Void> apiResponse = ResponseBuilder.successMessage("Se Elimino el producto correctamente.");

        log.info("response eliminar producto: {}",apiResponse.toString());
        log.info("Finalizo eliminacion de producto");

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/find-by-code/{code}")
    public ResponseEntity<Product> findProductByDocument(@PathVariable String code){
        log.info("Inicio busqueda de producto con codigo: {}",code);
        Product product = productService.findByCode(code);
        log.info("response busqueda producto: {}",product.toString());
        log.info("Finalizo busqueda de producto con codigo: {}",code);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/find-all")
    public ResponseEntity<ApiResponse<List<Product>>> findAllProducts(){
        log.info("Inicio busqueda de todos los productos");
        List<Product> listProducts = productService.findAll();

        ApiResponse<List<Product>> apiResponse = ResponseBuilder.successMessage("Productos encontrados exitosamente: "+
                listProducts.size(),listProducts);

        log.info("response busqueda productos: {}",apiResponse.toString());
        log.info("Finalizo busqueda de todos los productos");

        return ResponseEntity.ok(apiResponse);
    }

}

package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.handler;

import com.japs.backend.supermercado.pos.application.response.ApiResponse;
import com.japs.backend.supermercado.pos.application.services.CategoryService;
import com.japs.backend.supermercado.pos.application.utils.ResponseBuilder;
import com.japs.backend.supermercado.pos.domain.model.Category;
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
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@Valid @RequestBody Category categoryRequest){
        log.info("Inicio creación de la categoria");
        log.info("request create categoria: {}",categoryRequest.toString());

        Category category = categoryService.save(categoryRequest);
        ApiResponse<Category> apiResponse = ResponseBuilder.successMessage("Categoria creada exitosamente",category);

        log.info("response create categoria: {}",apiResponse.toString());
        log.info("Finalizo creación de la categoria");

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category categoryRequest){
        log.info("Inicio actualizacion de la categoria: {}",id);
        log.info("request update categoria: {}",categoryRequest.toString());

        Category category  = categoryService.update(id,categoryRequest);
        ApiResponse<Category> apiResponse = ResponseBuilder.successMessage("Categoria actualizada exitosamente",category);

        log.info("response update categoria: {}",apiResponse.toString());
        log.info("Finalizo actualizacion de la categoria");

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        log.info("Inicio eliminacion de la categoria");
        log.info("request entrada id: {}",id);

        categoryService.delete(id);
        ApiResponse<Void> apiResponse = ResponseBuilder.successMessage("Se Elimino la categoria correctamente.");

        log.info("response eliminar categoria: {}",apiResponse.toString());
        log.info("Finalizo eliminacion de la categoria");

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
       return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping("/find-by-document/{name}")
    public ResponseEntity<Category> findCategoryByDocument(@PathVariable String name){
       return ResponseEntity.ok(categoryService.findByName(name));
    }

    @GetMapping("/find-all")
    public ResponseEntity<ApiResponse<List<Category>>> findAllCategory(){
        log.info("Inicio busqueda de todas las categorias");
        List<Category> listCategories = categoryService.findAll();

        ApiResponse<List<Category>> apiResponse = ResponseBuilder.successMessage("Categorias encontradas exitosamente: "+
                listCategories.size(),listCategories);

        log.info("response busqueda categorias: {}",apiResponse.toString());
        log.info("Finalizo busqueda de todas las categorias");

        return ResponseEntity.ok(apiResponse);
    }
}

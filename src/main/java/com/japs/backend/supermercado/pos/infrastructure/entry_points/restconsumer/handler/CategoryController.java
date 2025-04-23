package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.handler;

import com.japs.backend.supermercado.pos.application.services.CategoryService;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@Valid @RequestBody Category categoryRequest){
        try {
            return ResponseEntity.ok(categoryService.save(categoryRequest));
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            log.error("Error inesperado: "+e.getMessage());
            return ResponseEntity.internalServerError().body("No se pudo crear la categoria.");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category categoryRequest){
        try {
            return ResponseEntity.ok(categoryService.update(id,categoryRequest));
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            log.error("Error inesperado: "+e.getMessage());
            return ResponseEntity.internalServerError().body("No se pudo actualizar la categoria.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try {
            categoryService.delete(id);
            return ResponseEntity.ok("Se Elimino la categoria correctamente.");
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            log.error("Error inesperado: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Ocurrio un inconveniente no se pudo eliminar la categoria.");
        }
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            log.error("Error inesperado: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Ocurrio un inconveniente no se pudo encontrar la categoria.");
        }
    }

    @GetMapping("/find-by-document/{name}")
    public ResponseEntity<?> findCustomerByDocument(@PathVariable String name){
        try {
            return ResponseEntity.ok(categoryService.findByName(name));
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            log.error("Error inesperado: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Ocurrio un inconveniente no se pudo encontrar la categoria.");
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllCustomers(){
        try {
            return ResponseEntity.ok(categoryService.findAll());
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            log.error("Error inesperado: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Ocurrio un inconveniente al buscar el listado de las categorias.");
        }
    }
}

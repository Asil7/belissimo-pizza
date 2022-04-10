package uzpdp.belissimopizza.controller;

//Asilbek Fayzullayev 09.04.2022 16:10   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzpdp.belissimopizza.Servise.CategoryService;
import uzpdp.belissimopizza.model.Category;
import uzpdp.belissimopizza.payload.ApiResponse;

import java.util.Random;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public HttpEntity<?> getAllCategories(){
        ApiResponse allCategories = categoryService.getAllCategories();
        return ResponseEntity.status(allCategories.isSuccess()?200:400).body(allCategories);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCategoryById(@PathVariable Integer id){
        ApiResponse categoryById = categoryService.getCategoryById(id);
        return ResponseEntity.status(categoryById.isSuccess()?200:400).body(categoryById);
    }

    @PostMapping
    public HttpEntity<?> addCategory(@RequestBody Category category){
        ApiResponse apiResponse = categoryService.addCategory(category);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCategory(@RequestBody Category category,@PathVariable Integer id){
        ApiResponse apiResponse = categoryService.editCategory(id, category);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable Integer id){
        ApiResponse apiResponse = categoryService.deleteCategory(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }
}

package com.example.lookupservice.controller;

import com.example.lookupservice.model.Category;
import com.example.lookupservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories =  categoryService.getAllCategories();
        return  new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable("id")String id){
        Optional<Category> c = categoryService.findById(id);
        return  new ResponseEntity<>(c,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<String>> findByIds(@RequestParam(value = "ids") List<String> ids){

        List<String>categories = categoryService.getCategoriesNamesByIds(ids);

        return  new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category c = categoryService.addCategory(category);
        return  new ResponseEntity<>(c,HttpStatus.CREATED);
    }
    @PostMapping("/add/many")
    public ResponseEntity<List<Category>> addManyCategories(@RequestBody List<Category> categories){
        List<Category> categoriesList = categoryService.addManyCategories(categories);
        return new ResponseEntity<>(categoriesList,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category c = categoryService.updateCategory(category);
        return  new ResponseEntity<>(c,HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id){
        categoryService.deleteCategory(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}

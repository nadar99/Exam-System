package com.example.lookupservice.service;

import com.example.lookupservice.model.Category;
import com.example.lookupservice.repo.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public List<String> getCategoriesNamesByIds(List<String> ids){
        List< String> categoriesNames = new ArrayList<>();
        for(String id : ids){
            categoriesNames.add( categoryRepo.findById(id).map( c->c.getName()).orElse(null));
        }
       return categoriesNames;
    }

    public Category addCategory(Category category){
        return  categoryRepo.save(category);
    }
    public List<Category> addManyCategories(List<Category> categories){

        return categoryRepo.saveAll(categories);
    }
    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    public Optional<Category>  findById(String id){
        return categoryRepo.findById(id);
    }

    public void deleteCategory(String id){
        categoryRepo.deleteById(id);
    }

}


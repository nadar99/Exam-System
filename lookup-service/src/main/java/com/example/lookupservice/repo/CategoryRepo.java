package com.example.lookupservice.repo;

import com.example.lookupservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category,String> {
}

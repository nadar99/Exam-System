package com.example.questionbankservice.repo;

import com.example.questionbankservice.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends MongoRepository<Question,String> {
}

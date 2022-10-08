package com.example.questionbankservice.service;

import com.example.questionbankservice.model.Question;
import com.example.questionbankservice.repo.QuestionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepo questionRepo;
    public List<Question> getAllQuestions(){
        List<Question> questions = questionRepo.findAll();
        System.out.println("length "+questions.size());
        if(!questions.isEmpty()){
            System.out.println("length "+questions.size());
            List<String> ids = new ArrayList<>();
            for(Question q :questions){
                ids.add(q.getCategory_id());
            }
            WebClient webClient = WebClient
                    .builder()
                    .baseUrl("http://cloud-gateway:8080/")
//                    .baseUrl("http://localhost:8080/")
                    .build();
            List<String> response =  webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/categories/all/")
                            .queryParam("ids",ids)
                            .build())
                    .retrieve()
                    .bodyToMono(List.class)
                    .block();
            if(!response.isEmpty()){
                for(int i =0;i< questions.size();i++){
                    questions.get(i).setCategory_name(response.get(i));
                }
            }

        }

        return questions;
    }

    public Question addQuestion(Question question){
        question.setCreated_by("admin");
        question.setCreated_at(LocalDateTime.now());
        return  questionRepo.save(question);
    }
    public List<Question> addManyQuestions(List<Question> questions){
        for(Question question:questions){
            question.setCreated_by("admin");
            question.setCreated_at(LocalDateTime.now());
        }
        return questionRepo.saveAll(questions);
    }
    public Question updateQuestion(Question question){
        return questionRepo.save(question);
    }

    public void deleteQuestion(String id){
         questionRepo.deleteById(id);
    }

}

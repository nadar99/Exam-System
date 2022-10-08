package com.example.questionbankservice.controller;

import com.example.questionbankservice.model.Question;
import com.example.questionbankservice.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.SupportedOptions;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(@RequestHeader("question-request") String header) throws InterruptedException {
        System.out.println(header);
        List<Question> questions =  questionService.getAllQuestions();
//        Thread.sleep(600);
        return  new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question q = questionService.addQuestion(question);
        return  new ResponseEntity<>(q,HttpStatus.CREATED);
    }
    @PostMapping("/add/many")
    public ResponseEntity<List<Question>> addManyQuestion(@RequestBody List<Question> questions){
        List<Question> questionList = questionService.addManyQuestions(questions);
        return new ResponseEntity<>(questionList,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        Question q = questionService.updateQuestion(question);
        return  new ResponseEntity<>(q,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") String id){
        questionService.deleteQuestion(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}

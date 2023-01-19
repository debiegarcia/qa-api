package com.bit2bit.qaapi.api;

import com.bit2bit.qaapi.domain.model.entity.Question;
import com.bit2bit.qaapi.domain.service.QuestionService;
import com.bit2bit.qaapi.mapping.QuestionMapper;
import com.bit2bit.qaapi.resource.CreateQuestionResource;
import com.bit2bit.qaapi.resource.QuestionResource;
import com.bit2bit.qaapi.resource.UpdateQuestionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Question")
@RestController
@RequestMapping("api/v1/questions")
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @Operation(summary = "Get Questions", description = "Get All Questions")
    @GetMapping
    public List<QuestionResource> getAll(){
        return questionMapper.toResource(questionService.getAll());
    }

    @Operation(summary = "Get Questions by Title", description = "Get Questions by Title Order By Created At Date Descendent")
    @GetMapping("title/{title}")
    public List<QuestionResource> getQuestionsByTitle(@PathVariable String title){
        return questionMapper.toResource(questionService.getAllByTitle(title));
    }

    @Operation(summary = "Get Questions Order By Created At Date Descendent", description = "Get Questions Order By Created At Date Descendent")
    @GetMapping("date")
    public List<QuestionResource> getQuestionsOrderByCreatedAtDateDescendent(){
        return questionMapper.toResource(questionService.getAllOrderByPublishedDate());
    }

    @Operation(summary = "Get Questions Order By Likes", description = "Get Questions Order By Likes")
    @GetMapping("likes")
    public List<QuestionResource> getQuestionsOrderByLikes(){
        return questionMapper.toResource(questionService.getAllByLikes());
    }

    @Operation(summary = "Get Question by Id", description = "Get Question by Id")
    @GetMapping("{questionId}")
    public QuestionResource getQuestionById(@PathVariable Long questionId) {
        return questionMapper.toResource(questionService.getById(questionId));
    }

    @Operation(summary = "Create Question", description = "Create Question")
    @PostMapping("/user/{userId}")
    public QuestionResource createQuestion(@RequestBody CreateQuestionResource model, @PathVariable Long userId){
        return questionMapper.toResource(questionService.create(questionMapper.toModel(model), userId));
    }

    @Operation(summary = "Update Question", description = "Update Question")
    @PutMapping("{questionId}")
    public QuestionResource updateQuestion(@PathVariable Long questionId, @RequestBody UpdateQuestionResource model){
        return questionMapper.toResource(questionService.update(questionId, questionMapper.toModel(model)));
    }

    @Operation(summary = "Delete Question", description = "Delete Question")
    @DeleteMapping("{questionId}")
    public QuestionResource deleteQuestion(@PathVariable Long questionId){
        return questionMapper.toResource(questionService.delete(questionId));
    }
}

package com.bit2bit.qaapi.api;

import com.bit2bit.qaapi.domain.service.ReplyService;
import com.bit2bit.qaapi.mapping.ReplyMapper;
import com.bit2bit.qaapi.resource.CreateReplyResource;
import com.bit2bit.qaapi.resource.ReplyResource;
import com.bit2bit.qaapi.resource.UpdateReplyResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reply")
@RestController
@RequestMapping("api/v1/replies")
@CrossOrigin
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyMapper replyMapper;

    public ReplyController(ReplyService replyService, ReplyMapper replyMapper) {
        this.replyService = replyService;
        this.replyMapper = replyMapper;
    }

    @Operation(summary = "Get Replies", description = "Get All Replies")
    @GetMapping
    public List<ReplyResource> getAll(){
        return replyMapper.toResource(replyService.getAll());
    }

    @Operation(summary = "Get Replies by QuestionId", description = "Get Replies by QuestionId")
    @GetMapping("question/{questionId}")
    public List<ReplyResource> getAllByQuestionId(@PathVariable Long questionId){
        return replyMapper.toResource(replyService.getAllByQuestionId(questionId));
    }

    @Operation(summary = "Get Reply by Id", description = "Get Reply by Id")
    @GetMapping("{replyId}")
    public ReplyResource getReplyById(@PathVariable Long replyId){
        return replyMapper.toResource(replyService.getById(replyId));
    }

    @Operation(summary = "Create Reply", description = "Create Reply")
    @PostMapping("question/{questionId}/user/{userId}")
    public ReplyResource createReply(@RequestBody CreateReplyResource model, @PathVariable Long userId, @PathVariable Long questionId){
        return replyMapper.toResource(replyService.create(replyMapper.toModel(model), userId, questionId));
    }

    @Operation(summary = "Update Reply", description = "Update Reply")
    @PutMapping("{replyId}")
    public ReplyResource updateReply(@PathVariable Long replyId, @RequestBody UpdateReplyResource model){
        return replyMapper.toResource(replyService.update(replyId, replyMapper.toModel(model)));
    }

    @Operation(summary = "Delete Reply", description = "Delete Reply")
    @DeleteMapping("{replyId}")
    public ReplyResource deleteReply(@PathVariable Long replyId){
        return replyMapper.toResource(replyService.delete(replyId));
    }


}

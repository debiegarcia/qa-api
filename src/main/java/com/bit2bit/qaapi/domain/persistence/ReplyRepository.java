package com.bit2bit.qaapi.domain.persistence;

import com.bit2bit.qaapi.domain.model.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByQuestionIdOrderByCreatedAtDesc(Long questionId);

}

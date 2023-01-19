package com.bit2bit.qaapi.domain.persistence;

import com.bit2bit.qaapi.domain.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTitleContainingOrderByCreatedAtDesc(String title);
    List<Question> findAllByOrderByCreatedAtDesc();
    List<Question> findAllByOrderByLikesDesc();

}

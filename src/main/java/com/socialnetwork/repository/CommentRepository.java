package com.socialnetwork.repository;

import com.socialnetwork.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface CommentRepository extends JpaRepository<Comments, Long> {
//    List<Post> findByEnabledOrderByCreationDateDesc(boolean enabled);


}

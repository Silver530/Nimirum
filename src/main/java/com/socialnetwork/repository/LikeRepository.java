package com.socialnetwork.repository;

import com.socialnetwork.domain.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface LikeRepository extends JpaRepository<Likes, Long> {
//    List<Post> findByEnabledOrderByCreationDateDesc(boolean enabled);


}

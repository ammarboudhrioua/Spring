package com.FivePoints.Spring.repositories;

import com.FivePoints.Spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    public Post findByTitle(String title);
}

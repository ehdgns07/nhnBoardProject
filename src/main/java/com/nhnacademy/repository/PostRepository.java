package com.nhnacademy.repository;

import com.nhnacademy.domain.Post;
import java.util.Map;

public interface PostRepository {
    void register(Post post);
    void modify(Post post);
    Post remove(long id);

    Post getPost(long id);
    Map<Long, Object> getPosts();
}

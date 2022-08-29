package com.nhnacademy.repository;

import com.nhnacademy.domain.Post;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Board implements PostRepository{
    Map<Long, Object> posts = new ConcurrentHashMap<>();

    @Override
    public void register(Post post) {
        post.setId(posts.size());
        posts.put((long) posts.size(), post);
    }
    @Override
    public void modify(Post post) {
        Post modifyPost = (Post) this.posts.get(post.getId());
        modifyPost.setTitle(post.getTitle());
        modifyPost.setContent(post.getContent());
    }
    @Override
    public Post remove(long id) {
        return (Post) posts.remove(id);
    }
    @Override
    public Post getPost(long id) {
        return (Post) this.posts.get(id);
    }
    @Override
    public Map<Long, Object> getPosts() {
        return this.posts;
    }
}

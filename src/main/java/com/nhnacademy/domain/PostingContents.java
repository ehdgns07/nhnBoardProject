package com.nhnacademy.domain;

import java.time.LocalDateTime;

public class PostingContents implements Post{
    long uid;
    String title;
    String content;
    String writerUserId;
    String writeTime;
    int count; // 조회수

    public PostingContents(String title, String content, String writerUserId, String writeTime) {
        this.title = title;
        this.content = content;
        this.writerUserId = writerUserId;
        this.writeTime = writeTime;
    }

    @Override
    public long getId() {
        return this.uid;
    }
    @Override
    public void setId(long id) {
        this.uid = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return this.content;
    }
    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getWriterUserId() {
        return this.writerUserId;
    }
    @Override
    public void setWriterUserId(String writerUserId) {
        this.writerUserId = writerUserId;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return LocalDateTime.now();
    }

    @Override
    public void setWriteTime(LocalDateTime writeTime) {

    }

    @Override
    public int getViewCount() {
        return this.count;
    }

    @Override
    public void increaseViewCount() {
        this.count++;
    }
}

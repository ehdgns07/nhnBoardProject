package com.nhnacademy.domain;

public class BoardUser implements User{
    String id;
    String pwd;
    String name;
    String profile;
    Level level;
    int count =0;

    public BoardUser(String id, String pwd, String name, Level level) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.level = level;
    }

    public enum Level{
        ADMIN, USER
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public void setPassword(String password) {
        this.pwd = pwd;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return this.profile;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profile = profileFileName;
    }

    @Override
    public BoardUser.Level getLevel() {
        return level;
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

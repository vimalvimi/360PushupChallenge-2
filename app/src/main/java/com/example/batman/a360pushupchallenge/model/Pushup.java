package com.example.batman.a360pushupchallenge.model;

public class Pushup {

    private String name;
    private String uri_path;
    private int image;
    private int score;

    public Pushup(String name, String uri_path, int image, int score) {
        this.name = name;
        this.uri_path = uri_path;
        this.image = image;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri_path(String uri_path) {
        this.uri_path = uri_path;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getUri_path() {
        return uri_path;
    }

    public int getImage() {
        return image;
    }

    public int getScore() {
        return score;
    }
}

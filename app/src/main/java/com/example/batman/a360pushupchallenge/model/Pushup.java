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

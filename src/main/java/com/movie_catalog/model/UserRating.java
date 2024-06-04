package com.movie_catalog.model;

import org.springframework.stereotype.Component;

import java.util.List;


public class UserRating {
    public UserRating() {

    }

    public List<Rating> getUserrating() {
        return userrating;
    }

    public void setUserrating(List<Rating> userrating) {
        this.userrating = userrating;
    }

    private List<Rating> userrating;

}

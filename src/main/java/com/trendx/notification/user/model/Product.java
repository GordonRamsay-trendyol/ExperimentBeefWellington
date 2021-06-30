package com.trendx.notification.user.model;

import java.util.List;

public class Product {
    private Long id;
    private List<User> followers;

    public List<User> getFollowers() {
        return followers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", followers=" + followers +
                '}';
    }
}

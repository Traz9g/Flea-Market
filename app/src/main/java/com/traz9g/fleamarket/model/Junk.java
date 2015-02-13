package com.traz9g.fleamarket.model;

import com.backendless.BackendlessUser;

import java.util.List;

public class Junk {
    public String name;
    public String about;
    public String category;
    public BackendlessUser owner;
    public String imageUrl;
    public List<Comment> comments;
}

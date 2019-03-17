package com.example.histiricalsite;

class List {

    // Member variables representing the title and information about the sport.
    private String title;
    private String location;
    private String subdetail;
    private final int imageResource;

    public List(String title, String location, String subdetail, int imageResource) {
        this.title = title;
        this.location = location;
        this.subdetail = subdetail;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getLocation() {
        return location;
    }

    String getSubdetail() {
        return subdetail;
    }

    public int getImageResource() {
        return imageResource;
    }

}
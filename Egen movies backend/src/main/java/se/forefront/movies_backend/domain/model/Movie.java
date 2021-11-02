package se.forefront.movies_backend.domain.model;

public class Movie {

    private String id;
    private String title;
    private Double rating;

    public Movie() {
    }

    public Movie(String id, String title, String description, String imageUrl, Double rating, Integer numberOfVotes) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}

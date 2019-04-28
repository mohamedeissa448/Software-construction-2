package model;

public class Movie {

    private String title;
    private int ageRestriction;
    private int currentSeating;
    private int maxSeating;

    public Movie(String title, int ageRestriction, int seating) {
        this.title = title;
        this.ageRestriction = ageRestriction;
        this.currentSeating = 0;
        this.maxSeating = seating;
    }

    //getters
    public String getTitle() {
        // TODO: complete the implementation of this method
        return title;
    }
    public int getAgeRestriction() {
        // TODO: complete the implementation of this method
        return ageRestriction;
    }
    public int getCurrentSeating() {
        // TODO: complete the implementation of this method
        return currentSeating;
    }
    public int getMaxSeating() {
        // TODO: complete the implementation of this method
        return maxSeating;
    }

    //EFFECTS: returns true if the movie is at full capacity, else return false
    public boolean isFull() {
        // TODO: complete the implementation of this method
        return currentSeating == maxSeating;
    }

    //EFFECTS: increment the currentSeating field by 1
    public void addViewer() {
        // TODO: complete the implementation of this method

        currentSeating++;
    }


}

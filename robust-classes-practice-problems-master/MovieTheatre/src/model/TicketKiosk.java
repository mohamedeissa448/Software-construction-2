package model;
import Exceptions.ShowingFullException;
import Exceptions.UnderAgeException;

import java.util.LinkedList;
import java.util.List;

public class TicketKiosk {

    private String name;
    private List<Movie> movies;

    // EFFECTS: TicketKiosk with name (name) is created
    public TicketKiosk(String name) {
        this.name = name;
        movies = new LinkedList<>();
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }
    public List<Movie> getMovies() {
        // TODO: complete the implementation of this method
        return movies;
    }

    //EFFECTS:  adds the movie to movies, unless it is already in movies.
    //          if add is successful return true, otherwise return false.
    public boolean addMovie(Movie m) {
        // TODO: complete the implementation of this method
        if (!movies.contains(m)){
            movies.add(m);
            return true;
        }

        return false;
    }

    //EFFECTS: calls MovieGoer's buyTicket method, passing m as a parameter.
    public boolean sellTicket(MovieGoer mg, Movie m) {
        // TODO: complete the implementation of this method
        try {
            mg.buyTicket(m);
        } catch (ShowingFullException e) {
            e.getMessage();
            return false;
        } catch (UnderAgeException e) {
            e.getMessage();
            return false;
        }
        return true;
    }


}

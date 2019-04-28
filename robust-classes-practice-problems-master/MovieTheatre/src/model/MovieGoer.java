package model;

import Exceptions.ShowingFullException;
import Exceptions.UnderAgeException;

public class MovieGoer {

    private String name;
    private int age;
    private Ticket ticket;
    private TicketKiosk tk;

    public MovieGoer(String name, int age,  TicketKiosk tk) {
        this.name = name;
        this.age = age;
        this.tk = tk;
        ticket = null;
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }
    public int getAge() {
        // TODO: complete the implementation of this method
        return age;
    }
    public TicketKiosk getTicketKiosk() {
        // TODO: complete the implementation of this method
        return tk;
    }
    public Ticket getTicket() {
        // TODO: complete the implementation of this method
        return ticket;
    }

    // REQUIRES: the movie (m) must not be at full capacity, i.e. more people can watch the movie
    //           this moviegoer must be of appropriate age to watch the movie (age > m.ageRestriction)
    // MODIFIES: this
    // EFFECTS: a new ticket associated with the given movie is created, and
    //           becomes this MovieGoer's ticket
    public void buyTicket(Movie m) throws ShowingFullException, UnderAgeException {
        // TODO: complete the implementation of this method
        if (m.isFull()){
            throw  new ShowingFullException();
        }
        if (age<m.getAgeRestriction())
            throw new UnderAgeException();
        ticket=new Ticket(m);
        m.addViewer();
    }


}

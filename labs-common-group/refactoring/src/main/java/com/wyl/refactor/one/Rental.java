package com.wyl.refactor.one;

/**
 * Created by wangyunlong on 17/4/6.
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    @Override
    public String toString() {
        return "\t" + movie.getTitle() + "\t" + getCharge() + "\n";
    }
}

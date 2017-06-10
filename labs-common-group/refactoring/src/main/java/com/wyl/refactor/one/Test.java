package com.wyl.refactor.one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyunlong on 17/4/6.
 */
public class Test {

    private static List<Movie> movies = new ArrayList<Movie>();

    static {
        movies.add(new Movie("java", Movie.CHILDRENS));
        movies.add(new Movie("C++", Movie.REGULAR));
        movies.add(new Movie("Go", Movie.NEW_RELEASE));
    }

//    Rental Record for yunlong
//    java	1.5
//    C++	2.0
//    Go	6.0
//    Amount owed is 9.5
//    You earned 4 frequent renter points
    public static void main(final String[] args) {
        final Customer customer = new Customer("yunlong");
        movies.forEach( movie -> {
            Rental rental = new Rental(movie, 2);
            customer.addRental(rental);
        });
        System.out.println(customer.statement());

        System.out.println(customer.htmlStatement());
    }
}

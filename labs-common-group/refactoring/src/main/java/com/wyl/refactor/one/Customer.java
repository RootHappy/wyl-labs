package com.wyl.refactor.one;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by wangyunlong on 17/4/6.
 */
public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }


    public String htmlStatement() {
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + ": " + rental.getCharge() + "<BR>\n";
        }
        result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
        return result;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            result += rental.toString();
        }
        result += toString();
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Amount owed is " + getTotalCharge() + "\nYou earned " + getTotalFrequentRenterPoints() + " frequent renter points";
    }
}

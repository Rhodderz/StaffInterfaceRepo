/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhodderz.records;

/**
 *
 * @author Ian
 */
public class Booking
{
    private String customer;
    private String event;
    private int standing;
    private int sitting;
        
    public Booking(String customer, String event, int standing, int sitting) 
    {
        this.customer = customer;
        this.event = event;
        this.standing = standing;
        this.sitting = sitting;
    }
    
    @Override
    public String toString()
    {
        return event + ", " + customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public int getSitting() {
        return sitting;
    }

    public void setSitting(int sitting) {
        this.sitting = sitting;
    }
    
    
}

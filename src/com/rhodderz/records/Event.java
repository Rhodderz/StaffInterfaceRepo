/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhodderz.records;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian
 */
public class Event 
{
    int eventID, totCapacity, totSitting, totStanding, currCapacity,
            currSitting, currStanding, ageLimit;
    String eventName, venueName, oneNightOnly, startDate, endDate;
    
    public Event (int event, int totCap, int totSit, int totStand,
            int currCap, int currSit, int currStand, int age, String name, 
            String venue, String oNO, String start, String end)
    {
        this.eventID = event;
        this.totCapacity = totCap;
        this.totSitting = totSit;
        this.totStanding = totStand;
        this.currCapacity = currCap;
        this.currSitting = currSit;
        this.currStanding = currStand;
        this.ageLimit = age;
        this.eventName = name;
        this.venueName = venue;
        this.oneNightOnly = oNO;
        this.startDate = start;
        this.endDate = end;
    }
    
    @Override
    public String toString()
    {
        try {
            return getEventName() + ", " + getVenueName() + ", " + formatDate(getStartDate());
        } catch (ParseException ex) 
        {
        }
        return null;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getTotCapacity() {
        return totCapacity;
    }

    public void setTotCapacity(int totCapacity) {
        this.totCapacity = totCapacity;
    }

    public int getTotSitting() {
        return totSitting;
    }

    public void setTotSitting(int totSitting) {
        this.totSitting = totSitting;
    }

    public int getTotStanding() {
        return totStanding;
    }

    public void setTotStanding(int totStanding) {
        this.totStanding = totStanding;
    }

    public int getCurrCapacity() {
        return currCapacity;
    }

    public void setCurrCapacity(int currCapacity) {
        this.currCapacity = currCapacity;
    }

    public int getCurrSitting() {
        return currSitting;
    }

    public void setCurrSitting(int currSitting) {
        this.currSitting = currSitting;
    }

    public int getCurrStanding() {
        return currStanding;
    }

    public void setCurrStanding(int currStanding) {
        this.currStanding = currStanding;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOneNightOnly() {
        return oneNightOnly;
    }

    public void setOneNightOnly(String oneNightOnly) {
        this.oneNightOnly = oneNightOnly;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
     public String formatDate(String dateToFormat) throws ParseException
    {
        final String s = dateToFormat;
        String newDateString = new SimpleDateFormat("dd-MMM-yy").format
                (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s));
        return newDateString;
    }
}

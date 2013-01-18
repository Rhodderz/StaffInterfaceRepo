/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhodderz.records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ian
 */
public class EventList 
{
    private ArrayList<Event> list;

    public EventList() 
    {
         list = new ArrayList<Event>();
    }

    public EventList(ResultSet rs) 
    {
          Event e;
          list = new ArrayList<Event>();
          try {
               while (rs.next()) 
               {
                  e = new Event(rs.getInt(1), rs.getInt(7), rs.getInt(8), rs.getInt(9), 
                          rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
                          rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                          rs.getString(6));
                  list.add(e);
               }
            }
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
     }
    
        /*
         * Returns the number of elements.
         */
       public int size() 
       {
            return list.size();
       }

        /*
         * Returns the event at a given location. The result is 'null'
         * if the index is out of range.
         */
        public Event getEventAt(int index) 
        {
            if (index < 0 || index >= list.size())
                return null;
            else
                return list.get(index);
        }
}

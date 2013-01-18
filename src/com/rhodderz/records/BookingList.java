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
public class BookingList 
{
    private ArrayList<Booking> list;

    public BookingList() 
    {
         list = new ArrayList<Booking>();
    }

    public BookingList(ResultSet rs) 
    {
          Booking b;
          list = new ArrayList<Booking>();
          try {
               while (rs.next()) 
               {
                  b = new Booking(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                  list.add(b);
               }
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
     }
        
        /*
         * Returns the number of elements.
         */
       public int size() 
       {
            return list.size();
       }

        public Booking getBookingAt(int index) 
        {
            if (index < 0 || index >= list.size())
                return null;
            else
                return list.get(index);
        }
}

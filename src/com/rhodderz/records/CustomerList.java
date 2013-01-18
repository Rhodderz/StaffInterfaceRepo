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
public class CustomerList 
{
    private ArrayList<Customer> list;

    public CustomerList() 
    {
         list = new ArrayList<Customer>();
    }

    public CustomerList(ResultSet rs) 
    {
          Customer c;
          list = new ArrayList<Customer>();
          try {
               while (rs.next()) 
               {
                  c = new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(1));
                  list.add(c);
               }
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
     }

        /*
         * Adds a course object to the list
         */
      public void addCustomer(Customer newCustomer) 
      {
            list.add(newCustomer);
      }
        
        /*
         * Returns the number of elements.
         */
       public int size() 
       {
            return list.size();
       }

        /*
         * Returns the course at a given location. The result is 'null'
         * if the index is out of range.
         */
        public Customer getCustomerAt(int index) 
        {
            if (index < 0 || index >= list.size())
                return null;
            else
                return list.get(index);
        }
}

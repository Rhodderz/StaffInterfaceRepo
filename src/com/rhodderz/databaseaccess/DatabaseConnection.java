/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhodderz.databaseaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.rhodderz.records.BookingList;
import com.rhodderz.records.CustomerList;
import com.rhodderz.records.EventList;

/**
 *
 * @author Ian
 */
public class DatabaseConnection 
{
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rset;
    String queryString;
    
    public void createConnection(String userName, String userPassword) throws SQLException, ClassNotFoundException 
    {
        String userId = userName;
        String password = userPassword;
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection
                    ("jdbc:oracle:thin:@larry.uopnet.plymouth.ac.uk:1521:orcl",
                        userId, password);
            System.out.println("CONNECTION ESTABLISHED");
        }
        catch (Exception e) 
        {
            
        }
    }
    
    public void closeConnection() throws SQLException, ClassNotFoundException 
    {
        conn.close();
    }
    
    public CustomerList allCustomers()throws SQLException, ClassNotFoundException 
    {  
        CustomerList customers;  
        queryString = "SELECT * FROM CUSTOMERS";
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
        customers = new CustomerList(rset);  
        return customers;
    }
    
     public BookingList allBookings(String orderField) throws SQLException, ClassNotFoundException 
    {
        BookingList bookings;
        queryString = "SELECT FIRST_NAME|| ' ' ||LAST_NAME, EVENT_NAME, SIT_QUANTITY, STAND_QUANTITY "
                + "FROM BOOKINGS JOIN CUSTOMERS ON CUSTOMERS.CUSTOMER_ID = BOOKINGS.CUSTOMER_ID "
                + "JOIN VENUE_EVENTS ON VENUE_EVENTS.EVENT_ID = BOOKINGS.EVENT_ID "
                + "ORDER BY " + orderField;
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
        bookings = new BookingList(rset);
        return bookings;
    }
    
    public EventList allEvents() throws SQLException, ClassNotFoundException 
    {
        EventList events;
        queryString = "SELECT EVENT_ID,  EVENT_NAME, VENUE_NAME, ONE_NIGHT_ONLY, "
                + "EVENT_DATE, END_DATE,  TOTAL_CAPACITY, TOTAL_SITTING, TOTAL_STANDING, "
                + "CURRENT_CAPACITY, CURRENT_SITTING,  CURRENT_STANDING, AGE_LIMIT "
                + "FROM VENUE_EVENTS JOIN VENUES ON VENUE_EVENTS.VENUE_ID = VENUES.VENUE_ID";
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
        events = new EventList(rset);  
        return events;
    }
    
    public void addCustomer(String first, String last, String dob, String address,
            String postcode, String telephone, String email, String password,
            String guest)  throws SQLException, ClassNotFoundException 
    {
        queryString = "INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME, DOB, ADDRESS,"
                + " POSTCODE, PHONE_NUMBER, EMAIL_ADDRESS, ACCOUNT_PASSWORD, GUEST_ACCOUNT)"
                + " VALUES ( '" + first + "', '" + last + "', '" + dob + "', '" + address
                + "', '" + postcode + "', '" + telephone + "', '" + email + "', '" + password
                + "', '" + guest + "')";
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
    }
    
    public void editCustomer(int id_no, String first, String last, String dob, String address,
            String postcode, String telephone, String email, String password,
            String guest)  throws SQLException, ClassNotFoundException 
    {
        queryString = "UPDATE CUSTOMERS SET FIRST_NAME = '" + first + "', LAST_NAME = '" + last
                + "', DOB = '" + dob + "', ADDRESS = '" + address + "', POSTCODE = '" + postcode +
                "', PHONE_NUMBER = '" + telephone + "', EMAIL_ADDRESS = '" + email +
                "', ACCOUNT_PASSWORD = '" + password + "', GUEST_ACCOUNT = '" + guest + "' WHERE"
                + " CUSTOMER_ID = " + id_no;
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
    }
           
    public void deleteCustomer(int custNo) throws SQLException, ClassNotFoundException 
    {
        queryString = "DELETE FROM CUSTOMERS WHERE CUSTOMER_ID = " + custNo;
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
    }
    
    public void deleteEvent(int eventNo) throws SQLException, ClassNotFoundException 
    {
        queryString = "DELETE FROM VENUE_EVENTS WHERE EVENT_ID = " + eventNo;
        pstmt = conn.prepareStatement(queryString);
        rset = pstmt.executeQuery();
    }
}

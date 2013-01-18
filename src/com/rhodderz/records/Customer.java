/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhodderz.records;
/**
 *
 * @author Ian
 */
public class Customer 
{
    private String firstName, lastName, dob, address, postcode, phoneNumber,
            emailAddress, password, guest;
    private int customer_no;
    
    public Customer (String firstName, String lastName,
    String dob,String address, String postcode, String phoneNumber,String emailAddress,
    String password, String guest, int custNo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.guest = guest;
        this.customer_no = custNo;
    }
    
    @Override
    public String toString()
    {
        return getFullName();
    }

    public String getFullName()
    {
        return lastName + ", " + firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public int getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(int customer_no) {
        this.customer_no = customer_no;
    }
}

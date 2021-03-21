package com.paypal.bfs.test.employeeserv.execption;

import junit.framework.TestCase;

import java.util.Date;

public class ErrorDetailsTest extends TestCase {


    public void testGetTimestamp() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"test","test Details");
        assertEquals(errorDetails.getDetails(),"test Details");
    }

    public void testGetMessage() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"test","test Details");
        assertEquals(errorDetails.getMessage(),"test");
    }

    public void testGetDetails() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"test","test Details");
        assertEquals(errorDetails.getDetails(),"test Details");
    }
}
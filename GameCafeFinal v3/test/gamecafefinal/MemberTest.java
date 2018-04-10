/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kayaya
 */
public class MemberTest {
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testCheckAge() {
        System.out.println("checkAge");
        int number = 101;
        Member instance = new Member(1,"T","K","San",24,"today", "type", "address1", "address2", "Southampton", "UK", "SO14");
        boolean expResult = true;
        boolean result = instance.checkAge(number);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of checkID method, of class Member.
     */
    @Test
    public void testCheckID() {
        System.out.println("checkID");
        int number = 1;
        Member instance = new Member(1,"T","K","San",24,"today", "type", "address1", "address2", "Southampton", "UK", "SO14");
        boolean expResult = true;
        boolean result = instance.checkID(number);
        assertEquals(expResult, result);
        
    }
    
}

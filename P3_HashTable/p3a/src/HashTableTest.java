////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           HashTable P3
// Files:           HashTable.java, HashTableTest.java
// Course:          CS400, Spring 2019
//
// Author:          Stephen Fan
// Email:           sfan54@wisc.edu
// Lecturer's Name: Deb Deppeler
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import static org.junit.jupiter.api.Assertions.*; // org.junit.Assert.*; 
import org.junit.jupiter.api.Assertions;
 
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 
import java.util.Random;



/**
 * Test class for HashTable
 * @author Stephen Fan
 *
 */
public class HashTableTest{
	HashTableADT htIntegerKey;

    @Before
    public void setUp() throws Exception {
        htIntegerKey = new HashTable<Integer,String>();

    }

    @After
    public void tearDown() throws Exception {
    	htIntegerKey = null;

    }
    
    /** 
     * Tests that a HashTable returns an integer code
     * indicating which collision resolution strategy 
     * is used.
     * REFER TO HashTableADT for valid collision scheme codes.
     */
    @Test
    public void test000_collision_scheme() {
        int scheme = htIntegerKey.getCollisionResolution();
        if (scheme < 1 || scheme > 9) 
            fail("collision resolution must be indicated with 1-9");
    }
        
    /** IMPLEMENTED AS EXAMPLE FOR YOU
     * Tests that insert(null,null) throws IllegalNullKeyException
     */
    @Test
    public void test001_IllegalNullKey() {
        try {
            HashTableADT htIntegerKey = new HashTable<Integer,String>();
            htIntegerKey.insert(null, null);
            fail("should not be able to insert null key");
        } 
        catch (IllegalNullKeyException e) { /* expected */ } 
        catch (Exception e) {
            fail("insert null key should not throw exception "+e.getClass().getName());
        }
    }
    
    /**
     * tests that 50000 keys can be inserted into the HashTable without running into errors
     * also tests the efficiency of the insert method
     */
    @Test
    public void test002_Insert50000Keys() {
    	
        try {
            HashTableADT htIntegerKey = new HashTable<Integer,String>(2, 1);
            for (int i = 0; i < 50000; i++) {
        		htIntegerKey.insert(i, "string");
        	}
        } 
        catch (Exception e) {
            fail("insert null key should not throw exception "+e.getClass().getName());
        }
    	
    }
    
    /**
     * tests if 50000 keys can be inserted into the HashTable and then 10000 removed.
     */
    @Test
    public void test003_Insert50000KeysRemove10000() {
    	
        try {
            HashTableADT htIntegerKey = new HashTable<Integer,String>();
            for (int i = 0; i < 50000; i++) {
        		htIntegerKey.insert(i, i);
        	}
            for (int j = 0; j < 10000; j++) {
            	htIntegerKey.remove(j);
            }
        } 
        catch (Exception e) {
            fail("insert null key should not throw exception "+e.getClass().getName());
        }
    	
    }
    
    /**
     * checks that the correct number of keys is present in the HashTable after 50000 keys are added
     */
    @Test
    public void test004_Insert50000Keys_CheckNumKeys() {
    	
        try {
            HashTableADT htIntegerKey = new HashTable<Integer,String>();
            for (int i = 0; i < 50000; i++) {
        		htIntegerKey.insert(i, i);
        	}
            
            if (htIntegerKey.numKeys() != 50000) {
            	fail("there should be 50000 keys but there are" + htIntegerKey.numKeys());
            }
        } 
        catch (Exception e) {
            fail("insert null key should not throw exception "+e.getClass().getName());
        }
    	
    }
    
    /**
     * checks the get method after 50000 keys have been added to HashTable
     */
    @Test
    public void test005_Insert50000Keys_CheckGet() {
    	
        try {
            HashTableADT htIntegerKey = new HashTable<Integer,String>();
            for (int i = 0; i < 50000; i++) {
        		htIntegerKey.insert(i, i);
        	}
            
            if (htIntegerKey.get(1).equals(1) == false) {
            	fail("get should return 1");
            }
        } 
        catch (Exception e) {
            fail("insert null key should not throw exception "+e.getClass().getName());
        }
    	
    }
    
    /**
     * checks the get method after 50000 keys have been added to HashTable
     */
    @Test
    public void test006_Insert50000Keys_CheckGet2() {
    	
        try {
            HashTableADT htIntegerKey = new HashTable<Integer,String>();
            for (int i = 0; i < 50000; i++) {
        		htIntegerKey.insert(i, i);
        	}
            
            if (htIntegerKey.get(1000).equals(1000) == false) {
            	fail("get should return 1000");
            }
        } 
        catch (Exception e) {
            fail("insert null key should not throw exception "+e.getClass().getName());
        }
    	
    }
}

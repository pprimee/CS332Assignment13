
/*
 * Dustin Jutras and Pamela Phan
 * CS 332 HW 11
 * 11/14/2017
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class InstrumentedCollectionTest {

	@DataPoints
	public static String[] datapoints = {"dog","cat",""};
	@DataPoints
	public static Integer[] datapoints2 = {0,1,2};
	
	// COLLECTION
	
	/* Using Collections instead of Sets allows for different equals methods to be used.
	 * Rather than using just the Set Interface's equals(...) method, you can access
	 * others such as the List Interface's equals(...) method.  Although both 
	 * InstrumentedCollections will have the same item in it, they will access different
	 * equals methods and will be unable to compare to each other.
	 */
	
	@Theory
	public void collectionsEqualsTest(String s) {
		ArrayList<String> al = new ArrayList<String>();
		HashSet<String> hs = new HashSet<String>();

		al.add(s);
		hs.add(s);
		
		InstrumentedCollection<String> ical = new InstrumentedCollection<String>(al);
		InstrumentedCollection<String> ichs = new InstrumentedCollection<String>(hs);
				
		assertTrue(ical.equals(ichs)); // fails!
	}
	
	// SET
	
	/* This works and is the given example.
	 */
	
	@Theory
	public void setEqualsTest(String s) {

		InstrumentedSet<String> one = new InstrumentedSet<String>(new HashSet<String>());
		InstrumentedSet<String> two = new InstrumentedSet<String>(new TreeSet<String>());
				
		one.add(s);
		two.add(s);
		
		assertTrue(one.equals(two));
		assertTrue(two.equals(one));
	}
	
	// LIST

	/*
	 * Lists work fine when implemented as Set was.
	 */
	
	@Theory
	public void listEqualsTest(String s) {

		InstrumentedList<String> one = new InstrumentedList<String>(new ArrayList<String>());
		InstrumentedList<String> two = new InstrumentedList<String>(new LinkedList<String>());
				
		one.add(s);
		two.add(s);
		
		assertTrue(one.equals(two));
		assertTrue(two.equals(one));
	}
	
	// MAP
	
	/* The Map implementation is weird - you have to replace the
	 * addAll(...) method which is a part of the Collection interface but not part
	 * of the Map interface for some reason.
	 * 
	 * Equals(...) works fine though.
	 */
	
	@Theory
	public void mapEqualsTest(String s, Integer i) {

		InstrumentedMap<String, Integer> one = new InstrumentedMap<String, Integer>(new HashMap<String, Integer>());
		InstrumentedMap<String, Integer> two = new InstrumentedMap<String, Integer>(new TreeMap<String, Integer>());
				
		one.put(s,i);
		two.put(s,i);
		
		assertTrue(one.equals(two));
		assertTrue(two.equals(one));
	}

}

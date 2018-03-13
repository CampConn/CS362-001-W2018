package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.*;
//import java.util.Calendar;
//import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar day = new GregorianCalendar(2018,2,24);
		 CalDay testday = new CalDay(day);
		 Appt appt1 = new Appt(0, 0, 24, 2, 2018, "My actual birthday", "This is my birthday.");
		 Appt appt2 = new Appt(17, 0, 24, 2, 2018, "Birthday Party", "This is my birthday party.");
		 Appt appt3 = new Appt(9, 0, 24, 2, 2018, "Wake up", "Don't sleep in too late.");
		 Appt appt4 = new Appt(15, 0, 24, 2, 2018, "Movie", "Going to watch a movie.");
		 Appt appt5 = new Appt(-2, 100, 24, 2, 2018, "Not Valid", "Testing invalid appointment.");

		 assertEquals(0,testday.getSizeAppts());
		 testday.addAppt(appt3);
		 assertEquals(1,testday.getSizeAppts());
		 testday.addAppt(appt2);
		 assertEquals(2,testday.getSizeAppts());
		 testday.addAppt(appt1);
		 assertEquals(3,testday.getSizeAppts());
		 testday.addAppt(appt4);
		 assertEquals(4,testday.getSizeAppts());
		 testday.addAppt(appt5);
		 assertEquals(4,testday.getSizeAppts());
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 GregorianCalendar day = new GregorianCalendar(2018,2,24);
		 CalDay validday = new CalDay(day);
		 CalDay invalidday = new CalDay();

		 assertTrue(validday.isValid());
		 assertFalse(invalidday.isValid());
	 }

	@Test
	public void test03()  throws Throwable  {
		GregorianCalendar day = new GregorianCalendar(2018,2,24);
		CalDay testday = new CalDay(day);
		Appt appt1 = new Appt(0, 30, 24, 2, 2018, "My actual birthday", "This is my birthday.");
		Appt appt2 = new Appt(17, 30, 24, 2, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(9, 30, 24, 2, 2018, "Wake up", "Don't sleep in too late.");
		Appt appt4 = new Appt(15, 30, 24, 2, 2018, "Movie", "Going to watch a movie.");
		Appt appt5 = new Appt(-2, 100, 24, 2, 2018, "Not Valid", "Testing invalid appointment.");

		testday.addAppt(appt3);

		testday.addAppt(appt2);

		testday.addAppt(appt1);

		testday.addAppt(appt4);

		testday.addAppt(appt5);
		assertEquals("\t --- 2/24/2018 --- \n --- -------- Appointments ------------ --- \n\t2/24/2018 at 12:30am ,My actual birthday, This is my birthday.\n \t2/24/2018 at 9:30am ,Wake up, Don't sleep in too late.\n \t2/24/2018 at 3:30pm ,Movie, Going to watch a movie.\n \t2/24/2018 at 5:30pm ,Birthday Party, This is my birthday party.\n \n", testday.toString());
	}

	@Test
	  public void test04()  throws Throwable  {
		 CalDay invalidday = new CalDay();

		 assertEquals("", invalidday.toString());
	 }

	@Test
	public void test05()  throws Throwable  {
		GregorianCalendar day = new GregorianCalendar(2018,2,24);
		CalDay testday = new CalDay(day);
		Appt appt1 = new Appt(0, 0, 24, 2, 2018, "My actual birthday", "This is my birthday.");
		Appt appt2 = new Appt(17, 0, 24, 2, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(9, 0, 24, 2, 2018, "Wake up", "Don't sleep in too late.");
		Appt appt4 = new Appt(15, 0, 24, 2, 2018, "Movie", "Going to watch a movie.");
		Appt appt5 = new Appt(-2, 100, 24, 2, 2018, "Not Valid", "Testing invalid appointment.");
		 
		testday.addAppt(appt3);
		testday.addAppt(appt2);
		testday.addAppt(appt1);
		testday.addAppt(appt4);
		testday.addAppt(appt5);

		Iterator itr = testday.iterator();

		int i;
		int e = 0;
		while(itr.hasNext()){
			Appt o = (Appt) itr.next();
			i = o.getStartHour();
			assertTrue(i >= e);
			e = i;
		}
	}

	@Test
	public void test06()  throws Throwable  {;
		CalDay testday = new CalDay();

		Iterator itr = testday.iterator();

		assertEquals(null, itr);
	}
//add more unit tests as you needed	
}
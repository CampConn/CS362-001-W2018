package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 int apptnum = 0;
		 LinkedList<CalDay> temp = new LinkedList<CalDay>();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(0, 0, 24, 2, 2018, "My birthday", "This is my birthday.");
		 Appt appt2 = new Appt(17, 0, 25, 2, 2018, "Birthday Party", "This is my birthday party.");
		 Appt appt3 = new Appt(9, 0, 24, 1, 2018, "Wake up", "Don't sleep in too late.");
		 Appt appt4 = new Appt(15, 0, 23, 2, 2018, "Movie", "Going to watch a movie.");
		 Appt appt5 = new Appt(-2, 100, 26, 2, 2018, "Not Valid", "Testing invalid appointment.");
		 appt1.setRecurrence(null, 3, 1, 1000);

		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt4);
		 listAppts.add(appt5);

		 GregorianCalendar start = new GregorianCalendar(2018,2,22);
		 GregorianCalendar end = new GregorianCalendar(2018,2,27);

		 temp = timeTable.getApptRange(listAppts, start, end);
		 for(int i=0; i<temp.size(); i++){
		 	apptnum += temp.get(i).getSizeAppts();
		 }
		 assertEquals(3, apptnum);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 int apptnum = 0;
		 LinkedList<CalDay> temp = new LinkedList<CalDay>();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(0, 0, 24, 2, 2018, "My birthday", "This is my birthday.");
		 Appt appt2 = new Appt(17, 0, 25, 2, 2018, "Birthday Party", "This is my birthday party.");
		 Appt appt3 = new Appt(9, 0, 24, 1, 2018, "Wake up", "Don't sleep in too late.");
		 Appt appt4 = new Appt(15, 0, 24, 2, 2018, "Movie", "Going to watch a movie.");
		 Appt appt5 = new Appt(-2, 100, 26, 2, 2018, "Not Valid", "Testing invalid appointment.");
		 appt1.setRecurrence(null, 3, 1, 1000);

		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt4);
		 listAppts.add(appt5);

		 GregorianCalendar start = new GregorianCalendar(2018,2,22);
		 GregorianCalendar end = new GregorianCalendar(2018,2,27);

		 temp = timeTable.getApptRange(listAppts, start, end);
		 for(int i=0; i<temp.size(); i++){
			 apptnum += temp.get(i).getSizeAppts();
		 }
		 assertEquals(3, apptnum);
	 }
//add more unit tests as you needed

	@Test
	public void test03()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Appt appt1 = new Appt(0, 0, 24, 2, 2018, "My birthday", "This is my birthday.");
		Appt appt2 = new Appt(17, 0, 25, 2, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(9, 0, 24, 1, 2018, "Wake up", "Don't sleep in too late.");
		Appt appt4 = new Appt(15, 0, 24, 2, 2018, "Movie", "Going to watch a movie.");
		Appt appt5 = new Appt(-2, 100, 26, 2, 2018, "Not Valid", "Testing invalid appointment.");
		appt1.setRecurrence(null, 3, 1, 1000);

		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		listAppts.add(appt4);
		listAppts.add(appt5);

		assertEquals(5, listAppts.size());
		listAppts = timeTable.deleteAppt(listAppts, appt4);
		assertEquals(4, listAppts.size());
	}

	@Test
	public void test04()  throws Throwable  {
	 	int apptnum = 0;
		TimeTable timeTable=new TimeTable();
		LinkedList<CalDay> temp = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Appt appt1 = new Appt(0, 0, 24, 2, 2018, "My birthday", "This is my birthday.");
		Appt appt2 = new Appt(17, 0, 25, 2, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(9, 0, 24, 1, 2018, "Wake up", "Don't sleep in too late.");
		Appt appt4 = new Appt(15, 0, 24, 2, 2018, "Movie", "Going to watch a movie.");
		Appt appt5 = new Appt(-2, 100, 26, 2, 2018, "Not Valid", "Testing invalid appointment.");
		appt1.setRecurrence(null, 3, 1, 1000);
		int[] days = {1, 2, 3, 4, 5};
		appt3.setRecurrence(days, 1, 1, 1000);

		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		listAppts.add(appt4);
		listAppts.add(appt5);

		GregorianCalendar start = new GregorianCalendar(2018,2,22);
		GregorianCalendar end = new GregorianCalendar(2018,2,27);

		temp = timeTable.getApptRange(listAppts, start, end);
		for(int i=0; i<temp.size(); i++){
			apptnum += temp.get(i).getSizeAppts();
		}
		assertEquals(6, apptnum);
	}
}

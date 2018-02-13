package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		 assertTrue(appt.getValid());
		 assertEquals("\t1/7/2018 at 1:35pm ,Birthday Party, This is my birthday party.\n", appt.toString());



	 }
//add more unit tests as you needed
	@Test
	public void test03()  throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setStartHour(25);
		assertFalse(appt.getValid());
		appt.setStartHour(12);
		assertTrue(appt.getValid());
		appt.setStartHour(-2);
		assertFalse(appt.getValid());
	}

	@Test
	public void test04()  throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setStartMinute(61);
		assertFalse(appt.getValid());
		appt.setStartMinute(20);
		assertTrue(appt.getValid());
		appt.setStartMinute(-2);
		assertFalse(appt.getValid());
	}

	//This test failed in the not mutated code, which prevented pitest from running
	/*@Test
	public void test05m()  throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setStartMonth(13);
		assertFalse(appt.getValid());
		appt.setStartMonth(12);
		assertTrue(appt.getValid());
		appt.setStartMonth(-2);
		assertFalse(appt.getValid());
	}*/

	@Test
	public void test05() throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setTitle(null);
		assertEquals("", appt.getTitle());
	}

	@Test
	public void test06()  throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setStartDay(40);
		assertFalse(appt.getValid());
		appt.setStartDay(10);
		assertTrue(appt.getValid());
		appt.setStartDay(-2);
		assertFalse(appt.getValid());
	}

	@Test
	public void test07()  throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setStartMonth(2);
		appt.setStartDay(29);
		assertFalse(appt.getValid());
		appt.setStartYear(2020);
		assertTrue(appt.getValid());
	}



	@Test
	public void test08()  throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");
		int[] recurringDays = new int[0];

		appt.setRecurrence(recurringDays, 3, 1, 1000);

		assertTrue(appt.isRecurring());
	}

	@Test
	public void test09() throws Throwable {
		Appt appt = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		appt.setDescription(null);
		assertEquals("", appt.getDescription());
	}

	@Test
	public void test10() throws Throwable {
		Appt appt1 = new Appt(13, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(17, 30, 24, 2, 2019, "Birthday Party", "This is my birthday party.");

		int diff = appt2.compareTo(appt1);
		assertEquals(18, diff);
	}

	@Test
	public void test11() throws Throwable {
		Appt appt = new Appt(100, 35, 7, 1, 2018, "Birthday Party", "This is my birthday party.");

		assertEquals(null, appt.toString());
	}

	@Test
	public void test12() throws Throwable {
		Appt appt1 = new Appt(0, 0, 1, 1, 2018, "Birthday Party", "This is my birthday party.");

		assertTrue(appt1.getValid());

		Appt appt2 = new Appt(23, 59, 31, 12, 2018, "Birthday Party", "This is my birthday party.");

		assertTrue(appt2.getValid());
	}
}
package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void  addApptTest()  throws Throwable  {
 	  	 boolean pass = true;
 	  	 int size=0;
 	 	
 	 	 long randomseed =System.currentTimeMillis(); //10
 	 //	 System.out.println(" Seed:"+randomseed );
 		 Random random = new Random(randomseed);

		 GregorianCalendar day = new GregorianCalendar(2018,2,24);
		 CalDay testday = new CalDay(day);

		 for(int i=0; i<100000; i++){
		 	int startHour=ValuesGenerator.getRandomIntBetween(random, -30, 30);
			int startMinute=ValuesGenerator.getRandomIntBetween(random, -80, 80);
			int startDay=ValuesGenerator.getRandomIntBetween(random, -20, 40);
			//int startMonth=ValuesGenerator.getRandomIntBetween(random, -15, 15);
			int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
			int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2028);
			String title="Birthday Party";
			String description="This is my birthday party.";

			Appt appt = new Appt(startHour,
				       startMinute ,
				       startDay ,
				       startMonth ,
				       startYear ,
				       title,
				       description);

			testday.addAppt(appt);
			if(appt.getValid()){
				size++;
			}
			if(testday.getAppts().size()!=size){
				pass = false;
			}

		 }
		 int hour = 0;
		 for(int i=0; i<testday.getAppts().size(); i++){
		 	int temp = ((Appt)testday.getAppts().get(i)).getStartHour();
		 	if(temp<hour){
		 		pass = false;
		 	}else if(temp>hour){
		 		hour = temp;
		 	}
		 }
		 assertTrue(pass);
	 }


	
}
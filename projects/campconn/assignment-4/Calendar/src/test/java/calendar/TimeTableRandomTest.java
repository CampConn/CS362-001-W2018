package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void deleteApptTest()  throws Throwable  {

	  	 TimeTable timeTable=new TimeTable();
		 
		 boolean pass = true;
 	  	 int size=0;
 	  	 int index;
 	 	
 	 	 long randomseed =System.currentTimeMillis(); //10
 	 //	 System.out.println(" Seed:"+randomseed );
 		 Random random = new Random(randomseed);

		 GregorianCalendar day = new GregorianCalendar(2018,2,24);
		 CalDay testday = new CalDay(day);

		 int startHour;
		 int startMinute;
		 int startDay;
		 int startMonth;
		 int startYear;
		 String title;
		 String description;

		 LinkedList<Appt> res;
		 
		 for(int i=0; i<100000; i++){
		 	int listType=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 	int apptType=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 	
		 	Appt appt;
			LinkedList<Appt> appts = new LinkedList<Appt>();

		 	if(listType==1){
		 		appts = null;
		 	}else{
		 		for(int j=0; j<20; j++){
		 			startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
					startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
					startDay=ValuesGenerator.getRandomIntBetween(random, 1, 30);
					startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
					startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2028);
					title="Birthday Party";
					description="This is my birthday party.";

					appt = new Appt(startHour,
						       startMinute ,
						       startDay ,
						       startMonth ,
						       startYear ,
						       title,
						       description);
					appts.add(appt);
		 		}
		 	}
		 	if(apptType==1){
		 		appt = null;
		 	}else if(apptType==2 && listType!=1){
		 		size = appts.size();
		 		index = ValuesGenerator.getRandomIntBetween(random, 0, size-1);
		 		appt = appts.get(index);
		 	}else{
		 		startHour=ValuesGenerator.getRandomIntBetween(random, -30, 30);
				startMinute=ValuesGenerator.getRandomIntBetween(random, -80, 80);
				startDay=ValuesGenerator.getRandomIntBetween(random, -20, 40);
				startMonth=ValuesGenerator.getRandomIntBetween(random, -15, 15);
				startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2028);
				title="Birthday Party";
				description="This is my birthday party.";

				appt = new Appt(startHour,
					       startMinute ,
					       startDay ,
					       startMonth ,
					       startYear ,
					       title,
					       description);
		 	}
		 	res = timeTable.deleteAppt(appts, appt);
		 	if(appts==null || appt==null || !(appt.getValid())){
		 		if(res != null){
		 			pass = false;
		 		}
		 	}else if(apptType==2 && listType!=1){
		 		if(appts.size()!=size-1){
		 			pass = false;
		 		}
		 	}

		 }

		 
	 }

	 @Test
	  public void getApptRangeTest()  throws Throwable  {

	  	long TestTimeout = 60 * 500 * 1;

	  	long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");

		TimeTable timeTable=new TimeTable();

		long randomseed =System.currentTimeMillis(); //10
 	 //	 System.out.println(" Seed:"+randomseed );
 		 Random random = new Random(randomseed);

		int startHour;
		int startMinute;
		int startDay;
		int startMonth;
		int startYear;
		String title;
		String description;

		int day1;
		int month1;
		int year1;
		int day2;
		int month2;
		int year2;

	  	for (int iteration = 0; elapsed < TestTimeout; iteration++){
			Appt appt;
			LinkedList<Appt> appts = new LinkedList<Appt>();

	  		
			for(int j=0; j<20; j++){
		  		startHour=ValuesGenerator.getRandomIntBetween(random, -30, 30);
				startMinute=ValuesGenerator.getRandomIntBetween(random, -80, 80);
				startDay=ValuesGenerator.getRandomIntBetween(random, -20, 40);
				startMonth=ValuesGenerator.getRandomIntBetween(random, -15, 15);
				startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2028);
				title="Birthday Party";
				description="This is my birthday party.";

				appt = new Appt(startHour,
					       startMinute ,
					       startDay ,
					       startMonth ,
					       startYear ,
					       title,
					       description);
				appts.add(appt);
	  		}
	  		for(int j=0; j<20; j++){
	  			day1=ValuesGenerator.getRandomIntBetween(random, 1, 28);
	  			month1=ValuesGenerator.getRandomIntBetween(random, 1, 12);
	  			year1=ValuesGenerator.getRandomIntBetween(random, 2018, 2028);
	  			day2=ValuesGenerator.getRandomIntBetween(random, 1, 28);
	  			month2=ValuesGenerator.getRandomIntBetween(random, 1, 12);
	  			year2=ValuesGenerator.getRandomIntBetween(random, 2018, 2028);

	  			GregorianCalendar gregDay1 = new GregorianCalendar(year1,month1,day1);
	  			GregorianCalendar gregDay2 = new GregorianCalendar(year2,month2,day2);
	  			timeTable.getApptRange(appts,gregDay1,gregDay2);
	  		}
	  		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%100)==0 && iteration!=0 )
			    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	  	}
	  	System.out.println("Done testing...");
	  }



	
}

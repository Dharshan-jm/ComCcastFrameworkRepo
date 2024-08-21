package com.comcast.crm.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DemoCodeForDateAndMonth {

	public static void main(String[] args) {
		
		Date date=new Date();
		

		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		String actdate = simple.format(date);
		System.out.println(actdate);
		
	      Calendar cal = simple.getCalendar();
	      cal.add(Calendar.DAY_OF_MONTH,30);
	      
	      String requireddate = simple.format(cal.getTime());
	      System.out.println(requireddate);
	}

}
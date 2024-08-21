package com.castcast.crm.generic.webdrivereutlity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	// java related actions required for application

	public int getRandomNumber() {
		Random ran = new Random();
		int number = ran.nextInt(50000);
		return number;
	}

	public String getSystemDateYYYYDDMM() {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String result = simple.format(date);
		return result;
	}
	
	public String getRequiredDataYYYYDDMM(int days) {
		Date date = new Date();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		simple.format(date);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String result = simple.format(cal.getTime());
		return result;
	}

}

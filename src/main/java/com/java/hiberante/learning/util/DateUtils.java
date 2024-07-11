package com.java.hiberante.learning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
		
	public static  Date stringToDate(String  dateFormat) {	
		 Date date=null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy")
			        .parse(dateFormat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	

}

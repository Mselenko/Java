package task_1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MyDate {
	
	GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance(TimeZone.getTimeZone("Canada/Eastern"));
	
	private int year,month,day;
	
	
	public MyDate()
	{	
		this.year = gc.get(Calendar.YEAR);
		this.month = (gc.get(Calendar.MONTH))+1;
		this.day = gc.get(Calendar.DAY_OF_MONTH);
	}
	
	public MyDate(long elapsedTime)
	{
		setDate(elapsedTime);
	}
	
	public MyDate(int year, int month, int day)
	{
		this.year =year;
		this.month = month;
		this.day = day;
	}
	
	
	public long getYear() 
	{
		return this.year;
	}
	
	public long getMonth() 
	{
		return this.month;
	}
	
	public long getDay() 
	{
		return this.day;
	}
	
	public void setDate(long elapsedTime) 
	{
		gc.setTimeInMillis(elapsedTime);
		this.year = gc.get(Calendar.YEAR);
		this.month = (gc.get(Calendar.MONTH));
		this.day = gc.get(Calendar.DAY_OF_MONTH);
	}
	
	public void display()
	{
		System.out.print("The year is " + getYear() + " the month is " + getMonth() + " the day is " + getDay());
		System.out.println();
	}
		
}



package task_2;

public class Faculty extends Employee
{
private String hours, rank;
	
	public Faculty(String hours, String rank) 
	{
		super();
		this.hours = hours;
		this.rank = rank;
	}
	
	public String toString() 
	{
		return super.toString() + ", office hours is "+ this.hours + ", rank is "+this.rank;
	}

}

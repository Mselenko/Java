package task_2;

public class Staff extends Employee
{
 
private String title;
	
	public Staff(String title) 
	{
		super();
		this.title = title;
	}
	
	public String toString() 
	{
		return super.toString() + ", title is "+ this.title;
	}
}

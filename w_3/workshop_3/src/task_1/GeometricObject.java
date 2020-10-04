package task_1;

import java.util.Date;

abstract class GeometricObject 
{
	private String color;
	private boolean filled;
	private Date dateCreated;
	
	GeometricObject()
	{
		this.color = "white";
		this.filled = false;
		this.dateCreated = new Date();
	};
	
	GeometricObject(String color, boolean filled)
	{
		this.color= color;
		this.filled = filled;
		this.dateCreated = new Date();
			
	}
	
	public String getColor() 
	{
		return this.color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public boolean isFilled() 
	{
		return this.filled;
	}
	
	public void setFilled(boolean filled) 
	{
		this.filled = filled;
	}
	
	public Date getDateCreated()
	{
		return this.dateCreated;
	}
	
	public String toString() 
	{
		return "\nThe figure was created at "+ this.dateCreated + 
				" and has " +this.color +"color and is "+ (this.filled? "filled" : "not-filled");
	}
}

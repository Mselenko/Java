package task_1;

public class Triangle extends GeometricObject 
{
	private double side1,side2,side3;
	
	Triangle()
	{
		side1 = side2 = side3 = 1.0;
	}
	
	Triangle(double side1, double side2, double side3) 
	{ 
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	
	public double getArea() 
	{
		double s= this.getPerimeter()/2;
		return Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));		
	
	} 
	
	
	public double getPerimeter() 
	{
		return this.side1 + this.side2 + this.side3;
	}

	public String toString() 
	{
		System.out.println(super.toString());
		return "Triangle's: \nArea = " + this.getArea() 
		                  + "\nPerimeter = "+ this.getPerimeter();
	}
}
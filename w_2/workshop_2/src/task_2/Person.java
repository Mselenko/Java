package task_2;


public class Person 
{
	String name,address,phone_number,email;

	public Person(String name, String address, String phone_number, String email) 
	{
		this.name =name;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
	}
	
	
	public Person() 
	{
		this("Margarita Selenko", "Address", "PhoneNumber", "Email");
	}
	
	
	public String toString() 
	{
		return "Person name is " + this.name + " and class name is " + this.getClass().getSimpleName();
	}
	
	public String getName() 
	{
		return this.name;
	} 
	
}

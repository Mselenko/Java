package locker;

public class OpenedLockers {

	public static void main(String[] args) 
	{

	    boolean[] lockers = new boolean[100];
	    
	    for(int student = 1; student <= lockers.length; student++) 
	    {
	    	
	    	for(int l = student-1; l < lockers.length; l += student) 
	    		lockers[l] =!lockers[l];

	    }
	    
	    display(lockers);
	}

	public static void display(boolean[] lockers) 
	{
	    for (int i = 0; i < lockers.length; i++) 
	    {
	        if (lockers[i]) 
	            System.out.print("L" + (i + 1) + " ");
	    }
	}	
}

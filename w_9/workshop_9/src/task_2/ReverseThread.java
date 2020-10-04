package task_2;

public class ReverseThread  extends Thread
{
	private ReverseThread t[] = new ReverseThread[50];

	public void startrun() 
	{
		
		for(int i=0;i<50;i++)
		t[i]=new ReverseThread();

		for(int i=49;i>=0;i--) 
		{
			try 
			{
				Thread.sleep(10);
				
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			t[i].start();
		}
	}
	
	
	public void run()
	{		
		System.out.println("Hello from Thread: "+ (Thread.currentThread().getId()-10));
	}
	
	
	public static void main(String[] args)
	{
		ReverseThread tester = new ReverseThread();
		tester.startrun();
	}
}

package question4;

import java.util.ArrayList;

public class home {
	
	
	
	private int id;
	
	public home(int id)
	{
		this.id =id;
	}
	

	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		
		sqlConnection connect = new sqlConnection();
		connect.create();

		//connect.createNewTable();
		
		/*
		connect.insert("iphone", 1, 12000, "raw");
		connect.insert("Back Case", 2, 249, "manufactured");
		connect.insert("one plus", 2, 37000, "imported");
		
		
		
		connect.insert("Acer", 1, 63000, "raw");
		connect.insert("Dell", 2, 70000, "imported");
		
		*/
		
		
		// connect.select();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					connect.select();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		
				
	});
		
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					connect.CalculateTaxAndUpdatePrice();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		});

		t1.start();
		t2.start();
		
		  t1.join(); 
	      t2.join();
	      
	      
	      for(items i1: connect.finalPrizedItems)
	      {
	    	  System.out.println(i1.toString());
	      }
	      
}
}

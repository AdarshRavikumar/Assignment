package question1;

import java.util.*;

public class home {

	private String name,type;
	private int quant;
	private float price;
	
	public item Assign(item obj[],String args[],int obj_count) {
		 /**
		  *  In Args , the even places are -name, -type , -price etc...
		  *  These become key for the hashmap and odd places are the actual names, price,etc
		  */
	
		int flag=0;
		Map<String, String> input = new HashMap<String, String>();
		
		for(int k=0;k<args.length;k+=2)
			input.put(args[k],args[k+1]);
		
		name = input.get("-name");
		
		if(input.get("-price")==null)
			price=0;
		else 
			price = Float.parseFloat(input.get("-price"));
		
		if(input.get("-type")==null) {
			System.out.println("Type of object missing ");
			flag=1;
		}
		else if (input.get("-type").equals("raw") || input.get("-type").equals("manufactured") || input.get("-type").equals("imported"))
			type = input.get("-type");
		else
			System.out.println("The Type of material Doesnt Exist . it should be one of [raw, manufactured, imported]");
		
		if(input.get("-quant")==null)
			quant=0;
		else
			quant = Integer.parseInt(input.get("-quant"));
		
		item newObject = null;
		if(flag==0) {
			
		newObject=new item(name,quant,price, type);
		obj[obj_count++]=newObject;
		}
		
		/**
		 * The newObject is Returned for testing Purpose
		 */
		
		return newObject;
	 }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter -name<Item Name> -price<Item Price> -quant<Item Quantity> -type<Item type> ");
		int obj_count=0;
		
		item obj[] = new item[100];
		
		home asn = new home();
		asn.Assign(obj, args, obj_count++);
		Scanner sc = new Scanner(System.in);
		String ch;	
		
		while(true) {
			System.out.println("You want to continue ? Y or N");
			ch= sc.nextLine();
			
			if(ch.equals("N") || ch.equals("n"))
				break;
			
			System.out.println("Enter Following Details Name, Price(The value should be in decimal ex: 100.0 or 123.4 etc), Quant, type[raw,manufactured,imported]");
			String inp = sc.nextLine();
			String arr[]=inp.split(" ");
			asn.Assign(obj, arr, obj_count++);	
	    }
		
		// Printing objects
		for(int j=0;j<obj_count;j++) {
			if(obj[j]!=null)
				System.out.println(obj[j]);
		}
		
		

	}

}


